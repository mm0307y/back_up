import React from "react";
import ReactDOM from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-quill/dist/quill.snow.css";
import App from "./App";
import { BrowserRouter } from "react-router";
import AuthLogic0212 from "./service0205/authLogic0212";
import { app } from "./service0205/firebase0212";
import { Provider } from "react-redux";
import { legacy_createStore } from "redux";
import rootReducer0212 from "./redux0212/rootReducer0212";
import { setAuth } from "./redux0212/userAuth0212/action0212";

// firebase.js안에 export 선언한 변수 app 사용한다.
const authLogic = new AuthLogic0212(app); // 파라미터에 firebase app이 필요하다. - 생성자 함수의 파라미터를 활용한다.

// 여러개의 reducer를 조합하여 사용하기 위해 선언했다. - rootReducer 이다.
let store = legacy_createStore(rootReducer0212);

// 매번 props로 넘겨야 하는 상태 정보를 store에 초기화 한다.
store.dispatch(setAuth(authLogic.getUserAuth(), authLogic.getGoogleAuthProvider()));

// 파이프연산자는 앞에가 참이면 뒤에 조건을 따지지 않는다.
// 리덕스에서 상태값이 null이거나 undefinded이면  Store is empty를 출력한다.
console.log(store.getState() || "Store is empty");

const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <BrowserRouter>
    {/* 리덕스 설정하기 */}
    <Provider store={store}>
      <App />
      </Provider>
    </BrowserRouter>
  </>
);
