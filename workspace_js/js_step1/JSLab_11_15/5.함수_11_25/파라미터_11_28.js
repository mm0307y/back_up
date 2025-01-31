// 매겨변수는 기본값이 무조건 undefinde이다.
// 화살표 함수는 호이스팅이 안된다.
// 자바와는 달리 같은 이름의 함수를 여러개 가질 수 없다.
// 파라미터와 갯수가 달라도 함수 이름이 같으니까 호출이 된다. (자바는 안된다.)

function hap(a, b){
  console.log(`${a}, ${b}`)
}

hap()
hap(1, 2)

function hap2(a=2, b=3){
  console.log(`${a}, ${b}`)
}
hap2()

function hap3(... numbers){
  console.log(typeof numbers)
  
  // object타입 중에서도 대괄호가 있으니까 배열이다.
  console.log(numbers)
  console.log(numbers[0])
}
hap3(1, 2, 3, 4, 5)

function hap4(a, b, ... numbers){
  console.log(typeof numbers)

  // object타입 중에서도 대괄호가 있으니까 배열이다.
  console.log(numbers)
  console.log(numbers[0])
}
hap4(1, 2, 3, 4, 5)