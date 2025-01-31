import axios from 'axios'
import React, { useEffect } from 'react'
import { useLocation, useNavigate } from 'react-router'

const KakaoCallback0103 = () => {
  const navigate = useNavigate()
  // window.location 보다 리액트에서 제공하는 객체 사용하기
  const location = useLocation()
  const code = new URLSearchParams(location.search).get('code')
  console.log(`카카오에서 redirect_url로 보내준 code값은 : ${code}`)
  useEffect(() => {
    const asyncAuth = async () => {
      try {
        // Access Token 가져오기
        const res1 = await axios.post("https://kauth.kakao.com/oauth/token", null, {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
          },

          params: {
            grant_type: "authorization_code",
            client_id: "6b10a8106270f172344447e5cec8953b",
            redirect_uri: "http://localhost:3000/auth/kakao/callback",
            code: code,
          }
        })
        console.log(res1.data)
        const accessToken = res1.data.access_token;
        console.log("Access Token : ", accessToken)

        // Access Token을 이용해 사용자 정보 가져오기
        const res2 = await axios.get("https://kapi.kakao.com/v2/user/me", {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
            "Authorization": "Bearer " + accessToken
          }
        })
        console.log(res2.data)
        localStorage.setItem("nickname", res2.data.properties.nickname)
        navigate("/")
      } catch (error) {
        console.error(error)
      }
    }
    asyncAuth()
  }, []) // 의존성 배열이 빈통이면 최초 딱 한번만 실행이 된다.
  return (
    <>
      <div>KakaoCallback0103</div>
    </>
  )
}

export default KakaoCallback0103

/*
  1. const uri =  https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=6b10a8106270f172344447e5cec8953b&redirect_uri=http://localhost:5000/auth/kakao/callback 요청 발생
  버튼이나 <button onClick="">카카오 로그인</button>
  a태그 <a href=uri>카카오로그인 버튼, 이미지</a>

  카카오서버에서 음답으로 요청하는 URL로 부터 쿼리스트링에 붙어 있는 code값을 추출한다.
  
*/