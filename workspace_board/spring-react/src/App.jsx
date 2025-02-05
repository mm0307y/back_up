import { Route, Routes } from "react-router";
import HomePage0205 from "./components0205/pages0205/HomePage0205";
import LoginPage0205 from "./components0205/auth0205/LoginPage0205";
import NoticePager0205 from "./components0205/pages0205/NoticePager0205";
import { useEffect } from "react";
import { boardListDB } from "./service0205/dbLogic0205";

const App = () => {
  useEffect(() => {
    const asyncDB = async () => {
      const board = {
        "gubun": null, // 제목 : b_title, 내용 : b_content, 작성자 : MEM_NICKNAME
        "keyword": null,
      }
      await boardListDB(board)
    }
    asyncDB()
  }, [])
  return (
    <>
      <Routes>
        <Route path="/" exact={true} element={<HomePage0205 />} />
        <Route path="/login" exact={true} element={<LoginPage0205 />} />
        <Route path="/notice/list" exact={true} element={<NoticePager0205 />} />
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