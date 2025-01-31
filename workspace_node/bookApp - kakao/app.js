var createError = require("http-errors");
var express = require("express");
var path = require("path");
var cookieParser = require("cookie-parser");
const session = require("express-session");
var logger = require("morgan");

var indexRouter = require("./routes/index"); // 라우터 생성
var usersRouter = require("./routes/users"); // 라우터 생성

var app = express();

// view engine setup
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");
// app.set('view engine', 'html');

app.use(logger("dev"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(
  session({
    resave: false,
    saveUninitialized: false,
    secret: "iloveschool",
    // secret : process.env.SESSION_SECRET
    cookie: {
      maxAge: 1000 * 60 * 60, // 1hour
      secure: false, // HTTPS 환경에서만 쿠키를 전송하려면 true를 사용한다.
      httpOnly: true, // 클라이언트 자바스크립트에서 쿠키 접근 방지(외부 인터셉트 위변조 방어)
    },
  })
);
app.use(express.static(path.join(__dirname, "public"))); // 정적페이지에 대한 지원 설정 - 서버의 물리적인 배포 위치이다.

// 위에서 생성한 라우터 설정을 실행하는 코드
app.use("/", indexRouter);
app.use("/users", usersRouter); // 대시보드, 마이페이지, 장바구니 같은 권한을 가지고 진행되는 메뉴이다. 확인 잘해야 된다.

// 세션에 데이터 추가
app.get("/addSession", (req, res) => {
  req.session.addData = "addData";
  console.log(req.sessionID); // 쿠키에 관리
  res.redirect("/");
});

// 세션 삭제
app.get("/delete", (req, res) => {
  req.session.destroy();
});

// 세션 데이터 보기
app.get("/lookSession", (req, res) => {
  res.send(req.session);
});

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get("env") === "development" ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render("error");
});

module.exports = app;
