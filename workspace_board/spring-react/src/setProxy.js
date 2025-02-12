const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use( 
    '/api', // api가 붙은 요청에 대해서는 CORS이슈를 피한다(허락할께). - 통과시켜준다.
    createProxyMiddleware({
      target: 'http://localhost:8000', // spring boot backend URL
      changeOrigin: true // 요청의 Origin헤더를 대상 서벗의 도메인으로 변경한다. 교차출처 리소스 공유 문제를 방지하기 위해 설정한다.
    })
  )
};

/* 
  Node.js환경에서 사용할 수 있는 http-proxy-middleware 라이브러리를 이용해서
  프록시 미들웨어를 설정하는 스크립트 이다.
  이 환경을 통해 프론트 엔드 어플리케이션(리액트)에서 api요청을 프록시 서버를 통해서
  백엔드로 전달할 수 있다.
  파일명은 src/setProxy.js로 작성하면 알아서 읽어 낸다.

  예시) 프론트 쪽에서는 http://localhost:8000/api/XXXX 로 요청하면
  백엔드 측 Spring Boot서버로 연결이 된다.
*/ 