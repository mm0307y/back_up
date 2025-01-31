import React from "react";
import ReactDOM from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import NewsApp1204 from "./NewsApp1204";
import { BrowserRouter } from "react-router";
import AuthLogic1206 from "./service1206/authLogic1206";
import app from "./service1206/firebase1206";
import "bootstrap/dist/css/bootstrap.min.css";

// 아래는 authLogic.js에서 선언한 클래스에 대한 인스턴스화
const authLogic1206 = new AuthLogic1206(app);
const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <BrowserRouter>
      <NewsApp1204 authLogic1206={authLogic1206} />
    </BrowserRouter>
  </>
);
