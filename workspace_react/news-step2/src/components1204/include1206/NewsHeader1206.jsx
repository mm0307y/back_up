import React from 'react'
import { Button, Container, Nav, Navbar } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const NewsHeader1206 = ({ onLogout }) => {
  // 아래 부분이 화면 처리부분
  return (
    <>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand href="#home">해커뉴스</Navbar.Brand>
          <Nav className="me-auto">
            <Link to="/" className="nav-link">Home</Link>
            <Link to="/news" className="nav-link">뉴스</Link>
            <Link to="/youtube" className="nav-link">유튜브</Link>
            <Link to="/notice" className="nav-link">공지사항</Link>
          </Nav>
          {onLogout && <Button variant="primary" onClick={onLogout}>Logout</Button>}
        </Container>
      </Navbar>
    </>
  )
}

export default NewsHeader1206
/* 
  페이지 이동시 href를 사용하면 URL이 변한다.
  - 기존에 요청은 끊어지고 새로운 요청이 일어난다. - 기존 페이지가 쥐고 있던 데이터는 잃어버린다.
*/

