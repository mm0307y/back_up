import React from 'react'
import { useLocation } from 'react-router'
import GymSignup0103 from './GymSignup0103'
import Signuptype0103 from './Signuptype0103'

const SignupPage0103 = () => {
  const location = useLocation()
  // URLSearchParams를 활용하여 쿼리 스트링추출하기
  const quretyParams = new URLSearchParams(location.search)
  const type = quretyParams.get("type") // type의 파라미터 값 가져오기

  // http://localhost:3000/login/signup?type=member
  // http://localhost:3000/login/signup?type=teacher
  console.log(type)

  // 선택을 해야 한다.(회원인지, 코치인지)
  // 선택에 따라 페이지가 달라야 한다. - if문
  const choicPage = () => {
    if (type) {
      return <GymSignup0103 />
    }
    else {
      return <Signuptype0103 />
    }
  }

  return (
    choicPage()
  )
}

export default SignupPage0103