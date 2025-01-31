// 함수를 다른 변수와 동일하게 다루는 언어는 일급함수를 가졌다.
// 함수를 다른 함수에 인수로 제공하거나, 함수가 함수를 반환할 수 잇으며
// 변수에도 할당 할 수 있다.(리액트에서 리덕스 구현하는데 아이디가 된다.)

function sayHello(){
  return "hello"
}
function greeing(helloMessage, name){
  console.log(helloMessage() + name)
}

greeing(sayHello, "JavaScript")