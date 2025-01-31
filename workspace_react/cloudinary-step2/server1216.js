// node_moudles에 있는 express 관련 파일을 가져온다.
const express = require("express");
const path = require("path");
const app = express();
const port = 5000;

app.get("*", function (req, res) {
  res.sendFile(path.join(__dirname + "/build", "index.html"));
});

app.listen(port, () => {
  console.log(path.join(__dirname + "/build", "index.html"));
});
