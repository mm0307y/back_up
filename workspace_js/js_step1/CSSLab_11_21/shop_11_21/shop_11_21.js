// 우리가 필요하는 DOM요소 선언
// ul
const items = document.querySelector(".items")
const input = document.querySelector(".footer_input")
const addBtn = document.querySelector(".footer_plus")
const deletBtn = document.querySelector(".footer_delete")
const shopList = []

// 사용자가 입력한 텍스트를 받아서 li태그에 추가한다.
const onAdd = ()=> {
  const text = input.value
  console.log(text)
  if (text === ""){
    input.focus()
    return; // onAdd함수를 탈출한다. - 처음부터 똑바로 사용하기
  }
  // 뭔가를 입력했다면 item 객체를 추가하기
  // 새로운 아이템을 만든다.(상품명 문자열 + 삭제버튼)
  const item = createItem(text) // 사용자가 입력한 상품명
  // items(ul) 안에 새로 만든 아이템을 추가한다.
  // items.appendChild(item)
  // items.innerHTML += item
  shopList.push(item)

  // 인풋을 초기화 한다.
  input.value = ""
  input.focus()
}

// onAdd함수에서 호출하는 함수 입니다.
// onAdd함수에서는 사용자가 입력한 상품을 파라미터로 넘긴다.
const createItem = (text) => {
  // 태그를 문자열로 처리하였기에 직접 이벤트 적용이 불가하다.
  // 이럴 경우에는 무조건 DOM API를 활용하여 태그를 생성해야 한다.
  // 이러면 이벤트 적용을 직접할 수 있다. - 그냥 문자열이 아니라 HTMLElement취급을 받는다.
  const itemRow = `
    <li class="item_row">
      <div class="item">
        <span class="item_name">${text}</span>
        <button class="item_delete">
          <i class="fas fa-trash-alt"></i>
        </button>
      </div>
      <div class="item_divider"></div>
    </li>  
  `
  return itemRow;
}

addBtn.addEventListener("click", (event) =>{
  onAdd();
  items.innerHTML = shopList.join("")
})

input.addEventListener("keyup", (event) => {
  //이벤트 발동한 이벤트 소스값 확인하려면 아래 코드를 출력해 보시오.
    console.log("key =====>" + event.key)
    if(event.key === "Enter"){
      onAdd();
      items.innerHTML = shopList.join("")
    }
  })

deletBtn.addEventListener("click", (event) => {
  
  })
