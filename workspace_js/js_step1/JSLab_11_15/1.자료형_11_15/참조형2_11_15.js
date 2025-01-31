let kiwi = {
  name : "kiwi",
  display : "🥝"
}

//객체 타입은 참조값이 복사되어 전달된다.
//얕은복사 인가? 깊은 복사인가.
let tomato = kiwi

console.log(kiwi)

console.log(tomato)

kiwi.name = "tomato"
console.log(kiwi)
console.log(tomato)

tomato.display = "🍅"
console.log(tomato)
console.log(kiwi)
console.log(tomato[`display`])