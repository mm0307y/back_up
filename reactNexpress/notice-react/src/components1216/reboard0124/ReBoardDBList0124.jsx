import React, { useEffect, useState } from 'react'
import Header1216 from '../include1216/Header1216'
import Footer1216 from '../include1216/Footer1216'
import { useNavigate } from 'react-router'
import { reBoardListDB } from '../../service1216/dbLogic1218'

const ReBoardDBList0124 = () => {
  const navigate = useNavigate()
  const [boards, setBoards] = useState([])
  // 목록 페이지를 열자마자 DB를 경유하는 코드는 어디서 어떻게 작성할까?
  useEffect(() => {
    const asyncDB = async () => {
      const board = { gubun: null, keyword: null }
      const res = await reBoardListDB(board)
      console.log(res.data)
      setBoards(res.data)
    }
    asyncDB()
  }, []) // 주의 사항 : 의존성 배엘 useState를 넣을 때는 무한루프에 빠질 수 있다.

  const boardSearch = () => {

  } // end of boardSearch

  const boardList = () => {

  } // end of boardList


  return (
    <>
      <Header1216 />
      <div className='container'>
        <div className='page-header'>
          <h2>댓글 게시판 <small>POJO기반</small></h2>
          <hr />
        </div>

        <div className="row">
          <div className="col-sm-3">
            <select className="form-select" id="gubun">
              <option value="">분류선택</option>
              <option value="b_title">제목</option>
              <option value="b_writer">작성자</option>
              <option value="b_content">내용</option>
            </select>
          </div>

          <div className="col-sm-6">
            <input type="text" className="form-control" placeholder="검색어를 입력하세요" id="keyword" />
          </div>
          <div className="col-sm-3">
            <button type="button" className="btn btn-danger" onClick={boardSearch} >검색</button>
          </div>
        </div>

        <table className="table table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>제목</th>
              <th>작성자</th>
            </tr>
          </thead>
          {/* 데이터셋 연동하기 */}
          {/* props로 넘어온 상태값이 빈 깡통이면 실행하지 않기 */}
          <tbody>
            {
              boards.map((board, index) => (
                <li>{board.b_title}</li>
              ))}
          </tbody>
          {/* 데이터셋 연동하기 */}
        </table>
        <div className='d-flex justify-content-center'>
          1 2 3
        </div>

        <hr />
        <div className='list-footer'>
          <button className="btn btn-outline-primary" onClick={boardList}>전체조회</button>
          &nbsp;
          <button className="btn btn-outline-info" onClick={() => navigate("/reboard/write")}>글쓰기</button>
        </div>
      </div>
      <Footer1216 />
    </>
  )
}

export default ReBoardDBList0124