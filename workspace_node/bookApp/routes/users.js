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
module.exports = router;