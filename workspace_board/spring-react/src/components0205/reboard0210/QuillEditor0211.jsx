import React, { useCallback, useMemo } from 'react'
import ReactQuill from 'react-quill';
import { uploadImageDB } from '../../service0205/dbLogic0205'
// import { ImageResize } from 'quill-image-resize-module-react';
// Quill.register('modules/ImageResize', ImageResize);

// QuillEditor는 b_content랑 관계가 있다. - 색상, 이미지 처리, 들여쓰기 등등 이지웍
// select로 조회한 결과에 b_content부분에 대한 값을 props로 받는다. - value
// spring을 활용한 파일 추가와 이미지 추가 처리
const QuillEditor0211 = ({value, handleContent, quillRef}) => {
  // QuillEditor에서 이미지를 누르면 호출되는 함수
  // 내용을 작성하고 내용이 변경될 때 마다 상태값이 바뀌면 화면을 새로 렌더링한다. - useState
  // 같은 역할을 수행하는 imageHandler함수가 매번 새로 만들어진다.
  // 리액트에서는 재조정이라고 한다. - useMemo(필드를 메모이제이션한다.), useCallback(함수를 메모이제이션한다.)
  // 함수 하나만 생성해서 그 함수로 사용하기 위해서 useCallback() 사용하였다.

  const imageHandler = useCallback(() => {
      /* 이미지를 선택하고 열기를 눌렀을 때 생성되는 DOM입니다, 이미지 파일이 있을 때 호출 */
      /* 리액트에서는 html에서와 같이 form태그 전송이 불가하다. */
      const formData = new FormData() // 이미지를 url로 바꾸기 위해서 express서버의 uploads 폴더로 전달할 폼데이터 만들기

      // 이미지 버튼이 클릭되면 이미지를 서버로 전송하기 위해서 동적으로 type이 file인 input태그를 생성한다.
      const input = document.createElement('input') // input태그를 DOM API를 활용하여 동적으로 생성하기 - 자바 스크립트 사용한다. - DOM API
      // 8000번으로 요청을 보낸다.
      // @PostMapping("board/imageUpload")
      // public String imageUpload(@RequestParam(value = "image") MultipartFile image) {
      // <input type="file" 'accept="image/png' name="image"
      input.setAttribute('type', 'file')
      input.setAttribute('accept', 'image/*') // 이미지 파일만 선택가능하도록(받기 위해 main type은 image) 제한한다.
      input.setAttribute('name', 'image')
      input.click() // input file의 클릭이 발생하도록 강제한다.
  
      /* 선택한 파일의 type이 file이다. */
      // 파일 선택창에서 이미지를 선택하면 실행될 콜백 함수를 등록한다.
      input.onchange = async () => {
        try {
          const file = input.files[0]
          if (!file) {
            alert("파일이 선택되지 않았습니다.")
            return; // 함수 탈출
          }
          // 이미지는 jpg, png, jpeg만 지원한다.
          const fileType = file.name.split('.').pop().toUpperCase() // PNG
          console.log(fileType) // PGN, JPG, JPEG
  
          // 파일 확장자 검증 코드가 필요하다.
          if (!['JPG', 'PNG', 'JPEG'].includes(fileType)) {
            alert("jpg, png, jpeg 형식만 지원합니다.")
            return;
          }
  
          formData.append('image', file) // 위에서 동적으로 만드는 폼 데이터에 이미지 추가 400 Bad Request
          for (let pair of formData.entries()) {
            console.log(pair[0], pair[1])
          }
  
          // 폼 데이터를 express 서버(5000)에 넘겨서 이미지 위치의 URL 받아오기
          const res = await uploadImageDB(formData)
          // 5000번 서버가 응답으로 보내는 URL은 uploads/파일명.사용자가 선택한 이미지의 확장자가 온다.
          // http://localhost:5000/+res.data
          console.log(res.data) // http://localhost:5000/uploads/실제이름이 아니라 새이름으로.확장자명
          if (!res.data) {
            alert("이미지 업로드에 실패하였습니다.")
            return
          }
  
          // 이미지 URL생성
          const url = `${process.env.REACT_APP_SPRING_IP}api/board/imageGet?imageName=${res.data}`;
          console.log(`Uploaded Image URL: ${url}`);
          const quill = quillRef.current.getEditor()
  
          /* ReactQuill 노드에 대한 Ref가 있어야 메서드들을 호출할 수 있으므로
          useRef()로 ReactQuill에 ref를 걸어주자.        
          getEditor(): 편집기를 지원하는 Quill 인스턴스를 반환한다.
          여기서 만든 인스턴스로 getText()와 같은 메서드를 사용할 수있다.
          Quillwrite에서 props로 넘겨받은 quillRef 사용한다.
          */
  
          // getSelection()은 현재 선택된 범위를 리턴한다. 에디터가 포커싱되지 않았다면 null을 반환한다.
          const range = quill.getSelection().index
          if (typeof range !== 'number') {
            alert("에디터에 포커스가 필요합니다.")
            return
          }
  
          /* range는 0이 될 수도 있으므로 null만 생각하고 !range로 체크하면 잘못 작동할 수 있다.
          따라서 타입이 숫자이지 않을 경우를 체크해 리턴해 주었다. */
  
          quill.setSelection(range, 1)
  
          /* 사용자 선택을 지정된 범위로 설정하여 에디터에 포커싱할 수 있다.
          위치 인덱스와 길이를 넣어주면 된다. */
          quill.clipboard.dangerouslyPasteHTML(
            range,
            `<img src=${url} style="width: 100%;height: auto;" alt="image" />`)
          // handleFiles(res.data, `${Math.floor(file.size/(1024*1024)*10)/10}MB`)
        }
        catch (error) {
          console.error("이미지 업로드 중 오류 발생 : ", error)
          alert("이미지 업로드 중 오류가 발생하였습니다.")
        }
      } // end of onchange event, 주어진 인덱스에 HTML로 작성된 내용물을 에디터에 삽입한다.
    }, [quillRef]) // end of imageHandler
  
    // 메모이제이션 이란?
    // 변수 - useMemo
    // 함수 - useCallback
    const modules = useMemo(
      () => ({
        toolbar: { // 툴바에 넣을 기능들을 순서대로 나열하면 된다.
          container: [
            [{ 'header': [1, 2, 3, 4, 5, 6, false] }, { color: [] }, { 'align': [] }, { 'background': [] }],
            ["bold", "italic", "underline", "strike", "blockquote"],
            [
              { list: "ordered" },
              { list: "bullet" },
              { indent: "-1" },
              { indent: "+1" },
            ],
            ['clean'],
            ['link', "image"],
          ],
          handlers: { // 위에서 만든 이미지 핸들러 사용하도록 설정
            image: imageHandler,
          },
        },
      }), [imageHandler])
    const formats = [
      //'font',
      'header',
      'bold', 'italic', 'underline', 'strike', 'blockquote',
      'list', 'bullet', 'indent',
      'link', 'image',
      'align', 'color', 'background',
    ]
    return (
      <div style={{ height: "550px", display: "flex", justifyContent: "center", padding: "0px" }}>
        <ReactQuill
          ref={quillRef}
          style={{ height: "470px", width: "100%" }}
          theme='snow'
          modules={modules}
          formats={formats}
          value={value}
          onChange={(content, delta, source, editor) => { handleContent(editor.getHTML()); }} />
      </div>
    )
}

export default QuillEditor0211