// Resolve와 Reject 그리고 에러 처리
const delayAdd = (user, cb, errorCB) =>{
  setTimeout(() => {
    if(user > 10){
      errorCB(`${user}는 10보다 클 수 없습니다.`)
      // 입력값이 유효하지 않은 값이므로 함수를 종료한다.
      return // if문에서 return을 만나면 함수가 종료된다.
    }
    console.log(user)
    cb(user +1)
  }, 1000)
}

// insert here
// 테스트 시나리오 - 만일 5를 입력 받았으면 에러함수는 호출이 안된다.
// 성공일 땐 5에 1을 더한 6이 출력된다.
delayAdd(
  9,
  res => console.log(res),
  err =>console.error(err)
)