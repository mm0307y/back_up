import { getAuth, GoogleAuthProvider, signInWithEmailAndPassword, signInWithPopup } from "firebase/auth";

class AuthLogic0110 {
  // 생성자 함수
  constructor() {
    this.auth = getAuth();
    this.googleProvider = new GoogleAuthProvider();
    // this.githubProvider = new GithubAuthProvider();
  }

  // 생성자 함수에 초기화된 멤버변수를 외부에서 사용할 때 활용한다.
  getUserAuth = () => {
    return this.auth;
  };

  // 생성자 함수에 초기회된 멤버변수를 외부에서 사용할 때 활용한다.
  getGoogleProvider = () => {
    return this.googleProvider;
  };
} //// end of AuthLogic

export default AuthLogic0110;

// 외부에서 아래 함수를 호출하려면 함수 선언시 export를 붙여야 한다.
// 3000번 리액트서버에 구글 서버(firebase)측에 파라미터로 auth객체, 벤더 이름
// 화살표 함수 - 람다식(자바표현식 - 스프링 시큐리티)
// 구글에서 제공하는 소셜로그인 기능을 활용하기 위해서 API를 확인한다.
// 팝업으로 정보제공을 해준다. -> 파라미터가 2개 필요하다. -> getAuth(), 서비스 제공 업체정보가 필요하다.
// loginGoogle 사용자 함수 안에서 구글이 제공하는 signlnWithPopup함수를 호출해야 한다.
// 이 때 함수의 파라미터 자리에 두가지 정보가 필요하다.
// 개발자가 signinWithPopup함수를 호출하면 구글서버측에서 요청을 청취한다.
// waition(기다려 - 시간이 걸린다. - 비동기처리) - new Promise -> 처리가 되고 있는지 체크 한다. - 0-1-2-3-4
// 처리완료 -> 다운로드(4) -> result값이 담긴다.
// result에 무엇을 담아 주엇을까? 누가 -> firebase 인증팀
// result -> {user:{uid:abc, name:홍길동, email:XXX@hot.com, others:{키:값, 키:값, ...}}}
// 파라미터를 맞춘다. -> 파라미터 자리에 구글 서버에 채워줄께
export const loginGoogle = (auth, googleProvider) => {
  return new Promise((resolve, reject) => {
    signInWithPopup(auth, googleProvider)
      // .then(res)=> console.log(res.user.name))
      .then((res) => {
        // 인증에 성공하면 구글측에서 resolve함수를 호추랗고 실패하면 reject함수를 호출한다.
        // 화살표 함수의 리턴 자리에 좌, 우중괄호를 쓰면 실행문(변수, 조건문, 반복문)이 오는 자리이다.
        const user = res.user; // user는 어디에서 확인되나요?

        // 브라우저 메모리에 저장
        localStorage.setItem("uid", user.uid);
        localStorage.setItem("uid", user.email);
        resolve(user);
      })
      .catch((err) => {
        reject(err); // err을 출력하면 힌트얻기 - 디버깅
      });
  });
}; //// end of loginGoogle

// 로그아웃을 구글 서버에 요청하기 -> 기다림 -> 응답을 받아오기 -> 대기
// resolve뒤에 괄호가 없는데 함수가 맞나요? 네 -> 일급함수
// resolve와 reject은 둘다 함수가 맞다. -> 이 둘은 누가 언제 왜 호출하나요?
// 처리는 구구글 서버 리턴 함수의 파라미터 자리에 두 개의 함수 이름을 개발자 네가 정해서
// 호출해줘 -> 성공하면 resolve call, 실패하면 reject호출 할께
export const logout = (auth) => {
  // 함수 안에서 return으로 함수를 줄 수 있는거야? - 고차함수라 가능하다.
  return new Promise((resolve, reject) => {
    auth.sigOut().catch((error)=>{
      reject(alert(error+"로그아웃 오류입니다."));
    })
    // 에러가 없으면 여기로
    localStorage.removeItem("uid");
    localStorage.removeItem("email");
    resolve();
  });
};


// 로그인이 풀릴 때 처리하기 - 로그인 상태가 바뀌거니?
export const onAuthChange = (auth, setUser) => {
  return new Promise((resolve)=>{
    auth.onAuthChanged((user)=>{
      resolve(user);
    })
  })
}

// 이메일과 비밀번호로 로그인 하기
// 소셜로그인이나 비밀번호 모두 클라우드 서비스를 활용하므로
// 필연적으로 지연과 비동기적 상황이 발생한다.(Promise, axios, fetch)
// user={email:"kiwi@hot.com", password:"123"}
export const loginEmail = (auth,user) =>{
  console.log(user.email) // kiwi@hot.com 사용자가 입력한 이메일
  console.log(user.password) // 123 사용자가 입력한 비빌번호
  return new Promise((resolve, reject)=>{
    // google API가 제공하는 함수 호출하기
    // @param1 - auth(리덕스로 관리), @param2 - email, @param3 - 비번
    signInWithEmailAndPassword(auth, user.email, user.password)
    .then((userCredential) => {
      // Signed in
      const user = userCredential.user;
      localStorage.setItem("uid", user.uid);
      localStorage.setItem("email", user.email);

      // 콜백으로 받은 정보를 화면으로 넘겨서 재사용하려면 resolve파라미터에 담아준다.
      resolve(userCredential);
    })
    .catch((error) => {
      const errorCode = error.code;
      const errorMessage = error.message;
      console.log(`erroCode: ${errorCode}, errorMessage: ${errorMessage}`);
      reject(error);
    })
  })
}