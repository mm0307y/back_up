// 커리 함수는 함수를 매개변수로 받는다.
// 커리 함수는 실행ㅅ이점에 매개변수로 받은 함수의 인자를 사용하는 함수를 다시 반환한다.
// 반환되는 함수는 Lexical scope 개념에 의해 커리함수에 전달된 함수를 기억한다.

function sum(num1, num2) {
  return num1 + num2;
}

console.log(`sun ===> ${sum(10, 20)}`);

function curry(func) {
  return function (a) {
    return function (b) {
      return func(a, b);
    };
  };
}

const x = (func) => (a) => (b) => func(a, b);

const curried = curry(sum);
const example1 = curried(20);
const example2 = example1(30);
console.log(example2);

const example3 = curried(30)(40);
console.log(example3);

const greetCurried = function (greeting) {
  return function (name) {
    console.log(greeting + ", " + name);
  };
};

const greetHello = greetCurried("Hi");
greetHello("이순신");
greetHello("김유신");

const greetCurried2 = (greeting) => (name) =>
  console.log(greeting + ", " + name);

greetCurried2("Morning")("강감찬");
