function Person() {}

const kim = new Person();
const park = new Person();

Person.prototype.getType = function () {
  return "test";
};

console.log(kim.getType()); // test
console.log(park.getType()); // test
