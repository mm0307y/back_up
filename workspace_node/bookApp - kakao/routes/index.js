const express = require("express");
const axios = require("axios");
const router = express.Router();

/* GET home page. */
/* localhost:5000 엔터로 요청을 하면 6번이 인터셉트해서 homme_11_22.ejs를 요청한다. */
router.get("/", function (req, res, next) {
  console.log("인증 후 nickName : " + req.session.nickname); // 최초에는 is not defined, null
  // 세션에 nickname이 있다면 홈페이지로 입장하고
  if (req.session.nickname) {
    res.render("index", {
      title: "Home",
      pageName: "home_11_22.ejs",
      nickname: req.session.nickname,
    });
  }
  // 세션에 nickname이 없다면 로그인 페이지로 입장하자.
  else {
    res.render("index", {
      title: "로그인",
      pageName: "auth_11_22/login_11_22.ejs",
      nickname: null,
    });
  }
});

/* 로그인 화면 추가  */
/* localhost:5000/login 요청하면 views폴더 아래 auth폴더 아래 login_11_22.ejs 요청된다. */
/* localhost:5000 엔터를 하면 localhost.ejs */
router.get("/login", function (req, res, next) {
  // "/"은 루트로 localhost:5000 엔터를 하면 그 쪽으로 이동이 된다. 그때 "/"를 붙이면 그쪽으로 이동된다.
  // "/"뒤에는 내가 이동하려고 하는 값을 작성해준다.
  res.render("index", {
    title: "로그인",
    pageName: "auth_11_22/login_11_22.ejs",
  });
});

/* 로그아웃 요청 추가 */
/* get 요청 하나하나가 미들웨어. 다음 미들웨어로 연결해주는 코드 next */
/* 첫번째 파라미터 : req는 요청객체이다. 세션생성, 세션삭제, 센셔추가 */
router.get("/logout", function (req, res, next) {
  // 세션 정보 삭제하기
  req.session.destroy();

  // 세션 정보 삭제되고 나면 home으로 이동

  // res.send() // 요청에 대한 메시지를 문자열로 내보낼 때
  // res.render() // 요청에 대한 응답요청을 내보낼 때
  res.redirect("/");
}); //// end of kakaoLogout

/* 카카오 로그인 */
router.get("/auth/kakao/callback", async (req, res, next) => {
  console.log("카카오 코드 받기 - " + req.query.code);
  const code = req.query.code;
  // Access token 가져오기
  try {
    // post 방식일 때 사용자가 입력한 값은 Body에 담긴다. get방식은 header에 담긴다. -400, 401 번 오류 뜨면 이걸 제대로 확인을 안한거다.
    // postman에서 화면없이 사용자가 입력한 값을 재연할 때는 x-www-form-urlencoded 옵션 체크하고 테스트 하세요.
    const res1 = await axios.post("https://kauth.kakao.com/oauth/token", null, {
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
      },

      params: {
        grant_type: "authorization_code",
        client_id: "6b10a8106270f172344447e5cec8953b",
        redirect_uri: "http://localhost:5000/auth/kakao/callback",
        code: code,
      },
    }); // 카카오 엑세스 토큰 가져오기 끝

    const accessToken = res1.data.access_token;
    console.log("accessToken : ", accessToken);

    // access Token을 이용하여 사용자 정보 가져오기
    const res2 = await axios.post("https://kapi.kakao.com/v2/user/me", null, {
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
        "Authorization": "Bearer " + accessToken,
      },
    }); // end of 사용자 정보 가져오기
    console.log(res2.data); // json포맷으로 응답을 받는다.

    const nickname = res2.data.properties.nickname;
    // const email = res2.data.kakao_account.email;

    // 사용자 정보를 성공적으로 가져왔다면 세션에 저장하기
    // 화면에서는 이 값에 대한 접근이 불가하다.
    // req.session.email = email;
    req.session.nickname = nickname;

    // 세션에 당장 저장해줘
    // 로그인 시키고 메인페이지로 이동
    req.session.save(() => {
      res.redirect("/");
    });
  } catch (error) {
    //// end of try
    console.error(
      "토큰 가져오기 실패 ",
      error.res1 ? error.res1.data : error.message
    );

    // 에러 응답 처리
    res.status(500).json({
      error: "카카오 서버로부터 토큰 접근에 실패하였습니다.",
      details: error.res1 ? error.res1.data : error.message,
    });
  } //// end of catch
}); //// end of kakaoLogin

/* 도서검색 화면 추가 */
router.get("/book", function (req, res, next) {
  res.render("index", {
    title: "도서검색",
    pageName: "book_11_22/bookList_11_22.ejs",
  });
});

/* 클라우드 서비스를 활요한 게시판 구현 */
router.get("/posts", function (req, res, next) {
  res.render("index", {
    title: "글목록",
    pageName: "posts_11_27/list_11_27.ejs",
  });
});

router.get("/posts/write", function (req, res, next) {
  res.render("index", {
    title: "글쓰기",
    pageName: "posts_11_27/write_11_27.ejs",
  });
});

router.get("/posts/:id", function (req, res, next) {
  // 사용자가 선택한 값을 쿼리스트링으로 받아오는 코드 추가한다.
  let id = req.params.id;
  res.render("index", {
    title: "상세보기",
    pageName: "posts_11_27/read_11_27.ejs",
    id: id,
  });
});

router.get("/posts/update/:id", function (req, res, next) {
  // 사용자가 선택한 값을 쿼리스트링으로 받아오는 코드 추가한다.
  let id = req.params.id;
  res.render("index", {
    title: "글수정",
    pageName: "posts_11_27/update_11_27.ejs",
    id: id,
  });
});

module.exports = router;
