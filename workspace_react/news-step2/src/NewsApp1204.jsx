import { Route, Routes } from "react-router";
import LoginPage1206 from "./components1204/auth1206/LoginPage1206";
import NewsPage1206 from "./components1204/pages1206/NewsPage1206";
import YoutubePage1206 from "./components1204/pages1206/YoutubePage1206";
import NoticePage1206 from "./components1204/pages1206/NoticePage1206"

const NewsApp1204 = ({ authLogic1206 }) => {
  console.log(authLogic1206)
  return (
    <>
      <Routes>
        <Route path="/" exact={true} element={<LoginPage1206 authLogic1206={authLogic1206} />} />
        <Route path="/news/:userId" element={<NewsPage1206 authLogic1206={authLogic1206} />} />
        <Route path="/youtube" exact={true} element={<YoutubePage1206 />} />
        <Route path="/notice" exact={true} element={<NoticePage1206 />} />
      </Routes>
    </>
  );
}

export default NewsApp1204;
