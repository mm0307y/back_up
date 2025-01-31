const dateInfo = new Date();
console.log(dateInfo)

let id = dateInfo.getTime();
console.log(id)

const dateFormat =(time) =>{
  // 한자리 숫자야? 
  if(parseInt(time) < 10){
    return '0' + time
  }
  else{
    return time
  }
}

const year = dateInfo.getFullYear();
console.log(year)

const month = dateInfo.getMonth() + 1
console.log(month);

const date = dateInfo.getDate()
console.log(date)

const sec = dateInfo.getSeconds()
console.log(sec)

id = 0;
let curtiom = ''
const setClock = () =>{
  const dataInfo = new Date()
  id = dataInfo.getTime()

  const hour = dateFormat(dataInfo.getHours())
  const min = dateFormat(dataInfo.getMinutes())
  const sec = dateFormat(dataInfo.getSeconds())
  // return "15:28:47"
  curtiom = hour + ":" + min + ":" +sec
}