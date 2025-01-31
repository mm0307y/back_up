;(() => {
  const socket = new WebSocket(`ws://${window.location.host}/ws`);
  
  // talk.html에서 form엘리먼트 가져오기
  const formEl = document.querySelector("#form")
  const inputEl = document.querySelector("#input")
  const talksEl = document.querySelector("#talks")
  if(!formEl || !inputEl) {
    throw new Error("Init failed...")
  }
  
  // 서버측에서 보낸 메세지를 받아서 담기
  const talks = []

  formEl.addEventListener("submit", (e) => {
    // submit이슈 - 이벤트 버블링과 캡처링
    // 페이지를 refresh하지 않고도 다음 액션을 처리할 수 있다.
    // <button type=button> 기본적으로 submit이슈가 있다. <input type=button>
    // type에 button을 추가하면 submit이슈를 피할 수 있다.
    e.preventDefault(); // 페이지가 번쩍 -> 새로고침

    // 소켓통신으로 보내는 데이터 타입은 문자열만 가능하다.
    // 200#키위#사과#스터디할까
    socket.send(JSON.stringify({
      nickname: "키위",
      message: inputEl.value
    }));

    // 메세지 나간 뒤 초기화 하기
    inputEl.value = ""
  })//// end of 메시지 전송
  
  // 서버에서 보낸 정보를 받아서 출력해보기
  socket.addEventListener("message", event => {
    // 서버에서 ws프로토콜로 전송된 문자열 받아서 talks배열에 추가하기
    talks.push(JSON.parse(event.data))
    talksEl.innerHTML = '' // 초기화
    talks.forEach(({message, nickname}) => {
      const div = document.createElement("div")
      div.innerHTML = `[${nickname}] : ${message} (12:35:37)`
      talksEl.appendChild(div)
    })
  });
})();

// 즉시 실행 함수 - IIFE
// 바로 정의해서 호출하는 함수
// 인스턴스 정보를 숨기는 목적으로 사용한다.
