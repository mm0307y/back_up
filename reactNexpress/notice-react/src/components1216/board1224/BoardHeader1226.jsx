import React from 'react'
import { BButton } from '../../styles1226/FormStyles'
import { useNavigate } from 'react-router';
import { boardDeleteDB } from '../../service1216/dbLogic1218';

const BoardHeader1226 = ({ board, b_no, page }) => {
  const navigate = useNavigate();

  const boardDelete = () => {
    const asyncDB = async () => {
      const res = await boardDeleteDB(b_no)
      console.log(res.data)
    }
    asyncDB()
    // navigate(`/board`)
    window.location.href = '/board'
  }

  const boardList = () => {
    navigate(`/board?page=${page}`)
  }

  return (
    <>
      <div style={{ display: 'flex', flexDirection: 'column', width: '100%' }}>
        <div style={{ display: 'flex', justifyContent: "space-between" }}>
          <div style={{ overflow: "auto" }}>
            <span style={{ marginBottom: '15px', fontSize: "30px", display: "block" }}>
              {board.b_title}
            </span>
          </div>
          {
            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
              <BButton style={{ margin: '0px 10px 0px 10px' }} onClick={() => { navigate(`/board/update/${b_no}`) }}>
                수정
              </BButton>
              <BButton style={{ margin: '0px 10px 0px 10px' }} onClick={() => { boardDelete() }}>
                삭제
              </BButton>
              <BButton style={{ margin: '0px 10px 0px 10px' }} onClick={boardList}>
                목록
              </BButton>
            </div>
          }
        </div>
        <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '14px' }}>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <span>작성자 : {board.b_writer}</span>
            <span>작성일 : {board.b_date}</span>
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', marginRight: '10px' }}>
            <div style={{ display: 'flex' }}>
              <span style={{ marginRight: '5px' }}>조회수 :</span>
              <div style={{ display: 'flex', justifyContent: 'flex-end', width: '30px' }}>{board.b_hit}</div>
            </div>
          </div>
        </div>
      </div>
      <hr style={{ height: "2px" }} />
    </>
  )
}

export default BoardHeader1226


/* 
  댓글 관련 코드
<div style={{ display: 'flex' }}>
              {board.COMMENT ? <>
                <span style={{ marginRight: '5px' }}>댓글수 :</span>
                <div style={{ display: 'flex', justifyContent: 'flex-end', width: '30px' }}>{board.COMMENT}</div>
              </> : <></>}
            </div>
             */