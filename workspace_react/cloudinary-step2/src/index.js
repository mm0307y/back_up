import React, { Fragment } from "react";
import ReactDOM from "react-dom/client";
import "./app.css";
import { BrowserRouter } from "react-router-dom";
import CardApp1210 from "./CardApp1210";
import AuthLogic from "./service1212/authLogic1212";
import { app } from "./service1212/firebase1212";
import ImageUploader from "./service1212/image_upload1212";
import ImageFileInput1212 from "./components1210/common1210/ImageFileInput1212";
import CardLogic from "./service1212/cardLogic1216";

const authLogic = new AuthLogic(app);
//firebase Realtime Database를 활용하기 위해 공통코드 생성하기
const cardLogic = new CardLogic(app);
const imageUploader = new ImageUploader();
const FileInput = (props) => (
  <ImageFileInput1212 {...props} imageUploader={imageUploader} />
);
//console.log(app);
//console.log(authLogic);
//public>index.html div의 위치 파악함
const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <BrowserRouter>
      {/* 리액트에서 사용자정의 태그는 일급함수이다 */}
      <CardApp1210 FileInput={FileInput} authLogic={authLogic} cardLogic={cardLogic} />
    </BrowserRouter>
  </>
);
