const items = [
  { id: 1, name: "밴치프레스", count: 0 },
  { id: 2, name: "랫플다운", count: 0 },
  { id: 3, name: "스쿼트", count: 0 },
]

items.forEach((item) => {
  console.log(items.indexOf(item))
  console.log(items[items.indexOf(item)].count) //[object Object]
  console.log(items[items.indexOf(item)].count + 1) //[object Object]
  console.log(items.id)
  console.log(items.name)
  console.log(items.count)
});

const sonata = {
  carName : "2024년형 소나타",
  speed: 50,
  whellNum : 4
}

console.log(sonata.carName)
console.log(sonata.speed)
console.log(sonata.whellNum)
