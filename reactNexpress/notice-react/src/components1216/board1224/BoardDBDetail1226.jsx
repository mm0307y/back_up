import React, { useEffect, useState } from 'react'
import Header1216 from '../include1216/Header1216'
import Footer1216 from '../include1216/Footer1216'
import { ContainerDiv, FormDiv, HeaderDiv } from '../../styles1226/FormStyles'
import { useLocation, useParams } from 'react-router'
import { boardDetailDB } from '../../service1216/dbLogic1218'
import BoardHeader1226 from './BoardHeader1226'

const BoardDBDetail1226 = () => {
  const location = useLocation()
  // url에서 b_no값 받아오기 
  let { b_no } = useParams()
  console.log("사용자가 선택한 글 번호 : " + b_no)
  const queryParams = new URLSearchParams(location.search)
  const page = queryParams.get(`page`) || 1
  const [board, setBoard] = useState({})

  // useEffect는 최초 한번만 실행이 된다. - 의존성 배열이 빈 값이면
  // hashchange 값이 변하면 새로운 상세보기 내용을 처리해야 한다.
  useEffect(() => {
    const asyncDB = async () => {
      const res = await boardDetailDB(b_no)
      console.log(res.data)
      setBoard(res.data)
    }
    asyncDB()
  }, [b_no]) // 의존성 배열을 반드시 작성할 것. - 안하면 최초 한번만 실행되고 그 다음부터는 실행이 안된다. - 보던 화면만 계속 보게 된다.

  return (
    <>
      <Header1216 />
      <ContainerDiv>
        <HeaderDiv>
          <h3>게시글 상세보기</h3>
        </HeaderDiv>
        <FormDiv>
          <BoardHeader1226 board={board} b_no={b_no} page={page} />
          <section>
            <div dangerouslySetInnerHTML={{ __html: board.b_content }}></div>
          </section>
          <hr style={{ height: "2px" }} />
        </FormDiv>
      </ContainerDiv>
      <Footer1216 />
    </>
  )
}

export default BoardDBDetail1226