// 동기 Synchronous와 비동기 Asynchronous
// 동기 : 순차적으로 코드를 실행한다.
// 비동기 : 순차적으로 코드가 실행이 안된다.

console.log(1)
console.log(2)
console.log(3)

// 1 3 2 출력
console.log(1)
setTimeout(() => {
  console.log(2)
}, 1000);
console.log(3)