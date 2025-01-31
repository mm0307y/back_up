import React, { useEffect } from 'react'
import { useNavigate } from 'react-router'

const LoginPage1206 = ({ authLogic1206 }) => {
  const navigate = useNavigate()
  const moveNews = (userId) => {
    console.log("moveNews호출")
    // 뉴스페이지로 이동하기
    navigate({ pathname: '/news/' + userId })
  }

  // 이벤트 핸들러(onClick-대소문자를 구분해야 한다.)를 호출 할 때 파라미터에 event객체 자동 주입해준다.
  const handleLogin = (event) => {
    console.log('구글 로그인 호출')

    // to do -  성공하면 해커뉴스 목록 페이지로 이동
    authLogic1206.login('Google')
      // .then(data => console.log(data))
      .then(data => moveNews(data.user.uid))
  }

  useEffect(() => {
    // 사용자가 바뀌게 되면 처리하기
    authLogic1206.onAuthChange(user => {
      // 사용자가 있다면 로그인 거치지 않고 바로 NewsPage로 이동하기
      user && moveNews(user.uid)
    })
  })

  return (
    <>
      <h2>로그인</h2>
      <button onClick={handleLogin}>Google</button>
    </>
  )
}

export default LoginPage1206
