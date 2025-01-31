import React, { useEffect, useState } from 'react'
import { Button, Container, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router';
import { logout } from '../../service0103/authLogic0103';

const Header0103 = () => {
  const [email, setEmail] = useState('');
  useEffect(() => {
    setEmail(localStorage.getItem('email'))
  }, [])

  return (
    <Navbar bg="light" expand="lg">
      <Container fluid>
        <Navbar.Brand href="#">너만 고도비만</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav className="me-auto my-2 my-lg-0" style={{ maxHeight: '100px' }} navbarScroll>
            <Link to="/" className='nav-link'>Home</Link>
            <Link to="/login/signup" className='nav-link'>회원가입</Link>
          </Nav>
          {email && <Button variant="primary" onClick={() => { logout() }}>Logout2</Button>}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  )
}

export default Header0103