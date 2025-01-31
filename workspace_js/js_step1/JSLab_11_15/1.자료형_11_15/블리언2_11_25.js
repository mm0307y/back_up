// 거짓인거 6가지
// 1. false
// 2. 0
// 3. null
// 4. undefined
// 5. NaN (Not a number)
// 6. "", 빈문자열 = (empty string) / 안녕, 내일 봐, 1, 10000은 참이다.

if(123){
  console.log("참")
}

if('0') console.log("문자열 0은 참이다. 속지 말자")

if(NaN){

}
else{
  console.log("NaN도 false이다.")
}

if(null){

}
else{
  console.log("null도 false이다.")
}

if(undefined){

}
else{
  console.log("undefined도 false이다.")
}

if(""){

}
else{
  console.log("빈문자열도 false이다.")
}