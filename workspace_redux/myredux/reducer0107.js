// step1.js에서 구현한 FLUX 아키텍처를 리덕스 스럽게 수정한 코드이다.
import * as ActionType from './action-typs0107.js'

export function reducer0107(state = { count: 0 }, action) {
  switch (action.type) {
    case ActionType.INCREASE:
      return { ...state, count: state.count + 1 }; //얕은복사- 원본
    case ActionType.DECREASE:
      return { ...state, count: state.count - 1 }; //얕은복사- 원본
    case ActionType.RESET:
      return { ...state, count: 0 }; //얕은복사- 원본
    default:
      return { ...state };
  }
}