const array1 = [{"id":1, "name":"강감찬", "age":30}, {"id":2, "name":"강감찬2", "age":32}];

array1.forEach((element) => {
  console.log(element["age"])
  console.log(element.name)
});
