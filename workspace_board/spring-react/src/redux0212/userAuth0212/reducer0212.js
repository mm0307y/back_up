import { SET_AUTH } from "./action0212";
import { userAuth } from "./state0212";

export default function userInfo(state = userAuth, action) {
  switch (action.type) {
    case SET_AUTH:
      return {
        ...state,
        auth: action.auth,
        googleProvider: action.googleProvider,
      };
    default:
      return state;
  }
}
