const mysql = require("mysql2/promise");

// DB연결 풀 객체
// 함수 호이스팅을 사용해야 한다면 반드시 function붙일 것
// 호이스팅이 필요한 경우는 카카오 API를 활용하기 등 외부 라이브러리나 오픈소스 사용시 필수이다.
let connect;
exports.connect = async () => {
  try {
    connect = mysql.createPool({
      connectionLimit: 100,
      host: "localhost", // 192.168.0.24
      user: "root",
      password: "Jin+119*",
      database: "webdb",
      waitForConnections: true, // 연결이 가득 찬 경우에 대기
      queueLimit: 0, // 대기열 제한 없다.
    });
    console.log("MySQL 커넥션풀 생성 완료");
  } catch (error) {
    console.error("MySQL 커넥션풀 생성 중 오류 발생 : " + error);
    throw error;
  }
};

// 외부에서 커넥션 풀을 활용하도록 연결 풀 반환하는 함수 선언
exports.get = () => {
  if (!connect) {
    throw new Error("커넥션 풀이 생성되지 않았씁니다.");
  }
  return connect; // 고차함수 - 함수를 리턴으로 반환할 수 있다.
};

// 일급함수 - 파라미터로 함수의 주소번지를 넘길 수 있다.
