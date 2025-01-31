// 함수를 반환하는 함수를 고차함수라고 한다.
// 리덕스 컨셉을 재현할 때 필요하다.
// 구독발행 모델
// 커리 함수
const sayHello = () =>{
  return function(){ // 고차함수라고 한다.
    console.log("hello")
  }
}

const myFunc = sayHello()
myFunc()