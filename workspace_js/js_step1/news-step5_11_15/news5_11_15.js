const container = document.querySelector("#home");
const content = document.createElement("div");
const NEWS_URL = "https://api.hnpwa.com/v0/news/1.json";
const CONTENT_URL = "https://api.hnpwa.com/v0/item/@id.json";

// 에로우 펑션은 2015년에 ECMAScript6에서 나왔다. Modern웹
const getData = (url) => {
  ajax.open("GET", url, false);
  ajax.send(); //실제 요청이 진행된다.
  return JSON.parse(ajax.response);
};

const ajax = new XMLHttpRequest()
const newsList = getData(NEWS_URL)
console.log(newsList)
// 디폴트로 보여줄 페이지 목록 가져오기
// n건을 처리해야 하니까 배열이 필요하다.
const getnewsList = () => {
  //뉴스 목록을 담을 배열을 선언하자
  const news = []
  news.push("<ul>")
  for (let i = 0; i < 30; i++) {
    news.push(`
        <li>
            <a href="#${newsList[i].id}">
            ${newsList[i].title}(✨${newsList[i].comments_count})
            </a>
        </li>
    `)
  } ////end of for
  news.push("</ul>");
  container.innerHTML = news.join(''); // 빈문자열을 넣어서 배열을 구분자 없는 문자열로 묶어준다.
};

//선택한 뉴스에 상세목록 가져오기
// 배열이 필요 없다.
// 다시 목록으로 돌아갈 수 있는 버튼을 추가하기
const newsDetail = () => {
  const id = location.hash.substring(1)
  const newsContent = getData(CONTENT_URL.replace("@id", id))
  container.innerHTML = `
    <h2>${newsContent.title}</h2>
    <div>
      <a href="#">목록으로</a>
    </div>
    `
}

const router = () => {
  console.log("router");
  const routerPath = location.hash
  if (routerPath === '') {
    getnewsList()
  } else {
    newsDetail()
  }
}
window.addEventListener('hashchange', router)
router()