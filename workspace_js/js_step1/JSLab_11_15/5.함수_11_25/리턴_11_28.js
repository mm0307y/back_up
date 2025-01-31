// return 명시적으로 쓰지 않으면 undefined이 반환된다.
// 함수 중간에 사용하면 함수가 종료된다. - 중요 - 흐름을 바꾼다.
function hap(a, b){
  console.log(a+b)
}
let imsi = hap(2, 3)
console.log(imsi)

function hap2(a, b){
  console.log(a+b)
  return a+b
}
imsi = hap2(2, 3)
console.log(imsi)

function hap3(a, b){
  if(a < 0) return
  console.log("여기")
}

hap3(1)