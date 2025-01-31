import { combineReducers } from "redux";
import userAuth from "./userAuth0120/reducer0120";
import toastStatus from "./toastStatus0120/reducer0120";

// 여러 reducer를 사용하는 경우 reducer를 하나로 묶어주는 메소드입니다.
// store에 저장되는 리듀서는 오직 1개입니다.
const rootReducer0120 = combineReducers({
  userAuth,
  toastStatus,
});

export default rootReducer0120;