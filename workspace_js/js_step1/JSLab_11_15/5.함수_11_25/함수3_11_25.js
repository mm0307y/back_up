// 함수는 하나의 데이터 이다.

const getNumber = function(){
  return 123
}

const getNumber2 = () => {
  return 5
}

console.log(typeof getNumber)
console.log(typeof getNumber()) // number 출력, 왜냐하면 타입을 묻는거니까
console.log(getNumber()) // 123 출력, 왜녀하면 값을 묻는거니까
console.log(typeof getNumber2) // number 출력
console.log(getNumber2) // 5가 출력, 왜냐하면 값을 묻는 거니까, 타입을 묻는 것이 아니라
