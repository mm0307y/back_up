const ajax = new XMLHttpRequest()

ajax.open("GET", "http://127.0.0.1:5500/Youtube_11_19/search-step1_11_19/videos.json", false);
ajax.send();

const most = JSON.parse(ajax.response);
console.log(most);

//배열의 수를 출력하시오.
const mitems = most.items
console.log(mitems)
console.log(mitems.length) //25 - 원소의 수

/* 
3. Map문을 사용했을 때
*/
mitems.map ((item) =>{
  console.log(item.id)
})

/* 
2. forEach문을 사용했을 때
mitems.forEach ((item) =>{
  console.log(mitems[0].snippet.thumbnails.medium.url)
  console.log(mitems[0].snippet.description)
  console.log(mitems[0].snippet.channelTitle)
})
*/

/* 
1. for문을 사용했을 때
for(let i=0; i<mitems.length; i++){
  console.log(mitems[0].snippet.thumbnails.medium.url)
  console.log(mitems[0].snippet.description)
  console.log(mitems[0].snippet.channelTitle)
}
 */