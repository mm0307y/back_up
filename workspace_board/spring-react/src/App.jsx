import { Route, Routes } from "react-router";
import HomePage0205 from "./components0205/pages0205/HomePage0205";
import LoginPage0205 from "./components0205/auth0205/LoginPage0205";
import ReBoardDBList0210 from "./components0205/reboard0210/ReBoardDBList0210";
import ReBoardDBDetail0210 from "./components0205/reboard0210/ReBoardDBDetail0210";
import ReBoardDBUpdate0210 from "./components0205/reboard0210/ReBoardDBUpdate0210";
import ReBoardDBWrite0210 from "./components0205/reboard0210/ReBoardDBWrite0210";

const App = () => {

  return (
    <>
      <Routes>
        <Route path="/" exact={true} element={<HomePage0205 />} />
        <Route path="/login" exact={true} element={<LoginPage0205 />} />
        <Route path="/reboard" exact={true} element={<ReBoardDBList0210 />} />
        <Route path="/reboard/:b_no" exact={true} element={<ReBoardDBDetail0210 />} />
        <Route path="/reboard/update/:b_no" exact={true} element={<ReBoardDBUpdate0210 />} />
        <Route path="/reboard/write" exact={true} element={<ReBoardDBWrite0210 />} />
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
  - 이 때 App.jsx의 return에 있는 태그가 화면에 출력된다.
  - 그런데 이번에는 App.jsx에 메뉴를 클릭했을 때 보여줄 페이지에 대한 링크를 걸어 준다.*/