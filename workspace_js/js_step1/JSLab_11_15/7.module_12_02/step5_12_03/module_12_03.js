import myCar from "./export1_12_03.js";
import { loginGoogle, loginKakao } from "./export1_12_03.js"; // 디폴트가 아닐경우 좌,우 중괄호를 사용해야 한다.

console.log(myCar);
console.log(myCar.carName);
console.log(myCar.wheelNum);
console.log(myCar.speed);
loginGoogle();
loginKakao();

// import문에 사용되는 좌,우 중괄호는 구조분해 할당에 쓰는 기호이다.
