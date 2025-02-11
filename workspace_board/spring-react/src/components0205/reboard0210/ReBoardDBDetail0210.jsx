import React, { useEffect, useState } from 'react'
import Header0205 from "../include0205/Header0205";
import { BButton, CommentArea, ContainerDiv, FormDiv, HeaderDiv } from '../../styles0210/FormStyles'
import Footer0205 from "../include0205/Footer0205";
import ReBoardHeader0210 from './ReBoardHeader0210'
import { useParams } from 'react-router'
import { boardDetailDB, reCommentInsertDB, reCommentUpdateDB } from '../../service0205/dbLogic0205'

// 게시글 상세보기 - 댓글보기와 댓글 쓰기 화면 포함한다.
const ReBoardDBDetail0210 = () => {
  // 상세보기 이므로 한 건에 대한 조회 결과 이다.
  const { b_no } = useParams()
  console.log("b_no : " + b_no)
  
  // ? 쿼리스트링을 가져오는 코드 : 페이징 처리 (현재 페이지 정보 기억)
  // location 앞에 window가 상위 객체이다. - 카카오 -> global참조
  const queryParams = new URLSearchParams(window.location.search)

  // 만일 page 값이 null 이거나 undefined 일 때 1반환
  const page = queryParams.get(`page`) || 1

  // 댓글 내용을 담을 훅
  const [comment, setComment] = useState();

  // 한 건조회한 결과를 담을 훅 - 훅이 변하면 화면을 다시 랜더링한다. = SPA(싱글페이지 애플리케이션) - a 태그(URL이 끊기고 새롭게 랜더링을 하기 때문에 안된다.)
  // 이른, 게으른 한 번 생각해 보기 -> location.href 사용하면 SPA가 아니다.
  const [board, setBoard] = useState({
    B_NO: 0, // DB에서 가져온 값을 담는 변수 - 대문자 인 이유는 myBatis 디폴트 값이다. toUppercase
    B_TITLE: "",
    EMAIL: "",
    B_CONTENT: "",
    B_DATE: "",
    B_HIT: 0,
  })

  // 이 글에 대한 댓글을 담을 훅을 선언
  const [comments, setComments] = useState([])

  // 이 화면이 렌더링 될 때 훅 초기화 하기
  useEffect(() => {
    const boardDetail = async () => {
      const res = await boardDetailDB(b_no)
      console.log(res.data) // [{}, comments : [{}, {}, {}, ...]]
      setBoard(res.data[0])

      // 댓글이 존재 할 경우만 훅에 초기화
      if (res.data[1]) {
        setComments(res.data[1].COMMENT)
      }
    }
    boardDetail();
  }, [b_no])

  const commentInsert = async () => {
    if (!comment) return alert("댓글을 작성하세요.")
    const cmt = {
      b_no: b_no,
      email: localStorage.getItem("email"),
      bc_comment: comment,
    }
    await reCommentInsertDB(cmt)
    console.log("댓글이 등록 되었습니다.")
  }

  const commentUpdate = async (bc_no) => {
    console.log("commentUpdate bc_no : " + bc_no)

    // insert here
    const cmt = {
      b_no: b_no, // 부모글에 대한 번호
      bc_email: localStorage.getItem("email"), // 작성자
      bc_comment: comment, // 수정된 애용
      bc_no: bc_no // 한 건에 대한 수정 처리 - pk
    }
    await reCommentUpdateDB(cmt)
    console.log("답변이 수정 되었습니다.")
  } // end of commentUpdate

  return (
    <>
      <Header0205 />
      <ContainerDiv>
        <HeaderDiv>
          <h3>게시글 상세보기</h3>
        </HeaderDiv>
        <FormDiv>
          <ReBoardHeader0210 board={board} b_no={b_no} page={page} />
          <section>
            {/* QuillEditor 사용하면 <p></p> */}
            <div dangerouslySetInnerHTML={{ __html: board.B_CONTENT }}></div>
          </section>
          <hr style={{ height: "2px" }} />
          <div>
            <h3>댓글작성</h3>
            <div style={{ display: 'flex' }}>
              <textarea style={{ width: '100%', resize: 'none', border: '1px solid lightgray', borderRadius: '10px', padding: '5px' }}
                onChange={(e) => { setComment(e.target.value) }}
              />
              <BButton style={{ height: '60px', marginLeft: '10px' }} onClick={() => { commentInsert() }}>작성</BButton>
            </div>
          </div>
          <hr style={{ height: "2px" }} />
          {/* 댓글 목록 보기 */}
          <div>
            {/* 댓글이 존재하지 않으면 undefined */}
            {comments && comments.map((item, index) => {
              <div key={index}>
                <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '10px' }}>
                  <div style={{ display: 'flex', flexDirection: 'column', fontSize: "16px" }}>
                    <span>작성일 : {item.BC_DATE}</span>
                    <span>작성자 : {item.MEM_NICKNAME}</span>
                  </div>
                  <div>
                    <BButton>답변</BButton>
                    <BButton onChange={() => commentUpdate(`${item.BC_NO}`)}>수정</BButton>
                  </div>
                </div>
                <div>
                  <CommentArea defaultValue={item.BC_COMMENT} onChange={(event) => { setComment(event.target.value) }} />
                </div>
              </div>
            })}
          </div>
          {/* 댓글 목록 보기 */}
        </FormDiv>
      </ContainerDiv >
      <Footer0205 />
    </>
  )
}

export default ReBoardDBDetail0210