// kos외부 모듈을 가져오기
// koa - express팀에서 만들었다. : Node.js기반의 웹 어플리케이션 프레임워크 이다.
// 미들웨어를 중심의 구조
const Koa = require("koa"); // 1번
const serve = require("koa-static");

// 라우트로 전환되는 화면을 html문서로 작성하여 처리하기
const send = require("koa-send");

// 우리가 만든 프로젝트 폴더의 root정보를 알기
const path = require("path");
const app = new Koa(); // 2번

// 정적 파일 경로 설정하기 - 응답 페이지가 참고하는 루트 폴더 지정한다.
const staticPath = path.join(__dirname, "./views0113");
// serve에 위 정보를 태운다.
app.use(serve(staticPath));

// 기본 페이지 라우트 설정하기
app.use(async (ctx) => {
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
  }

  else if (ctx.path === "/talk") {
    // main.html 반환하는 코드 작성한다.
    await send(ctx, "talk0113.html", { root: staticPath });
  }
  else {
    ctx.status = 404;
    ctx.body = "Page Not Found"
  }
});

// response
app.use(async (ctx, next) => {
  // 4번 -> 5번(다음 미들웨어로 연결하기 위해서 next속성을 추가했다.)
  // 첫번째 미들웨어에서 응답 본문 설정한다.
  ctx.body = "Hello Koa"; // 6번

  // 7번 next()호출해야 다음 미들웨어로 이동 된다.
  await next(); //11 번

  // next통해 미들웨어 아래 쪽으로 이동했다가 다시 돌아온다.
  ctx.body = `[${ctx.body}]`; // 12번
});

app.use(async (ctx) => {
  // 8번
  ctx.body = `<${ctx.body}>`; // 9번
}); // 10번

// 서버 시작 - 서버를 포트 5000번에서 실행합니다.
// 브라우저에서 http://localhost:5000에 접소하면 설정된 미들웨어 체인의 결과를 차례대로 확인 가능하다.
app.listen(5000); // 3번
