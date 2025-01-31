// null은 값이 존재하지 않는다.
let age = null
console.log(age)

// 타임라인을 변경할 때 사용한다.
setTimeout (() => {
  age = 30
  console.log(age)
},3000) //밀리세크 단위 (3000이 3초이다.) 3초간 지연

/* 
setTimeout (function () {

}) 
*/