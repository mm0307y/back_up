import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const Header1216 = () => {
  // 아래 부분이 화면 처리부분
  return (
    <>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Link to="/" className="nav-link">Home</Link>
            <Link to="/login" className="nav-link">로그인</Link>
            <Link to="/notice" className="nav-link">공지사항</Link>
            <Link to="/noticeDB" className="nav-link">공지MySQL</Link>
            <Link to="/noticeT" className="nav-link">공지데모</Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  )
}

export default Header1216
/* 
  페이지 이동시 href를 사용하면 URL이 변한다.
  - 기존에 요청은 끊어지고 새로운 요청이 일어난다. - 기존 페이지가 쥐고 있던 데이터는 잃어버린다.
*/

