import React, { useEffect } from 'react'
import NewsHeader1206 from '../include1206/NewsHeader1206'
import NewsFooter1206 from '../include1206/NewsFooter1206'
import { useNavigate } from 'react-router'

const NewsPage1206 = ({ authLogic1206 }) => {
  // 리액트에서는 SPA를 기본으로 한다. -href쓰시면 안된다.
  // href대신에 react-router제공하는 useNavigate()훅(Hook)을 이용해서 이동할것.
  const navigate = useNavigate()

  // 로그아웃 함수 구현하기 - 로그인 성공시에 이동하는 페이지 이므로 여기서 한다.
  const onLogout = () => {
    console.log("NewsPage onLogout 호출")
    authLogic1206.logout()
  }

  // 최초 이페이지가 렌더링 될 때 한번 로그인 상태를 체크하는 onAuthChange호출한다.
  // 로그인 유지되고 있는지 아니면 로그인이 풀린 상태인지 체크
  useEffect(() => {
    // 사용자가 바뀌게 되면 처리하기
    authLogic1206.onAuthChange(user => {
      if (!user) {
        navigate("/") // LoginPage.jsx호출- return아래 코드 진행- 출력
      }
    })
  })
  
  return (
    <>
      <NewsHeader1206 onLogout={onLogout} />
      <h1>뉴스 페이지</h1>
      <NewsFooter1206 />
    </>
  )
}

export default NewsPage1206
