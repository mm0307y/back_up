import React, { useEffect, useState } from 'react'
import Header1216 from '../include1216/Header1216'
import { BButton, CommentArea, ContainerDiv, FormDiv, HeaderDiv } from '../../styles1226/FormStyles'
import Footer1216 from '../include1216/Footer1216'
import ReBoardHeader0131 from './ReBoardHeader0131'
import { useParams } from 'react-router'
import { reBoardDetailDB, reCommentInsertDB, reCommentUpdateDB } from '../../service1216/dbLogic1218'

// 게시글 상세보기 - 댓글보기와 댓글 쓰기 화면 포함한다.
const ReBoardDBDetail0131 = () => {
  const { b_no } = useParams()
  console.log("b_no : " + b_no)
  const queryParams = new URLSearchParams(window.location.search)

  // 만일 page 값이 null 이거나 undefined 일 때 1반환
  const page = queryParams.get(`page`) || 1

  // 댓글 내용을 담을 훅
  const [comment, setComment] = useState();

  // 한 건조회한 결과를 담을 훅
  const [board, setBoard] = useState({
    B_NO: 0,
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
      const res = await reBoardDetailDB(b_no)
      console.log(res.data) // [{}, COMMENT : [{}, {}, {}, ...]]
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
      <Header1216 />
      <ContainerDiv>
        <HeaderDiv>
          <h3>게시글 상세보기</h3>
        </HeaderDiv>
        <FormDiv>
          <ReBoardHeader0131 board={board} b_no={b_no} page={page} />
          <section>
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
      <Footer1216 />
    </>
  )
}

export default ReBoardDBDetail0131