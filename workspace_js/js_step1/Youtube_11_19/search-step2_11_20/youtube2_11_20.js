const keyword = document.querySelector("#keyword");

//input textfield에 입력한 후에 엔터 쳤을 때
keyword.addEventListener("keypress", (event) => {
  //엔터 키코드 값은 13이다.
    console.log("onkeypress가 엔터인지 아닌지" + event.keyCode);
  //사용자가 입력한 검색어를 찾는 함수 호출
    handleSearch();
});

const handleSearch = () => {
    const user = document.querySelector("#keyword").value;
    console.log("사용자가 입력한 검색어 ===>" + user);
    search(user);
};

const search = (user) => {
  //비동기 통신을 하여 요청결과를 얻어낸다.
    console.log("사용자가 입력한 user를 받는다.");
    const videoList = [];
    const ajax = new XMLHttpRequest();
    const key = "AIzaSyB3s74a5_0cgFU2HvL8O-eBsGLugxx9w94";
    const SEARCH_URL = `https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q=${user}&key=${key}`;

    ajax.open("GET", SEARCH_URL, false);
    ajax.send();

    const results = JSON.parse(ajax.response);

    videoList.push("<ul class='videos'>");
    for (let i = 0; i < 25; i++) {
    videoList.push("<li class='container'>");
    videoList.push("<div class='video'>");
    videoList.push("<img class='thumbnail'/>");
    videoList.push("</div>");
    videoList.push("<div>");
    videoList.push("<p class='title'>제목</p>");
    videoList.push("<p class='channelTitle'>채널제목</p>");
    videoList.push("</div>");
    videoList.push("</li>");
    }
    videoList.push("</ul>");
    document.querySelector("#root").innerHTML = videoList.join("");
};
/* const ajax = new XMLHttpRequest(); //비동기 통신 객체이다. - 생성
let content = "";
const SEARCH_URL = `https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q=손흥민&key=AIzaSyB3s74a5_0cgFU2HvL8O-eBsGLugxx9w94`;
// const SEARCH_URL = `http://127.0.0.1:5500/Youtube_11_19/search-step1_11_19/search_11_20.json`

ajax.open("GET", SEARCH_URL, false);
ajax.send();

const results = JSON.parse(ajax.response);
const mitems = results.items;
console.log(mitems); //{},{},{},,..........
console.log(mitems.length); //25출력

content += '<ul class="videos">';
for (let i = 0; i < mitems.length; i++) {
    content += `
        <li class="container">
            <div class="video">
                <img class="thumbnail" src="${mitems[i].snippet.thumbnails.medium.url}"></img>
            </div>
            <div>
            <p class="title">${mitems[i].snippet.title}</p>
            <p class="channel">${mitems[i].snippet.channelTitle}</p>
            </div>
        </li>
    `;
/* content += `<li class="container">`
    content += `<div class="video">`
    content += `<img src="${mitems[i].snippet.thumbnails.medium.url}"></img>`
    content += `</div>`
    content += `<div>`
    content += `<p class="title">${mitems[i].snippet.title}</p>`
    content += `<p class="channel">${mitems[i].snippet.channelTitle}</p>`
    content += `</div>`
    content += `</li>`*/
/*
}
content += "</ul>";

document.querySelector("#root").innerHTML = content;
 */
