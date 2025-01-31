var express = require('express');
var router = express.Router();

/* GET home page. */
/* localhost:5000 엔터로 요청을 하면 6번이 인터셉트해서 homme_11_22.ejs를 요청한다. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Home', pageName : 'home_11_22.ejs' });
});

/* 로그인 화면 추가  */
/* localhost:5000/login 요청하면 views폴더 아래 auth폴더 아래 login_11_22.ejs 요청된다. */
/* localhost:5000 엔터를 하면 localhost.ejs */
router.get('/login', function(req, res, next) {
  res.render('index', { title: '로그인', pageName : 'auth_11_22/login_11_22.ejs' });
});

/* 도서검색 화면 추가 */
router.get('/book', function(req, res, next) {
  res.render('index', { title: '도서검색', pageName : 'book_11_22/bookList_11_22.ejs' });
});

module.exports = router;
