const myPromise = new Promise((resolve, reject) => {
  const success = false
  setTimeout(() => {
    if (success) {
      resolve("작업성공");
    } 
    else {
      reject("작성 실패");
    }
  }, 1000);
});

myPromise
  .then((result) => console.log("fullfilled", result))
  .catch((error) => console.log("rejected 상태", error))
console.log("pending 상태 : 작업이 진행중입니다.")