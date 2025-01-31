import React, { useCallback, useEffect, useRef, useState } from 'react'
import { boardDetailDB, boardUpdateDB } from '../../service1216/dbLogic1218'
import { useNavigate, useParams } from 'react-router'
import Footer1216 from '../include1216/Footer1216'
import QuillEditor1224 from './QuillEditor1224'
import { BButton, ContainerDiv, FormDiv, HeaderDiv } from '../../styles1226/FormStyles'
import Header1216 from '../include1216/Header1216'

const BoardDBUpdate1226 = () => {
  const navigate = useNavigate()
  const { b_no } = useParams()
  console.log(b_no) // 사용자가 선택한 글 번호
  const [title, setTitle] = useState('') // 글 제목
  const [content, setContent] = useState('') // 글 내용
  const [writer, setWriter] = useState('') // 글 작성자
  const quillRef = useRef()

  useEffect(() => {
    const asyncDB = async () => {
      const res = await boardDetailDB(b_no)
      console.log(res.data)
      setTitle(res.data.b_title)
      setContent(res.data.b_content)
      setWriter(res.data.b_writer)
    }
    asyncDB()
  }, [setTitle, setContent, setWriter])

  // 함수를 메모이제이션 처리할 때 useCallback 훅을 사용한다.
  // BoardDbUpdate는 함수이지만 return에서 멀티 앨리먼트를 갖고 있어서 화면을 출력한다.
  // 이 함수는 props나 state가 변하면 새로 렌더링을 한다.
  // 새로 렌더링이 일어날 때마다 함수가 매번 새로 만들어진다. - 비효율적이다.
  // 메모이제이션을 처리한다.
  const handleTitle = useCallback((value) => {
    setTitle(value)
  }, [])

  const handleWriter = useCallback((value) => {
    setWriter(value)
  }, [])

  const handleContent = useCallback((value) => {
    setContent(value)
  }, [])

  const boardUpdate = async () => {
    const board = {
      b_no: b_no,
      b_title: title,
      b_writer: writer,
      b_content: content
    }
    const res = await boardUpdateDB(board)
    navigate('/board?page=1')
  } //// end of boardUpdate

  return (
    <>
      <Header1216 />
      <ContainerDiv>
        <HeaderDiv>
          <h3>게시글 수정</h3>
        </HeaderDiv>
        <FormDiv>
          <div style={{ width: "100%", maxWidth: "2000px" }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '5px' }}>
              <h2>제목</h2>
              <div style={{ display: 'flex' }}>
                <BButton style={{ marginLeft: '10px' }} onClick={boardUpdate}>글 수정</BButton>
              </div>
            </div>
            <input id="dataset-title" type="text" maxLength="50" placeholder="제목을 입력하세요." value={title}
              style={{ width: "100%", height: '40px', border: '1px solid lightGray' }} onChange={(e) => { handleTitle(e.target.value) }} />
            <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '5px', marginTop: '5px' }}>
              <h2>작성자</h2>
            </div>
            <input id="dataset-writer" type="text" maxLength="20" placeholder="작성자를 입력하세요." value={writer}
              style={{ width: "200px", height: '40px', border: '1px solid lightGray' }} onChange={(e) => { handleWriter(e.target.value) }} />
            <hr style={{ margin: '10px 0px 10px 0px' }} />
            <h3>상세내용</h3>
            <QuillEditor1224 value={content} handleContent={handleContent} quillRef={quillRef} />
          </div>
        </FormDiv>
      </ContainerDiv>
      <Footer1216 />
    </>
  )
}

export default BoardDBUpdate1226