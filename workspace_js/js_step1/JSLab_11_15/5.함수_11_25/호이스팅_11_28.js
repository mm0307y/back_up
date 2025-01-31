// other()

some()
const other = () =>{
  alert("other호출 성공")
}

function some(){
  alert("alert실행 안된다.")
  // alert은 브라우저가 객체가 소유주이므로 브라우저 아니면 동작을 안한다.
  console.log("some호출")
}