// rafce 단축 명령어
import React from 'react'
import Header0102 from '../include0102/Header0102'
import Footer0102 from '../include0102/Footer0102'

const LoginPage0102 = () => {
  const kakaoURL = 'https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=6b10a8106270f172344447e5cec8953b&redirect_uri=http://localhost:3000/auth/kakao/callback';
  // 카카오 인증 코드 가져오기
  const handleKakaoLogin = () => {
    try {
      window.location.href = kakaoURL; // 브라우저 리다이렉션(axios, requests, fetch 사용하면 안된다.)
    } catch (error) {
      console.error("인증코드 받기 실패 ", error)
    }
  } //// end of handleKakaoLogin
  window.handleKakaoLogin = handleKakaoLogin;

  return (
    <>
      <Header0102 />
      <div className="row my-5 justify-content-center">
        <div className="col-8 col-md-6 col-lg-4">
          <h3 className="text-center mb-5">로그인</h3>
          <form name="frm" method="post">
            <div className="input-group my-2">
              <div className="input-group-text">이 메 일</div>
              <input className="form-control" name="email" value="tomato@hot.com" />
            </div>
            <div className="input-group">
              <div className="input-group-text">비밀번호</div>
              <input className="form-control" name="password" type="password" value="12345678" />
            </div>
            <div className="my-3">
              <button className="btn btn-success w-100">로그인</button>
            </div>
            <div className="text-end mt-3"><a href="/users/join">회원가입</a></div>
          </form>
          {/* 카카오 로그인 버튼 추가 */}
          <div className="my-3">
            <button onClick={handleKakaoLogin} style={{ border: "none", outline: "none", background: "none" }}>
              <img width="410px" height="42px" src="/images/kakao0102/ko/kakao_login_medium_wide.png" alt="카카오로그인" />
            </button>
          </div>
          {/* 카카오 로그인 버튼 추가 */}
        </div>
      </div>
      <Footer0102 />
    </>
  )
}

export default LoginPage0102

