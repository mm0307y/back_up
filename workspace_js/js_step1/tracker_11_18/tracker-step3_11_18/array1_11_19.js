const items = [
    { id: 1, name: "런지", count: 1 }
    , { id: 2, name: "스쿼트", count: 0 }
    , { id: 3, name: "데드리프트", count: 2 }
]

console.log(items.length)

items.push({ id: 4, name: "레그프레스", count: 5 })

console.log(items.length)

items.splice(0, 1)

console.log(items.length)
console.log(items)

const itemId = 2
const index = items.findIndex((item) => item.id === itemId)
console.log(index)
items.splice(index, 1)
console.log(items)