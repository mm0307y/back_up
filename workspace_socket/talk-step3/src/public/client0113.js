(() => {
  // 닉네임 입력 받기
  let myNickname = prompt("닉네임을 입력하세요.", "kiwi");

  // 채팅 화면 타이틀 변경하기
  const title = document.querySelector("#title");
  if (myNickname != null) {
    title.innerHTML = `{{${myNickname}}} 님의 예약 상담`;
  }

  const socket = new WebSocket(`ws://${window.location.host}/ws`);

  // talk.html에서 form엘리먼트 가져오기
  const formEl = document.querySelector("#form");
  const inputEl = document.querySelector("#input");
  const talksEl = document.querySelector("#talks");
  const exitEl = document.querySelector("#exit");

  if (!formEl || !inputEl) {
    throw new Error("Init failed...");
  }

  // 서버측에서 보낸 메세지를 받아서 담기
  const talks = [];

  exitEl.addEventListener("click", () =>{
    alert("채팅창이 종료됩니다.")
    location.href = "/"
  })

  formEl.addEventListener("submit", (e) => {
    // submit이슈 - 이벤트 버블링과 캡처링
    // 페이지를 refresh하지 않고도 다음 액션을 처리할 수 있다.
    // <button type=button> 기본적으로 submit이슈가 있다. <input type=button>
    // type에 button을 추가하면 submit이슈를 피할 수 있다.
    e.preventDefault(); // 페이지가 번쩍 -> 새로고침

    // 소켓통신으로 보내는 데이터 타입은 문자열만 가능하다.
    // 200#키위#사과#스터디할까
    socket.send(JSON.stringify({
        nickname: myNickname,
        message: inputEl.value,
      }))

    // 메세지 나간 뒤 초기화 하기
    inputEl.value = ""
  }); //// end of 메시지 전송

  // 대화 내용 출력하기
  const drawTalks = () => {
    talksEl.innerHTML = "" // 대화목록을 초기화
    talks.forEach(({ nickname, message, curtime }) => {
      const div = document.createElement("div");
      div.innerText = `[${nickname}]: ${message}(${curtime})`;
      talksEl.appendChild(div);
    });
  }; //// end of drawTalks

  // 서버에서 보낸 정보를 받아서 출력해보기
  socket.addEventListener("message", (event) => {
    // 서버에서 ws프로토콜로 전송된 문자열 받아서 talks배열에 추가하기
    const { type, payload } = JSON.parse(event.data);
    console.log("type =====> " + type)
    
    // payload출력하면 Object라고 출력된다.
    console.log("payload =====> " + JSON.stringify(payload))
    console.log("payload.message =====> " + payload.message)
    console.log("payload.nickname =====> " + payload.nickname )
    console.log("payload.curtime =====> " + payload.curtime)

    if (type === "sync") {
      const { talks: syncedChats } = payload;
      Object.keys(syncedChats).map((key) => {
        talks.push(syncedChats[key].payload);
      });
    } //// end of sync - 이전 대화내용 동기화 처리하기
    else if (type === "talk") {
      const talk = payload;
      talks.push(talk);
    } //end of talk
    drawTalks();
  });
})();

// 즉시 실행 함수 - IIFE
// 바로 정의해서 호출하는 함수
// 인스턴스 정보를 숨기는 목적으로 사용한다.
