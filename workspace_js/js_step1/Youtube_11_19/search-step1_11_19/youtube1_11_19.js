const ajax = new XMLHttpRequest(); //비동기 통신 객체이다. - 생성
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
    content += `</li>` */
}
content += "</ul>";

document.querySelector("#root").innerHTML = content;
