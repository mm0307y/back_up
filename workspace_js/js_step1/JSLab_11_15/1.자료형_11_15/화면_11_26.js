// alert("안녕")

const btns = document.querySelectorAll("ul li")
console.log(btns.length)
/* 
호이스팅(hoisting)
: 블록안에서 선언된 지역변수가 코드 블록 밖으로 끌어 올려지면서 강제로 전역변수화 되는 현상

ES6가 지원되기 전에는 즉시 실행함수를 이용해서 이문제를 해결했다.
즉시 실행 함수
괄호가 2개 들어간다.
첫번째 - 함수의 선언부
두번째 - 함수 호출하는 괄호
익명함수 형태인데 호출 되는 이유는 두 번째 괄호가 있기 때문에 가능하다.

var로 선언된 변수는 즉시실행함수를 사용하더라도 동일한 결과를 보게된다.
즉시 실행함수 내부에서 사용된 index변수를 사용ㅎ애야 값이 변한다.
*/

for(var j = 0; j<btns.length; j++){
  ((index)=>{
    btns[index].addEventListener("click", () => {
      console.log(index) // 0 1 2 
    })
  })(j)
}////end of for