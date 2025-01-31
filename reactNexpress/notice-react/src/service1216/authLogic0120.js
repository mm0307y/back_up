import { createUserWithEmailAndPassword, EmailAuthProvider, getAuth, GoogleAuthProvider, sendEmailVerification, signInWithPopup } from "firebase/auth";

class AuthLogic0120 {
  // 생성자 함수 선언하기 - 초기화
  constructor() {
    this.auth = getAuth()
    this.googleProvider = new GoogleAuthProvider()
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
  getGoogleAuthProvider = () => {
    return this.googleProvider;
  };
} // end of AuthLogic

export default AuthLogic0120;

// 로그인 화면에서 호출할 함수 구현
// 구글 로그인 버튼 클릭시 호출되는 함수로 파라미터인 auth와 googleProvider는
// props로 받지 않고 리덕스를 활용해서 직접 받아낸다.
// 자바스크립트는 기본적으로 동기적으로 처리를 한다. 외부에 클라우드 서비스를 활용하면
// 필연적으로 지연이 발생할 것이고 이것을 효율적으로 처리하는 방법은 기다림 동안
// 다른 업무를 처리할 수 있도록 코딩을 전개하는 것이다.
// 표준에서 제공되는 protype Promise를 사용하여 성공 시 resolve 콜백 호출이
// 실패 시에는 reject 콜백 호출이 일어난다.
export const loginGoogle = (auth, googleProvider) => {
  return new Promise((resolve, reject) => {
    signInWithPopup(auth, googleProvider)
      .then((result) => {
        const user = result.user; // user가 라벨값이다.
        console.log(user);
        localStorage.setItem("uid", user.uid);
        localStorage.setItem("email", user.email);
        resolve(user);
      })
      .catch((e) => reject(e));
  });
}; //// end of 구글 로그인 - 로그인 화면에 구글 로그인 추가
// 사실 이미 구글 firebase에서는 비동기를 지원하고 있다. - Promise를 안해도 된다.

export const onAuthChange = (auth) => {
  // 바닐라 스크립트에서 제공하는 프로토타입 비동기 처리 객체
  // 파라미터를 갖는다. -> 콜백함수 -> 일급함수 -> 자동으로 담는다. -> 상태를 체크하고 그 상태값이 확인되면 그 정보를 담아준다.(콜백함수를 통해서)
  return new Promise((resovle) => {
    // firebase 웹로그인에서 제공하는 API이다. - 현재 네가 열은 크롬에 로그인이되어 있어? 체크
    // uid있다. ->회원가입 유도 한다.
    // 그럼 네 이메일로 오라클 서버에  가서 member250120테이블에서 이메일이 존재하는지를 체크할께
    auth.onAuthStateChanged((user) => {
      resovle(user); // 파라미터에 담긴 user는 구글이 쥐고 있는 정보이다. - 구글로 로그인을 했어 - user.emailVerified
    });
  });
};

export const logout = (auth) => {
  return new Promise((resolve, reject) => {
    auth.signOut().catch((e) => reject(alert(e + " : 로그아웃 오류 입니다.")));
    // insert here - localStorage에 있는 모든 값 삭제하기
    localStorage.removeItem("email");
    localStorage.removeItem("nickname");
    localStorage.removeItem("uid");
    localStorage.removeItem("auth");
    localStorage.removeItem("no");
    localStorage.removeItem("status");
    resolve();
  });
}; // end of logout

// 회원가입 화면에서 가입하기 버튼 누르면 구글 계정에 대한 uid값을 받아오기
export const linkEmail = (auth, user) => {
  return new Promise((resovle, reject) => {
    const credential = EmailAuthProvider.credential(user.email, user.password);
    console.log(auth.currentUser.uid); // 회원가입시 MEM_UID 컬럼에 들어갈 값
    resovle(auth.currentUser.uid);
  });
}; // end of linkEmail

export const signupEmail = (auth, user) => {
  console.log(user);
  return new Promise((resolve, reject) => {
    createUserWithEmailAndPassword(auth.user.email, user.password)
      .then((userCredential) => {
        sendEmail(userCredential.user).then(() => {
          resolve(userCredential.user.uid);
        });
      })
      .catch((e) => reject(e));
  });
}; // end of signupEmail

export const sendEmail = (user) => {
  return new Promise((resolve, reject) => {
    sendEmailVerification(user)
      .then(() => {
        resolve("해당 이메일에서 인증메시지를 확인후 다시 로그인 해주세요.")
      })
      .catch((e) => reject(e + "인증 메일 오류 입니다."));
  });
}; // end of sendEmail