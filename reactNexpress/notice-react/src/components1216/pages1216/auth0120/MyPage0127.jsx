import React, { useState } from 'react'
import { BButton, ContainerDiv, MyInput, MyLabel, PwEye } from '../../../styles1226/FormStyles'
import { Card } from 'react-bootstrap'
import Signup0120 from '../../auth1216/Signup0120'

const MyPage0127 = () => {
  const [passwordType, setPasswordType] = useState({
    type:"password",
    visible:false
  })
  const [pwd, setPwd] = useState('');

  // 비밀번호 확인이 된 경우 구분
  const [isPwChecked, setIsPwChecked] = useState(false);

  const passwordView = (e) => {
    const id = e.currentTarget.id
    if (id === "password") {
      if (!passwordType.visible) {
        setPasswordType({ ...passwordType, type: "text", visible: true })
      } else {
        setPasswordType({ ...passwordType, type: "password", visible: false })
      }
    }
  }
  const reAuth = () => {
    // 아래 setter함수에 true이면 비밀번호 확인 된 상태라고 가정한다.
    setIsPwChecked(true);
  }

  return (
    isPwChecked ?
    <Signup0120 update={true}></Signup0120>
    :
    <ContainerDiv>
            <Card style={{width:"90%", maxWidth:"600px", marginTop:'100px'}}>
            <Card.Header style={{display:"flex", justifyContent:"center"}}>
                <h3>비밀번호 확인</h3>
            </Card.Header>
            <Card.Body>
                <form style={{display:"flex", flexDirection:"column", justifyContent:"center", alignItems: 'center'}}>
                <span style={{margin: '10px 0px 30px 0px'}}>회원님의 정보를 보호하기 위해 비밀번호를 다시 확인합니다.</span>
                <MyLabel htmlFor="password"> 비밀번호
                    <input hidden="hidden" />
                    <MyInput type={passwordType.type} id="password" name="mem_password" autoComplete="off" placeholder="비밀번호를 입력해주세요."
                    onChange={(e)=>setPwd(e.target.value)}/>
                    <div id="password" onClick={(e)=> {passwordView(e)}} style={{color: `${passwordType.visible?"gray":"lightgray"}`}}>
                    <PwEye className="fa fa-eye fa-lg"></PwEye>
                    </div>
                </MyLabel>
                </form>
            </Card.Body>
            <Card.Footer>
                <div style={{display: 'flex', justifyContent: 'center'}}>
                <BButton type="button" style={{width:"150px", height:"48px"}} onClick={reAuth}>확인</BButton>
                </div>
            </Card.Footer>
            </Card>
        </ContainerDiv>
  )
}

export default MyPage0127