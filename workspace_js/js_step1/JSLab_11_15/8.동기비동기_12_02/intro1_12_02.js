console.log(1)
console.log(2)
console.log(3)

// 함수 선언시 function을 사용하면 호이스팅이 일어나서
// 먼저 호출하더라도 정상적으로 출력이 된다.
hamsu1()
function hamsu1(){
  console.log("hamsu1")
}

// arrow function은 호이스팅이 일어나지 않는다.
warp()
const warp = () => {
  console.log("warp")
}


// 출력결과
// 1 2 3 순으로 출력된다. - 동기적이다.

// 위 결과를 비동기적으로 만들어 보자