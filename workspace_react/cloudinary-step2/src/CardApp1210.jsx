import { Route, Routes } from "react-router-dom";
import Login1211 from "./components1210/page1210/Login1211";
import Marker1210 from "./components1210/page1210/Marker1210";
import styled from "styled-components";

const AppDiv = styled.div`
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #e8e7e6;
`
//여기서 인증 체크
//여기서 세션, 권한, 인증
//메뉴가 여기서 결정된다
const CardApp1210 = ({ authLogic, FileInput, cardLogic }) => {
  return (
    <>
      <AppDiv>
        <Routes>
          <Route path="/" element={<Login1211 authLogic={authLogic} />} />
          <Route path="/marker" element={<Marker1210 FileInput={FileInput} authLogic={authLogic} cardLogic={cardLogic} />} />
        </Routes>
      </AppDiv>
    </>
  );
}

export default CardApp1210;
