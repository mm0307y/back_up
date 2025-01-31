import ReactDOM from "react-dom/client";
import App from "./App";
import { BrowserRouter } from "react-router";
import { Provider } from "react-redux";
import { legacy_createStore } from "redux";
import rootReducer0110 from "./redux/rootReducer0110";
import { setAuth } from "./redux/userAuth0110/action0110";
import { app } from "./service/firebase0110";
import AuthLogic0110 from "./service/authLogic0110";

const root = ReactDOM.createRoot(document.querySelector("#root"));
const authLogic = new AuthLogic0110(app);

let store = legacy_createStore(rootReducer0110);
store.dispatch(setAuth(authLogic.getUserAuth(),authLogic.getGoogleProvider()));

console.log(store.getState() || "Store is empty");

root.render(
  <>
    <BrowserRouter>
      <Provider store={store}>
        <App />
      </Provider>
    </BrowserRouter>
  </>
);
