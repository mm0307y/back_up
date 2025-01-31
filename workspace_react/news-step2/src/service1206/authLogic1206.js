import {
  getAuth,
  signInWithPopup,
  GoogleAuthProvider,
  GithubAuthProvider,
} from "firebase/auth";

class AuthLogic1206 {
  constructor() {
    this.firebaseAuth = getAuth();
    this.googleProvider = new GoogleAuthProvider();
    this.githubProvider = new GithubAuthProvider();
  }

  //로그인 함수 구현
  login(providerName) {
    console.log(`providerName : ${providerName}`); //Google or Github
    const authProvider = this.getProvider(providerName);
    return signInWithPopup(this.firebaseAuth, authProvider);
  }

  //로그아웃 구현
  logout() {
    this.firebaseAuth.signOut();
  }

  //로그인 유지 상태를 체크하기
  onAuthChange(onUserChanged) {
    //사용자가 바뀌었을 때 콜백 함수를 받아서 처리
    this.firebaseAuth.onAuthStateChanged((user) => {
      //사용자가 바뀔 때 마다
      onUserChanged(user);
    });
  }

  //소셜로그인 회사에 따라 다른 객체 주입
  getProvider(providerName) {
    switch (providerName) {
      case "Google":
        return this.googleProvider;
      case "Github":
        return this.githubProvider;
      default:
        throw new Error(`not supported provider : ${providerName}`);
    }
  }
}
export default AuthLogic1206;
