/*
app.js에서 라우트를 처리할 때 app.get() 나 app.post() 함수 사용한다.
req는 HTTP요청 객체에 대한 정보이며, res는 HTTP응답 객체에 대한 정보를 가짐
next는 다음 미들웨어를 연결할 때 필요한 인자 이다.
res는 객체이므로 함수를 제공한다.
1) send() - 문자열 메시지만 출력으로 내보낼 수 있다.
2)render() - 페이지 이름을 추가하여 응답페이지를 지정할 수 있다.
:요청을 받는 페이지와 응답이 나가는 페이지가 다르다.(다르게 할 수 있다.)
응답페이지에 dataset을 섞어서 처리할 때 Handlebars를 사용할 수 있다.
Handlebars를 사용하는 것 만으로 html태그와 js코드를 분리할 수  있다.
디자이너 혼란을 줄이고 오류를 줄일 수 있다.
WAS응답코드 500번은 서버측 오류이다.(서버측 처리한 결과에 데이터를 매핑하여 출력을 내보낸다.)
*/
var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Home', pageName:"home_11_26.ejs" });
});

/* http://localhost:3000/login */
router.get('/login', function(req, res, next) {
  res.render('index', { title: '로그인', pageName : 'auth_11_26/login_11_26.ejs' });
});

router.get('/book', function(req, res, next) {
  res.render('index', { title: '도서검색기', pageName : 'book_11_26/bookList_11_26.ejs' });
});

module.exports = router;
