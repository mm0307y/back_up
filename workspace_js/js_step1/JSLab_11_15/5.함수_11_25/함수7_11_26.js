a() // 함수도 호이스팅이 발생한다. 그래서 합법이다.
function a(){
  console.log("a 호출")
}

b()
const b = () => {
  console.log("b 호출")
}