import number from './module1_12_02'
import xyz from "./module1_12_02.js"
import {arr, hamsu, add} from './module1_12_02.js'
import * as all from './module1_12_02.js'

console.log(number) // 123
console.log(xyz)
console.log(arr)
console.log(hamsu)
hamsu()
console.log(add(4, 5))
console.log(all)
console.log(all.hamsu)
console.log(all.add(4, 5))