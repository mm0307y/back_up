const getList = (query, callback) => {
  return new Promise((resolve) => {
    fetch(`https://omdbapi.com/?apikey=51294d57&s=${query}`)
      .then((res) => res.json()) // res을 출력하면 Promise가 인스턴스가 된다.
      .then((res) => {
        console.log(res);
        resolve();
      });
  });
};

// insert here
// 이 위치에 wrap()을 사용하면 에러 발생 - 호이스팅이 화살표 함수에서는 없다.
const wrap = async () => {
  console.log("겨울왕국");
  await getList("frozen");
  console.log("아이언맨");
  await getList("avengers");
  console.log("아바타");
  await getList("avater");
};

// 선언한 후에 호출이 가능하다.
wrap();
