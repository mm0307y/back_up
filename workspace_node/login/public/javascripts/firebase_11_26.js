// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/11.0.2/firebase-app.js";
// 구글 파이어베이스에서 제공하는 firebase-app.jsp에 intializeApp함수가 정의되어 있다.
// 외부에 js파일에 제공하는 함수를 사용하려면 import를 할 수 있다. - NodeJs - 브라우저와 별개로 작업이 가능하다.

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries
// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyAF_QeapaYa0SO4Q4RLivzjodBExQ8HsZQ",
    authDomain: "slalom2024-d0918.firebaseapp.com",
    projectId: "slalom2024-d0918",
    storageBucket: "slalom2024-d0918.firebasestorage.app",
    messagingSenderId: "1014655866177",
    appId: "1:1014655866177:web:a99f6ce99ce1f4c6943dc0"
};
// 이 파일에서 생성된 객체를 외부에서 사용하려면 변수 선언 앞에 export를 붙인다.
// initializeApp 호출할 때 파라미터로 firebaseConfig객체가 제공하는 값들을 넘긴다.
// 인증된 클라이언트 정보를 쥔다.
// header.ejs에서 사용하기 위해서 변수 선언 앞에 export를 붙인다.
// 로그인(구글 이메일 비번)을 진행하는 login.ejs에서도 app객체를 사용한다.
// 해당 파일(login.ejs, header.ejs)에서 app출력해 보면 위 firebaseConfig에 내용이 있다.

// Initialize Firebase
export const app = initializeApp(firebaseConfig);