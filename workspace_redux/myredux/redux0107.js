export const actionCreator = (type) => (payload) => {
  //커링함수 검색
  return {
    type,
    payload, //payload객체를 만들어줌.  데이터를 받아서 그 값만큼 증가시키고 싶을 때
  };
};

export function createStore(reducer) {
  //1 -> worker -> reducer함수
  //상태값을 관리하는 저장소
  let state;

  //함수를 관리하는 배열
  let handlers = []; //구독기 담는 함수
  function dispatcher(action) {
    //send -> dispatcher
    state = reducer(state, action); //worker -> reducer
    handlers.forEach((handler) => handler());
  }

  //구독 발행 모델
  function subscribe(handler) {
    handlers.push(handler);
  }

  function getState() {
    return state;
  }

  return {
    //2
    dispatcher, // 자바스크립트는 고차함수를 지원한다. 함수를 외부로 내보낼 수 있다./ send -> dispatcher 변경
    getState,
    subscribe,
  };
}
