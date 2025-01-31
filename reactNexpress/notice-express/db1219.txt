var mysql = require("mysql2");
var connection;
exports.connect = function () {
  connection = mysql.createPool({
    connectionLimit: 100,
    host: "localhost", // 192.168.0.24
    user: "root",
    password: "Jin+119*",
    database: "webdb",
  });
};
exports.get = function () {
  return connection;
};
