const getList = (query, callback) => {
  fetch(`https://omdbapi.com/?apikey=51294d57&s=${query}`)
  .then(res => res.json()) // res을 출력하면 Promise가 인스턴스가 된다.
  .then(res =>{
    console.log(res)
    callback()
  })
}

// insert here
getList("avengers", ()=>{
  console.log("아이언맨")
})

getList("frozen", ()=>{
  console.log("겨울왕국")
})

getList("avater", () =>{
  console.log("아바타")
})