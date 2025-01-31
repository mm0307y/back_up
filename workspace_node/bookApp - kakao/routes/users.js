var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

/* 회원가입 추가 */
router.get('/join', function(req, res, next) {
  res.render('index', {title: "회원가입", pageName : "users_11_25/join_11_25.ejs"});
})

/* 회원가입 추가 */
/* mypage 추가 */
router.get('/mypage', function(req, res, next) {
  res.render('index', {title: "회원정보", pageName : "users_11_25/mypage_11_29.ejs"});
})

/* update */
router.get('/update', function(req, res, next) {
  res.render('index', {title: "회원수정", pageName : "users_11_25/update_11_29.ejs"});
})

/* 장바구니 */
router.get('/cart', function(req, res, next) {
  res.render('index', {title: "장바구니", pageName : "users_11_25/cart_12_03.ejs"});
})
module.exports = router;