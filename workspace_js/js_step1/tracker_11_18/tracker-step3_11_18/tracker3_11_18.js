//운동 목록 숫자 업데이트
const updateNavbarCount = () => {
  navbarCountRef.textContent = items.length
}

//운동이름 추가
/*
hello = () => {
  return "Hello World!";
}
*/
const handleAdd = (name) => {
  console.log(items.length) //0출력
  const newItem = {id:items.length +1, name: name, count: 0}
  items.push(newItem)
  //새로운 개체가 추가되면 화면을 새로고침 처리 한다.
  getWorkoutList()
  updateNavbarCount()
}//end of handleAdd
//증가
function handleIncrement(item){//{id, name, count}
  //count증가하기
  //console.log("증가하기 - "+ item + ", id : " + item.id)
  const index = items.indexOf(item)
  items[index].count += 1
  getWorkoutList()
}
//감소
function handleDecrement(item){
  //count 감소하기
  const index = items.indexOf(item)
  if(items[index].count > 0){
      items[index].count -= 1
  }
  getWorkoutList()    
}

//삭제 - 휴지통
function handleDelete(item){
  const index = items.indexOf(item)
  if(index > -1){
      items.splice(index, 1)
  }
  getWorkoutList()
  updateNavbarCount()
}
//목록 처리
function getWorkoutList(){
  console.log("getWorkoutList 호출")
  const workoutList = document.querySelector(".workout-list");
  workoutList.innerHTML = ""; //렌더링 전에 목록 지우기
  items.forEach((item) => {
      //console.log(item)
      const listItem = document.createElement("li")
      listItem.className = "workout"
      const workoutName = document.createElement("span");
      workoutName.className = "workout-name"
      workoutName.textContent = item.name //운동이름이 담김
      const workoutCount = document.createElement("span")
      workoutCount.className = "workout-count"
      workoutCount.textContent = item.count
      const btnIncrease = document.createElement("button");
      btnIncrease.className = "workout-button workout-increase"
      btnIncrease.addEventListener("click",() => handleIncrement(item))
      btnIncrease.innerHTML='<i class="fas fa-plus-square"></i>'
      const btnDecrease = document.createElement("button");
      btnDecrease.addEventListener("click",() => handleDecrement(item))
      btnDecrease.className = "workout-button workout-decrease"
      btnDecrease.innerHTML='<i class="fas fa-minus-square"></i>'
      const btnDelete = document.createElement("button");
      btnDelete.className = "workout-button workout-delete"
      btnDelete.addEventListener("click", () => handleDelete(item))
      btnDelete.innerHTML='<i class="fas fa-trash"></i>'
      listItem.appendChild(workoutName)
      listItem.appendChild(workoutCount)
      listItem.appendChild(btnIncrease)
      listItem.appendChild(btnDecrease)
      listItem.appendChild(btnDelete)
      workoutList.appendChild(listItem)
  })
}