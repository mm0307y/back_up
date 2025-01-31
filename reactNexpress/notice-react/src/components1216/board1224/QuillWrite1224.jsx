import React, { useCallback, useRef, useState } from 'react'
import QuillEditor1224 from './QuillEditor1224'

const QuillWrite1224 = () => {
  const quillRef = useRef();
  const [content, setContent] = useState('');

  // useCallback은 함수 메모이제이션에 사용하고 useMemo는 값 메모이제이션에 사용한다.
  // 둘 다 리액트 최적화에 중요한 훅입니다.
  const handleContent = useCallback((value) => {
    console.log(value)
    setContent(value)
  })

  return (
    <>
      <div><h1>글내용 쓰기</h1></div>
      <QuillEditor1224 value={content} handleContent={handleContent} quillRef={quillRef} />
    </>
  )
}

export default QuillWrite1224