let items = [
  { id: 1, name: "밴치프레스", count: 10 },
  { id: 2, name: "랫풀다운", count: 7 },
  { id: 3, name: "스쿼트", count: 20 }
]

console.log(items.length)
let x = [...items]

console.log(x.length)
x = items.filter(item => item.id !== 1)
console.log(x)
x = [...x, {id:1, name: "덤벨프레스", count: 15}]

console.log(x)