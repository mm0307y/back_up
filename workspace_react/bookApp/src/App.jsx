import { Route, Routes } from "react-router";
import HomePage0102 from "./components0102/pages0102/HomePage0102";
import LoginPage0102 from "./components0102/auth0102/LoginPage0102";
import KakaoCallback0103 from "./components0102/auth0102/KakaoCallback0103";
import ZipcodeSearch0103 from "./components0102/kakao0103/ZipcodeSearch0103";

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" exact={true} element={<HomePage0102 />} />
        <Route path="/login" exact={true} element={<LoginPage0102 />} />
        <Route path="/auth/kakao/callback" exact={true} element={<KakaoCallback0103 />} />
        <Route path="/zipcode" exact={true} element={<ZipcodeSearch0103 />} />
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