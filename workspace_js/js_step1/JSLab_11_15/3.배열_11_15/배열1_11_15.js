/* 
  배열 : Array
  연관된 값들을 하나의 그룹ㅇ으로 묶어서 나열한 자료구조
*/

const fruits = ["🍉", "🍎", "🥝"];
console.log("좋아하는 과일은 ", fruits);
fruits.forEach((item) => console.log(item)); //배열에 저장된 값을 하나하나 쪼개서 보여주는 코드

// 내장 함수 빈도
// toString() - 배열을 문자로 변환한다.
const result = fruits.toString();
console.log(result); 

// join() - 파라미터에 준 구분자를 활용해 문자열로 이어붙여 준다.
const result2 = fruits.join("+");
console.log(result2);

// push() - 배열에 값를 추가하는 함수
fruits.push("🍅");
console.log(fruits);