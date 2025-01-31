//상수를 선언할 때 - const - 재정의 불가 - for문에서 사용이 불가하다. - final String msg = null; 자바상수
//변수를 선언할 때 - let - 변하는 값을 담는다. - for문에서 사용가능 하다. - final을 빼면된다.
const vertical = document.querySelector(".vertical");
const horizontal = document.querySelector(".horizontal");
const target = document.querySelector(".target");
const tag = document.querySelector(".tag")

document.addEventListener("mousemove", (event) => {
  const x = event.clientX;
  const y = event.clientY;

  console.log(`${x}, ${y}`)
  vertical.style.left = `${x}px`;
  horizontal.style.top = `${y}px`;

  target.style.left = `${x}px`;
  target.style.top = `${y}px`;

  tag.style.left = `${x}px`;
  tag.style.top = `${y}px`;
  
  tag.innerHTML = `${x}px`, `${y}px`;
})