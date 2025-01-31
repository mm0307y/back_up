/* 
  만일 어떤 네트워크에서 10초 동안 받아오는 이름이 있다고 가정해 본다.
  자바스크립트는 동기적으로 처리하므로 10초가 걸릴 경우 다음으로 진행하지 못하고
  기다리게 되는데 이때 화면에는 10초 동안 아무것도 출력되지 않은 상태에 놓이게 된다.
  이것은 문제가 된다.
  해결 방법은 오래 걸리는 일들은 비동기적으로 처리할 수 있도록 해주어야 한다.
  이럴 때 Promise를 사용한다.
*/

/* 
  상태변화 시각화
  1) pending(대기) 상태로 시작이 된다.
  2) 작업이 성공하면 fulfilled(성공, 이행) 상태로 변경이 되고, 실패하면 rejected(거부) 상태로 변경된다.
  3) 한번 fulfilled 또는 rejected 상태로 변경되면 다시 상태가 바뀌지 않는다.
*/
function getUser(){
  return new Promise((resolve, reject) =>{
    // reject(거부) - Promise 실패하여 에러 또는 이유를 반환한 상태
    // reject 함수가 호출되면 pending에서 rejected 상태로 전환
    // cathch() 메서드에 전달되는 콜백이 실행된다.
    // resolve("scott") // fulfilled(이행됨) - Promise가 상공적으로 완료되었다. 반환한 상태
    // return "scott" // Promise 상태가 pending 상태이다.
    // resolve나 reject가 호출되지 않은 상태
  })
}

const userName = getUser()
userName.then(console.log)
console.log(userName)