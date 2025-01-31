/* 
  함수란 특정한 일을 수행하는 코드의 집합이다.
  장점 : 묵어두면 재사용이 가능하고 높은 가독성을 가지면서 유지보수에 좋다.

  언제 선언하는가
    : 똑같은 일을 계속 반복하는게 아니라 함수로 만들어서 필요할 때 마다 재사용이 가능하다.

  자바 스크립트에서 함수는 객체이다.
  자바 스크립트에서는 리턴타입을 선언하는 자리가 없다. - 컴파일을 하지 않아서 그런가?
  자바 스크립트에서는 런타임에 타입이 결정된다.
  return을 쓰지 않으면 undefined가 반환된다. - 디폴트
*/

// ES6 - arrow function
// functioon hello(){}

const hello = () => {
  console.log(`hello`)
  
}

// hello()

// 질문 - 자바 스크립트에서는 함수도 파라미터로 넘길 수 있다.
// 그헐다면 hello() 와 hello는 다른가? 아니면 같은 걸까.
console.log(hello)

// hello함수에 반환값이 없으니깐 undefined가 출력된다.
// 만일 return뒤에 값을 주면 그 값이 출력 된다.
console.log(hello())

let a
console.log(a)