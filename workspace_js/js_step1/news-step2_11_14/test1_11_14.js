function checkType(value){ //기본방식
  return typeof value;
}

checkType2 => (value2) => { //arrow function방식(에로우 펑션)
  return typeof value2
}

console.log(checkType(function(){})); //{} 으로 묶어 사용하면 오브젝트로 처리된다. null도 마찬가지로 오브젝트 처리된다.

const fruits = ["🍅", "🍓", "🍉"]
console.log(typeof fruits)
for(let x=0;x<3;x++){
  console.log(fruits[x])
}
const url = "#42130881"
console.log(url.substring(1))
console.log(url.substring(2))
console.log(url.substring(3))
console.log(url.substring(4))
console.log(url.substring(5))
console.log(url.substring(1,5))