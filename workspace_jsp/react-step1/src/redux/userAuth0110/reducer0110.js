import { SET_AUTH } from "./action0110.js"
import { userAuth } from "./state0110.js"

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
