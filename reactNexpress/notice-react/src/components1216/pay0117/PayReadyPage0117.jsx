import React from 'react'
import { ContainerDiv } from '../../styles1226/FormStyles'
import { Card } from 'react-bootstrap'

const PayReadyPage0117 = () => {
  return (
    <>
      <ContainerDiv>
        <Card>
          <Card.Header>
            <h3>결제 페이지</h3>
          </Card.Header>
          <Card.Body>
            <iframe src='http://localhost:3000/pay/action' width="500px" height="600px">카카오페이 결체창</iframe>
          </Card.Body>
        </Card>
      </ContainerDiv>
    </>
  )
}

export default PayReadyPage0117