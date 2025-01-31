// npm i koa로 설치했다.
const Koa = require("koa");

// Koa 객체 생성하기
// const app = new Koa();

// 정적 파일 경로 설정
const serve = require("koa-static");

// 라우트 처리시 페이지 이름으로 화면 전환 처리
const send = require("koa-send");

// 정적 파일 경로 설정
const path = require("path");

// mount 설정
const mount = require("koa-mount");

// ws는 web socket의 약자
// ws프로토콜을 사용하여 채팅 구현하기 - 메시지 청취하기와 메시지 전송 api
(route = require("koa-route")), (websockify = require("koa-websocket"));
const app = websockify(new Koa());

// -? path 지원 __driname이 파일에 name을 가리킨다.
// 클라이언트 측에서 브라우저에 http://localhost:5000/ 엔터하면 index.html문서를 views에서 찾는다.
const staticPath = path.join(__dirname, "./views0114");
app.use(serve(staticPath, { index: "index0114.html" }));
app.use(mount("/public0114", serve("src/public0114")));

// 기본 라우트 설정하기
// response
// 객체 생성을 했으므로 인스턴스 변수, 함수(use)명로 호출이 가능하다.
app.use(async (ctx) => {
  if (ctx.path === "/talk") {
    await send(ctx, "talk0114.html", { root: staticPath });
  } else {
    ctx.status = 404;
    ctx.body = "페이지를 찾을 수 없습니다.";
  }
});

// Using routes
app.ws.use(
  route.all("/ws", (ctx) => {
    // 크라이언트 측에서 보낸 메시지 청취하기
    ctx.websocket.on("message", (data) => {
      // 소켓 통신으로 주고 받는 데이터는 문자열이 이어야 한다.
      // 타입체크 하기 - typescript
      // 유효성 체크하기
      if(typeof JSON.stringify(data) !=='string'){
        return // 잘못된 타입이 읽어졌으므로 함수를 빠져 나간다.
      }
      const {nickname, message} = JSON.parse(data)
      ctx.websocket.send(JSON.stringify({
        nickname: nickname,
        message : message,
      }))

    });
  })
);

app.listen(5000);
