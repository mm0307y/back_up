const a = 1
const b = 2
const c = 3


console.log (a == b)
console.log (a!=b)

// 일치
console.log (a == b)
console.log (a === b)
console.log (b == c)
console.log (b === c) // equal이 세개면 타입이 같은지 까지 비교한다. 그래서 false이다.

// 불일치
console.log (b !== c)
console.log (a >b)
console.log (a <= b) // 작거나 같다. 합집합 - 둘 중에 하나만 맞아도 참이다.