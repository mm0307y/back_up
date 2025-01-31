import { Route, Routes } from "react-router";
import HomePage1204 from "./components1204/pages1204/HomePage1204";
import LoginPage1204 from "./components1204/auth1204/LoginPage1204";
import NoticePager1204 from "./components1204/pages1204/NoticePager1204";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { setToastMsg } from "./redux0120/toastStatus/action";
import Toast0120 from "./components1204/Toast0120";

const App = () => {
  const toatStatus = useSelector((state) => state.toastStatus);
  const dispatch = useDispatch();

  // App렌더링될 때 의존성 배열에 빈값이 최초 한번은 문조건 실행된다.
  useEffect(()=>{
    console.log("useEffect")
    dispatch(setToastMsg("회원가입 정보가 이미 존재합니다."))
  },[])
  return (
    <>
      <div style={{ height: "100vh",}}>
        {toatStatus.status &&<Toast0120 />}
        <Routes>
          <Route path="/" exact={true} element={<HomePage1204 />} />
          <Route path="/login" exact={true} element={<LoginPage1204 />} />
          <Route path="/notice/list" exact={true} element={<NoticePager1204 />} />
        </Routes>
      </div>
    </>
  );
}

export default App;

/* 
- http://localhost:3000 뒤에 index.html 가 생략 되어 있다. http://localhost:3000/index.html 
- <div id ="root"></div>
- root에 대한 정보는 index.js에서 참조한다. - document.querySelector("#root")
- index.js에서 App을 import한다.
- 이 때 App.jsx의 erturn에 있는 태그가 화면에 출력된다.
- 그런데 이번에는 App.jsx에 메뉴를 클릭했을 때 보여줄 페이지에 대한 링크를 걸어 준다.
*/