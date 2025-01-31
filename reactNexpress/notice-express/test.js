var express = require("express");
var router = express.Router();
var db = require("../db");

/* GET users listing. */
router.get("/", function (req, res, next) {
  res.send("respond with a resource");
});

//http://localhost:5000/users/notice/list
router.get("/notice/list", function (req, res) {
  const { gubun, keyword } = req.query;
  let sql = "select n_no, n_title, n_writer, n_content from notice";
  //조건 검색을 위해 사용자로 부터 받아오는 값에 따라 쿼리문을 변경 할것.
  let params = [];
  if (gubun && keyword) {
    //사용자로 부터 둘 다 받아왔을 때 조건 쿼리문 추가
    if (gubun === "n_title") {
      //select콤보에서 제목을 클릭했을 때
      sql += " WHERE n_title LIKE ?";
    } else if (gubun === "n_writer") {
      //작성자를 클릭했을 때
      sql += " WHERE n_writer LIKE ?";
    } else if (gubun === "n_content") {
      //내용을 클릭했을 때
      sql += " WHERE n_content LIKE ?";
    }
    params.push(`%${keyword}%`);
  } //end of 사용자로 부터 조건값을 받았을 때
  //내림차순으로 정렬 추가
  sql += " ORDER BY n_no desc";
  db.get().query(sql, params, function (err, rows) {
    if (err) return res.sendStatus(400);
    console.log(rows);
    //res.render('index', { title: 'Express' });페이지를 출력할 때
    res.send(rows); //데이터셋을 출력할 때
  });
});

//-> POST - http://localhost:5000/users/notice/insert
//공지글 쓰기
router.post("/notice/insert", function (req, res) {
  //사용자가 화면에서 입력한 값 담기
  const { n_no, n_title, n_writer, n_content } = req.body;
  const sql = "insert into notice(n_title, n_writer, n_content) values(?,?,?)";
  db.get().query(sql, [n_title, n_writer, n_content], function (err, result) {
    if (err) {
      //입력 실패했을 때
      console.error("Database error : ", err);
      return res.sendStatus(500);
    } else {
      //입력 성공했을 때
      console.log("insert result : ", result);
      res.send({ success: true, result });
    }
  });
});
//공지글 수정
router.post("/notice/update", function (req, res) {
  //사용자가 화면에서 수정한 값 담기
  const n_no = req.params.n_no;
  const { n_title, n_writer, n_content } = req.body;

  //필수 필드 확인
  if (!n_title || !n_writer || !n_content) {
    console.error("Missing fields : ", req.body);
    return res.status(400).send("요청한 데이터가 틀렸을 때.");
  }

  const sql = "insert into notice(n_title, n_writer, n_content) values(?,?,?)";
  db.get().query(
    sql,
    [n_no, n_title, n_writer, n_content],
    function (err, result) {
      if (err) {
        //입력 실패했을 때
        console.error("Database error : ", err);
        return res.sendStatus(500);
      } else {
        //입력 성공했을 때
        console.log("insert result : ", result);
        res.send({ success: true, result });
      }
    }
  );
});
module.exports = router;
