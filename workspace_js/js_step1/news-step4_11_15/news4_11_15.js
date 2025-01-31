const container = document.querySelector("#home");
const NEWS_URL = "https://api.hnpwa.com/v0/news/1.json"
const CONTENT_URL = "https://api.hnpwa.com/v0/item/@id.json";

function getData(url) {
  ajax.open("GET", url, false);
  ajax.send(); //실제 요청이 진행된다.
  return JSON.parse(ajax.response)
}
const ajax = new XMLHttpRequest();
const content = document.createElement("div")
//바로 이럴때 전역변수를 사용하는 것이다. - NEWS_URL
const newsList = getData(NEWS_URL)

window.addEventListener('hashchange', () => {
  const id = location.hash.substring(1)
  const newsContent = getData(CONTENT_URL.replace("@id", id))
  const title = document.createElement("h1");
  title.innerHTML = newsContent.title;
  content.appendChild(title);
})

const ul = document.createElement("ul");
for(let i = 0; i<10; i++){
  const div = document.createElement("div");
  div.innerHTML = ` 
    <li>
      <a href="#${newsList[i].id}">
        ${newsList[i].title}(✨ ${newsList[i].comments_count})
      </a>
    </li>
    `
  ul.appendChild(div.firstElementChild)
}

//원처이 하나인데 사용하는 곳이 여러군데 이면 그 사용한 갯수에 다라 바꾸어야 하는 ㅜㅁ제가 있다.
//예를 들어 root가 아니라 home으로바뀌면 두 군데 모두 수정해야 한다.
container.appendChild(ul)
container.appendChild(content)