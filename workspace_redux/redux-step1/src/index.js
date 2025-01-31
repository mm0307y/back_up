import React from "react";
import ReactDOM from "react-dom/client";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "./App";
import { BrowserRouter } from "react-router";
import { legacy_createStore } from "redux";
import rootReducer from "./redux0120/rootReducer";
import { Provider } from "react-redux";
import { setAuth } from "./redux0120/userAuth/action";
import AuthLogic0120 from "./service0120/authLogic0120";
import { app } from "./service0120/firebase0120";

// 리덕스 관련 설정 추가
const store = legacy_createStore(rootReducer);
const authLogic = new AuthLogic0120(app);
store.dispatch(setAuth(authLogic.getUserAuth(), authLogic.getGoogleAuthProvider()));
console.log(store.getState() || "Store is empty");

const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <BrowserRouter>
      <Provider store={store}>
        <App />
      </Provider>
    </BrowserRouter>
  </>
);
