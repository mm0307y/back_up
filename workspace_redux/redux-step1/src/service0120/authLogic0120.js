import { getAuth, GoogleAuthProvider } from "firebase/auth"; // Firebase Auth import

class AuthLogic0120 {
  // 생성자 함수 선언하기 - 초기화
  constructor() {
    this.auth = getAuth();
    this.googleProvider = new GoogleAuthProvider();
  }

  // 생성자 함수에 초기화 된 정보를 외부에서 참조할 때 사용할 함수 선언
  // getter 함수
  // 우리가 LoginPage.jsx에서 구글 로그인을 할 때 auth정보가 필요하다.
  // 다른 외부 함수에서 필요한 경우 이므로 props를 통해서 내려 줘야 한다.
  // 리덕스를 사용하면 props로 일일이 내리지 않고 직접 auth정보를 활용할 수 있다.
  getUserAuth = () => {
    return this.auth;
  };

  // 구글인증제공자 정보 반환하기 - getter함수
  getGoogleAuthProvider = () =>{
    return this.googleProvider;
  }
} //// end of AuthLogic

export default AuthLogic0120;