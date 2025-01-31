function createStore() {
  //상태값을 관리하는 저장소
  let state;

  //함수를 관리하는 배열
  let handlers = [];
  function send(action) {
    state = worker(state, action);
    handlers.forEach((handler) => handler());
  }

  //구독 발행 모델
  function subscribe(handler) {
    handlers.push(handler);
  }

  function getState() {
    return state;
  }

  // 리듀서를 통해서 읽어들인 상태 값을 가져오기
  return {
    send, // 자바스크립트는 고차함수를 지원한다. 함수를 외부로 내보낼 수 있다.
    getState,
    subscribe,
  };
} //// end of createStore -> redux.js 생성 -> function앞에 export 붙였다.
// ECMAScript6 - 2015년 표준 - 모던웹 - 모듈화 지원
// 감속기 - 외부에서 어떤 시그널을 보내오면 파라미터로 받아서 상태 값을 변경해 준다.
// 첫 번째 파라미터 자리에는 이 어플리케이션에서 관리할 상태값이 선언

function worker(state = { count: 0 }, action) {
  // 감속기의 파라미터로 넘어온 시그널에 따라서 처리한 결과(상태값)를 반환해준다.
  // 외부에서 나를 호출한 곳으로 반환해 줄께
  switch (action.type) { // 파라미터가 시그널 종류
    case "increase":
      return { ...state, count: state.count + 1 }; //얕은복사- 원본
    case "decrease":
      return { ...state, count: state.count - 1 }; //얕은복사- 원본
    case "reset":
      return { ...state, count: 0 }; //얕은복사- 원본
    default:
      return { ...state };
  }
}

const store = createStore(worker); // 외부에서 사용하기 위해서 작성한다.

store.subscribe((state) => {
  console.log(store.getState());
});

store.send({ type: "increase" });
store.send({ type: "increase" });
store.send({ type: "decrease" });
store.send({ type: "reset" });

/* 
  store는 상태 묶음이다.
*/
