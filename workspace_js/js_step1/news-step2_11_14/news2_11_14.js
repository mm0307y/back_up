//Web API에는 비동기 또는 동기를 지원하는 API가 있다. - XMLHttpRequest이다.
//웹서비스의 시작은 요청으로 부터 시작된다.
//오라클 서버 대신에 해커뉴스 서버에서 뉴스정보를 제공받는다. 그러기 위해 요청한다.
const NEWS_URL = "https://api.hnpwa.com/v0/news/1.json"
const CONTENT_URL = "https://api.hnpwa.com/v0/item/@id.json";
//비동기와 동기를지원하는 객체 - XMLHttpRequset
const ajax = new XMLHttpRequest();

//선택한 뉴스의 컨텐츠를 추가할 dive태그 생성하기
const content = document.createElement("div")

//어떻게 클릭 했는지 알수 있을까? -> a태그 - 링크 - 
ajax.open("GET", NEWS_URL, false);
ajax.send(); //실제 요청이 진행된다.

// console.log(ajax.response);
// hashChange 이벤트 리스너 - #을 붙인 값 - 변경여부 감지 - 후처리
// 이벤트 핸들러 이름은 hashChange - 해시가 변경되면 -> 감지한다.
// 이 값을 어떻게 가져오지? - location내장 객체로 가져온다.
window.addEventListener('hashchange', () => {
  //location.hash = #123456789
  const id = location.hash.substring(1)
  ajax.open("GET", CONTENT_URL.replace("@id", id), false);
  ajax.send(); //실제 요청이 진행된다.
  const newsContent = JSON.parse(ajax.response)
  const title = document.createElement("h1");
  title.innerHTML = newsContent.title;
  content.appendChild(title);
})

const newsList = JSON.parse(ajax.response);
const ul = document.createElement("ul");

for(let i = 0; i<5; i++){
  const li = document.createElement("li");
  const a = document.createElement("a");
  a.href = `#${newsList[i].id}`
  a.innerHTML = `#${newsList[i].title}(✨ ${newsList[i].comments_count})`
  li.appendChild(a);
  ul.appendChild(li);
}

document.querySelector("#root").appendChild(ul)
document.querySelector("#root").appendChild(content)

