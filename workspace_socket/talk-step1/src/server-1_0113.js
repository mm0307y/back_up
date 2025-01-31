// kos외부 모듈을 가져오기
// koa - express팀에서 만들었다. : Node.js기반의 웹 어플리케이션 프레임워크 이다.
// 미들웨어를 중심의 구조
const Koa = require("koa"); // 1번
const app = new Koa(); // 2번

// response
app.use(async (ctx, next) => { // 4번 -> 5번(다음 미들웨어로 연결하기 위해서 next속성을 추가했다.)
  // 첫번째 미들웨어에서 응답 본문 설정한다.
  ctx.body = "Hello Koa"; // 6번
  
  // 7번 next()호출해야 다음 미들웨어로 이동 된다.
  await next(); //11 번
  
  // next통해 미들웨어 아래 쪽으로 이동했다가 다시 돌아온다.
  ctx.body = `[${ctx.body}]` // 12번

});

app.use(async (ctx) => { // 8번
  ctx.body = `<${ctx.body}>`; // 9번
}); // 10번

// 서버 시작 - 서버를 포트 5000번에서 실행합니다.
// 브라우저에서 http://localhost:5000에 접소하면 설정된 미들웨어 체인의 결과를 차례대로 확인 가능하다.
app.listen(5000); // 3번