// 구조 분해 할당 (Destructuring assignment)
// 배열 데이터와 객체 데이터에서 사용 가능하다.

const obj ={
  a:1, b:2, c:3, x:7, y:100
}

console.log(obj.a)
const i = obj.a
const j = obj.b

const {...rest} = obj
console.log(rest)

// rest1에 출력이 좌, 우중괄호 이면 object이다.
const {c, ...rest1} = obj
console.log(c,rest1, rest1["a"], rest1.x)