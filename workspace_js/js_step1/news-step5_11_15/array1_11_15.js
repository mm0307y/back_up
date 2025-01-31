const view = []
view.push("<h1>")
view.push("오늘의 날씨")
view.push("</h1>")

const response = view.join("")

//['<h1>', '오늘의 날씨', '</h1>']
console.log(view)
//'<h1>오늘의 날씨</h1>'
console.log(response)
//'<h1>,오늘의 날씨,</h1>'
console.log(view.toString())

const container = document.querySelector("#root");
container.innerHTML = response;