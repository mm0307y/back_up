import { Route, Routes } from "react-router";
import "bootstrap/dist/css/bootstrap.min.css";
import HomePage1216 from "./components1216/pages1216/HomePage1216";
import LoginPage1216 from "./components1216/auth1216/LoginPage1216";
import NoticeDetail1216 from "./components1216/notice1216/NoticeDetail1216";
import NoticeList1216 from "./components1216/notice1216/NoticeList1216";
import NoticeTestList1218 from "./components1216/noticeTest1218/NoticeTestList1218";
import NoticeTestDetail1218 from "./components1216/noticeTest1218/NoticeTestDetail1218";

const App = () => {
  // Route의 path와 Header의 Link to는 일치해야 한다.
  // 사용자 정의 컴포넌트는 함수이다.
  return (
    <>
      <Routes>
        <Route path="/" exact={true} element={<HomePage1216 />} />
        <Route path="/login" exact={true} element={<LoginPage1216 />} />
        <Route path="/notice" exact={true} element={<NoticeList1216 />} />
        <Route path="/notice/:n_no" exact={true} element={<NoticeDetail1216 />} />
        <Route path="/noticeT" exact={true} element={<NoticeTestList1218 />} />
        <Route path="/noticeTD" exact={true} element={<NoticeTestDetail1218 />} />
      </Routes>
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