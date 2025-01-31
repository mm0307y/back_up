// alert("client loaded...")
// 주의 : websocket사용시 브라우저 개발자 도구 socket객체에 직접 호출하면 외부에 노출 될수 있다.
// IIFE - 즉시실행함수 - 인스턴스 정보를 숨기는 목적으로 사용한다.
// 예전에는 호이스팅 이슈를 해결하는 목적으로 사용했다.

(() => {
  // 대화명 입력 받기
  let myNickname = prompt("닉네임을 입력하세요.", "kiwi");

  // 채팅 화면 타이틀 변경하기
  const title = document.querySelector("#title");
  if (myNickname != null) {
    title.innerHTML = `{{${myNickname}}}님의 예약 상담`;
  }
  // talk.html에서 from 엘리먼트 가져오기 - 폼 전송시 메시지 전송
  const formEl = document.querySelector("#form");
  const talksEl = document.querySelector("#talks"); // 채팅목록이 출력되는 div태그
  const inputEl = document.querySelector("#input");
  if (!formEl || !inputEl || !talksEl) {
    throw new Error("Init failed"); // 조건을 수렴하면 강제로 에러를 던진다.
  }

  const socket = new WebSocket(`ws://${location.host}/ws`);

  // 대화내용을 배열에 담기
  const talks = [];
  formEl.addEventListener("submit", (e) => {
    // submit가 감지되었다는 건 사용자가 메시지 입력후 엔터를 쳤다.
    e.preventDefault();
    socket.send(
      JSON.stringify({
        nickname: `${myNickname}`,
        message: inputEl.value,
      })
    );
    // 입력 창에 사용자가 입력한 메시지는 초기화 하자
    inputEl.value = "";
  });

  socket.addEventListener("open", () => {
    socket.send("Hello Server");
  });
  // 서버{src/server0114.js}에서 보낸 정보를 받아서 출력해 보기
  socket.addEventListener("message", (event) => {
    talks.push(JSON.parse(event.data))
    talksEl.innerHTML = '' // 초기화
    talks.forEach(({nickname, message})=>{
      const div = document.createElement("div")
      div.innerHTML = `[${nickname}] : ${message} (12:35:37)`
      talksEl.appendChild(div)
    })
  });
})(); // 뒤에 붙은 괄호는 익명함수를 호출하는 기호이다. - 함수가 즉시 호출된다.
