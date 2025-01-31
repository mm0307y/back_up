import React, { useEffect, useState } from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import AuthLogic0120, { logout } from '../../service1216/authLogic0120'

const Header1216 = () => {
  const userAuth = useSelector(state => state.userAuth) // authLogic.js 에서 auth정보를 가져오는 코드
  // Header 함수가 최초 호출되면 email 상태값은 빈문자열이다. 
  const [email, setEmail] = useState('') // 디폴트 문자열을 가진다. -> 로그인 -> localStorage
  const [isLoggedIn, setIsLoggedIn] = useState(false) // 로그인 상태관리
  
  // email이 존재할때 와 email이 존재하지 않을 때
  // useEffect가 무조건 함수가 호출될 때 최초 한번은 실행이 된다.(static 블록)
  // 최초값이 빈문자열이다. - localStorage저장된 email정보를 읽어 오기
  // localStorage에 email정보를 언제 담아주었나? -> App.jsx -> useEffect -> 구글에 상태값을 체크하는 함수 실행 -> 오라클 DB조회하고
  // 조회된 결과가 있으면 그 때 저장된다.
  useEffect(() => {
    // 의존성 배열에 있는 값이 별경될 때 마다 useEffect가 다시 호출된다.
    const email = localStorage.getItem('email')
    if (email) {
      setEmail(email) // 최초 렌더링시에 빈문자열 이었다가 로그인 후 localStorage가 변하면 같이 바뀐다.
      setIsLoggedIn(true)
    }

  }, [email])

  const logoutE = () => {
    console.log('logout')
    // 구글에서 logout처리 함수 > 이메일 초기화, setLogged false(초기값)
    logout(userAuth.auth)
    setEmail(null)
    setIsLoggedIn(false)
  }//end of logoutE
  // 아래 부분이 화면 처리부분
  return (
    <>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Link to="/" className="nav-link">Home</Link>
            <Link to="/pay/ready" className="nav-link">카카오페이</Link>
            <Link to="/board" className='nav-link'>게시판</Link>
            <Link to="/reboard" className='nav-link'>댓글 게시판</Link>
            <Link to="/quill/write" className='nav-link'>QuillEditor</Link>
            <Link to="/notice" className='nav-link'>공지사항</Link>
            <Link to="/noticeDB" className='nav-link'>공지MySQL</Link>
            <Link to="/noticeT" className='nav-link'>공지데모</Link>
            <Link to="/page" className='nav-link'>페이징처리</Link>
          </Nav>
          {/* 로그인 메뉴 Nav bar 오른쪽 끝에 붙이기 */}
          <div className="d-flex">
            <ul className='navbar-nav me-auto mb-2 mb-lg-0'>
              {!isLoggedIn && (
                <li className='nav-item' id='login'>
                  <Link to="/login" className='nav-link active'>로그인</Link>
                  </li>
              )}
              {isLoggedIn && (
                <>
                  <li className='nav-item' id='mypage'><Link to="/mypage" className='nav-link'>{email}</Link></li>
                  <li className='nav-item' id='logout'><Link to="#" className='nav-link' onClick={logoutE}>로그아웃</Link></li>
                </>
              )}
            </ul>
          </div>
        </Container>
      </Navbar>
    </>
  )
}

export default Header1216
/* 
  페이지 이동시 href를 사용하면 URL이 변한다.
  - 기존에 요청은 끊어지고 새로운 요청이 일어난다. : 기존 페이지가 쥐고 있던 데이터는 잃어버린다.
*/