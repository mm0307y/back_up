// 생성자 함수가 있다.
/* 
함수형 프로그래밍이 인기이다. 그래서 설명해주는 거다.

1. 선언적 함수 : 이름을 붙여서 정의해 놓은 형태
- 자바 스크립트 파일을 읽을 때 선언적 함수를 우선적으로 읽어준다.
- 호출 위치가 자유롭다.

2. 익명 함수 : 함수의 이름이 없이 정의하는 형태
- 익명함수 자체로는 호출이 불가하다.
- 변수에 함수를 대입하거나 특정 이벤트 객체에 대입하는 식으로 호출이 가능하다.

3. 대입형 함수 : 변수에 익명 함수가 대입된 형태
4. 즉시 실행함수 : 함수가 자기자신을 정의하자마자 바로 자신을 호출한다.
*/

function Counter(){
  this.sum = 0
  this.count = 5
}

const obj = new Counter()
console.log(obj.count)
obj.sum +=2
console.log(obj.sum)

function methodA(){ //선언적 함수.
  const a = 1
  const b = 2
  console.log(a+b)
  return a+b // 리턴 값이 없으면 결과 값이 안 나온다.
}
methodA()

const z = methodA()
console.log(z)
// z()

const x = methodA
x()