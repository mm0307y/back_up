import React from "react";
import ReactDOM from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import "@fortawesome/fontawesome-free/js/all.js";
import App from "./App";
import { BrowserRouter } from "react-router";
import "react-quill/dist/quill.snow.css";
import AuthLogic0120 from "./service1216/authLogic0120";
import { app } from "./service1216/firebase1217";
import { legacy_createStore } from "redux";
import rootReducer0120 from "./redux0120/rootReducer0120";
import { Provider } from "react-redux";
import { setAuth } from "./redux0120/userAuth0120/action0120.js";

// 리덕스 관련 설정 추가
// 인증을 위한 코드 추가
const authLogic = new AuthLogic0120(app);
const store = legacy_createStore(rootReducer0120);
store.dispatch(
  setAuth(authLogic.getUserAuth(), authLogic.getGoogleAuthProvider())
);

// getState함수는 리덕스에서 제공하는 함수로 상태값을 확인한다.
console.log(store.getState()); // redux > toastStatus(토스트메시지처리 : bool, msg), userAuth(인증상태)

const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <BrowserRouter>
      <Provider store={store}>
        {/* App전체를 Provider로 감싸서 props로 전달될 store를 사용할 수 있다. */}
        <App />
      </Provider>
    </BrowserRouter>
  </>
);
