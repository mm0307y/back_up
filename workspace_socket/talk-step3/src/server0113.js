// kos외부 모듈을 가져오기
// koa - express팀에서 만들었다. : Node.js기반의 웹 어플리케이션 프레임워크 이다.
// 미들웨어를 중심의 구조
const Koa = require("koa"); // 1번
const serve = require('koa-static')

// 라우트로 전환되는 화면을 html문서로 작성하여 처리하기
const send = require('koa-send')

// 우리가 만든 프로젝트 폴더의 root정보를 알기
const path = require("path");
const route = require("koa-route");
const websockify = require('koa-websocket');
const app = websockify(new Koa()); // 2번
const mount = require("koa-mount");

// firestore 가져오기
const { initializeApp } = require('firebase/app')
const { getFirestore, addDoc, collection, query, getDocs } = require('firebase/firestore');
const { type } = require('os');

// firebase 초기화
// import { initializeApp } from "firebase/app";
const firebaseConfig = {
  apiKey: "AIzaSyAF_QeapaYa0SO4Q4RLivzjodBExQ8HsZQ",
  authDomain: "slalom2024-d0918.firebaseapp.com",
  databaseURL: "https://slalom2024-d0918-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "slalom2024-d0918",
  storageBucket: "slalom2024-d0918.firebasestorage.app",
  messagingSenderId: "1014655866177",
  appId: "1:1014655866177:web:a99f6ce99ce1f4c6943dc0",
};

// Initialize Firebase
const fireBaseApp = initializeApp(firebaseConfig);
const db = getFirestore(fireBaseApp)

// firebase 초기화
// 현재 시간 정보
let curtime = ""
let id = 0
const setClock = () => {
  const dateInfo = new Date()
    id = dateInfo.getTime()
    const hour = dateFormat(dateInfo.getHours())
    const min = dateFormat(dateInfo.getMinutes())
    const sec = dateFormat(dateInfo.getSeconds())
    //return "15:28:47"
    curtime = hour + " : " + min + " : " + sec
}; // end of setClock

const dateFormat = (time) => {
  //한자리 숫자야?
  if (parseInt(time) < 10) {
    return "0" + time;
  } else {
    return time;
  }
}; //end of dateFormat

// 정적 파일 경로 설정하기 - 응답 페이지가 참고하는 루트 폴더 지정한다.
const staticPath = path.join(__dirname, "./views0113");
// serve에 위 정보를 태운다.
app.use(serve(staticPath));

app.use(mount("/public", serve("src/public")));

// 기본 페이지 라우트 설정하기
app.use(async (ctx) => {
  await setInterval(setClock, 1000); // 1초마다 setClock을  호출해줘
  // http://localhost:5000 로 요청하면 아래 내용이 출력나간다.
  if (ctx.path === "/") {
    // http://localhost:5000/index.html
    ctx.type = "text/html"; // 요청이 있을시 응답페이지의 마임타입
    ctx.body = `
        <html>
            <head>
                <title>Welcome</title>
            </head>
            <body>
                <h1>Welcome to the koa sever</h1>
                <p><a href="/talk0113.html">채팅</a></p>
            </body>
        </html>
    `;
  } else if (ctx.path === "/main") {
    // main.html 반환하는 코드 작성한다.
    await send(ctx, "main0113.html", { root: staticPath });
  } else if (ctx.path === "/talk") {
    // main.html 반환하는 코드 작성한다.
    await send(ctx, "talk0113.html", { root: staticPath });
  } else {
    ctx.status = 404;
    ctx.body = "Page Not Found";
  }
});

const getTalksCollection = async () => {
  const _db = await db
  const q = query(collection(_db, "talk250116"))
  const snapshot = await getDocs(q)
  // console.log(snapshot.docs.map(doc => doc.data()))
  return snapshot.docs.map(doc => doc.data())
};

app.ws.use( route.all("/ws", async (ctx) => {
  // 주기적으로 ping을 날려서 연결이 계속 유지될 수 있도록 강제
  const interval = setInterval(()=> {
    if(ctx.websocket.readState === ctx.websocket.OPEN){
      ctx.websocket.ping(); // 서버에서 지속적으로 ping메시지를 전송해준다.
    } //// end of if
  }, 30000) // 30초마다 서버에서 ping을 보내기
  
  ctx.websocket.on("pong", () =>{
    console.log("클라이언트로 부터 pong 메시지 수신.")
  });

    // 새로운 사람이 입장하면 여기부터 실행된다.
    const talks = await getTalksCollection()

    // DB에 저장된 대화내용 가져오기
    console.log("talks" + talks);

    ctx.websocket.send(JSON.stringify({
      type: 'sync',
      payload:{
          talks
      }
  }));

    ctx.websocket.on("message", async (data) => {
      console.log(typeof data); // 클라이언트에서 사용자가 보낸 값 - JSON.stringify({}) -> Object
      console.log("client.js에서 보낸 메시지 청취하기 " + data)
      if (typeof JSON.stringify(data) !== "string") {
        // 유효성 체크하기 (안전한 코드)
        console.log("문자열 처리가 가능합니다.");
        return
      } //// end of if - 타입 체크
      // Object 정확한 유형은 뭐지?
      // 위에서 if문에  해당하지 않는다면... 정상이면 클라이언트에서 보낸 메시지를 구조분해 할당
      const { nickname, message } = JSON.parse(data);

      // 클라이언트가 입력한 대화내용을 firestore에 저장하기
      try {
        const docRef = await addDoc(collection(db, "talk250116"), {
          type: "talk",
          payload: {
            nickname: nickname,
            message: message,
            curtime: curtime,
          },
        });
        console.log("대화내용 저장 성공");
      } catch {
        console.error("저장 실패", error);
      } //// end of try, catch - 대화내용 저장하기

      ctx.websocket.on("close", () => {
        console.log("클라이언트 연결 종료")
        clearInterval(interval) // 연결 종료시 ping interval 정리
      })

      ctx.websocket.on("error", (error) => {
        console.log("WebSocket Error : " + error)
        clearInterval(interval) // 에러 발생시 ping interval 정리
      })

      // 문제점 제시 - 메시지를 보낸 사람한테만 보내주고 있다.
      // 현재 물려있는 모든 웹 소켓에 대해서 메시지를 보내주는 코드로 수정해야 한다.
      const { server } = app.ws;
      if (!server) {
        // 서버에 물려있는 클라이언트 소켓이 없으면 return으로 함수 전체를 탈출하고
        return;
      }

      // 서버에 물려있는 소켓이 한개라도 있으면
      server.clients.forEach((client) => {
        // 웹소켓은 문자열만 전송이 가능하다. Object타입은 불가합니다.
        // 그래서 Object{}를 JSON.stringify로 감싼다. -> Object -> string 타입으로 형전환이 일어난다.
        client.send(
          JSON.stringify({
            type: "talk",
            payload: {
              nickname: nickname,
              message: message,
              curtime: curtime,
            }
          })
        ); //// end of send
      }); //// end of forEach
    }); //// end of on
  })
); //// end of route

// 서버 시작 - 서버를 포트 5000번에서 실행합니다.
// 브라우저에서 http://localhost:5000에 접소하면 설정된 미들웨어 체인의 결과를 차례대로 확인 가능하다.
app.listen(5000); // 3번
