import { Route, Routes, useLocation, useNavigate } from "react-router";
import "bootstrap/dist/css/bootstrap.min.css";
import HomePage1216 from "./components1216/pages1216/HomePage1216";
import LoginPage1216 from "./components1216/auth1216/LoginPage1216";
import NoticeDetail1216 from "./components1216/notice1216/NoticeDetail1216";
import NoticeList1216 from "./components1216/notice1216/NoticeList1216";
import NoticeTestList1218 from "./components1216/noticeTest1218/NoticeTestList1218";
import NoticeTestDetail1218 from "./components1216/noticeTest1218/NoticeTestDetail1218";
import Hello1216 from "./components1216/tomcat1216/Hello1216";
import NoticeDBList1219 from "./components1216/noticeDB1219/NoticeDBList1219";
import NoticeDBDetail1220 from "./components1216/noticeDB1219/NoticeDBDetail1220";
import QuillWrite1224 from "./components1216/board1224/QuillWrite1224";
import BoardDBDetail1226 from "./components1216/board1224/BoardDBDetail1226";
import BoardDBList1226 from "./components1216/board1224/BoardDBList1226";
import BoardDBWrite1226 from "./components1216/board1224/BoardDBWrite1226";
import BoardDBUpdate1226 from "./components1216/board1224/BoardDBUpdate1226";
import PaginationTest1230 from "./components1216/board1224/PaginationTest1230";
import PayReadyPage0117 from "./components1216/pay0117/PayReadyPage0117";
import KakaoPay0117 from "./components1216/pay0117/KakaoPay0117";
import { toastStatus } from "./redux0120/toastStatus0120/state0120";
import Toast0120 from "./components1216/Toast0120";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { onAuthChange } from "./service1216/authLogic0120";
import { memberListDB } from "./service1216/dbLogic1218";
import SignupPage0120 from "./components1216/pages1216/auth0120/SignupPage0120";
import { setToastMsg } from "./redux0120/toastStatus0120/action0120";
import EmailVerifiedPage0122 from "./components1216/pages1216/auth0120/EmailVerifiedPage0122";
import FindEmailPage0123 from "./components1216/pages1216/auth0120/FindEmailPage0123";
import ResetPwdPage0123 from "./components1216/pages1216/auth0120/ResetPwdPage0123";
import ReBoardDBList0124 from "./components1216/reboard0124/ReBoardDBList0124";
import MyPage0127 from "./components1216/pages1216/auth0120/MyPage0127";
import ReBoardDBDetail0131 from "./components1216/reboard0124/ReBoardDBDetail0131";
import ReBoardDBUpdate0131 from "./components1216/reboard0124/ReBoardDBUpdate0131";
import ReBoardDBWrite0203 from "./components1216/reboard0124/ReBoardDBWrite0203";

// App이 실행될 때 로그인 상태인지를 체크하기
const App = () => {
  // useEffect에 의존성 배열에 들어갈 변수들...
  const pathname = useLocation().pathname // 현재 경로를 의미한다.
  const navigate = useNavigate()
  const toastStatus = useSelector((state) => state.toastStatus)
  const userAuth = useSelector((state) => state.userAuth)
  const dispatch = useDispatch()
  const auth = localStorage.getItem("auth") // 접근권한을 이야기한다.
  // status -> 0이면 일반회원, 1이면 코치

  // -> http://localhost:3000/index.html 호출된다.
  useEffect(() => {
    const asyncCloud = async () => {
      // 현재 로그인 상태가 유지되고 있을 때
      const user = await onAuthChange(userAuth.auth)
      console.log(user)
      console.log('auth : ' + localStorage.getItem('auth'))
      // user가 무언가를 쥐고 있다면 즉 true 일때 - 로그인이 되어 있는 상태를 말한다.
      // 로그인 되어 있는 상태에서 회원가입이 된 사람인지를 체크하기
      // 너 구글로 로그인 한 경우라면 반드시 회원가입을 별도로 해야 돼
      // 회원권 양도, 수업신청

      if (user != null) {
        // user.emailVerified 값을 비교할 수 있다.
        if (!user.emailVerified) { // false이면 true가 된다.
          // 구글 로그인 상태가 아니다. -> 소셜 로그인이 있고 사용자가 회원가입을해서 진행되는 로그인 - 가지가 존해한다.
        }
        else { // user.emailVerified가 true이다.
          // 당신은 이미 회원가입이 되어 있습니다. - 기준값
          // uid or email을  가지고 오라클 서버로 가서 select *from member250120
          // where mem_uid = 'google1';
          // localStorage 있는 값 중에서  선택할 것
          console.log(`${user.uid}, ${user.email} has signed in.`);

          if (user.uid !== null || user.email !== null) {
            const res = await memberListDB({ MEM_UID: user.uid, type: 'auth' })
            console.log(res) // 참이면 있다. 거짓이면 없다.
            // 만일 조회결과가 존재한다면 이미 회원가입이 된 상태이다.
            // 추가적인 상태값을 관리한다. (쿠키나 세션, localStorage)
            console.log(typeof res.data)
            console.log(res.data)
            console.log(res.data.length)
            if (typeof res.data == 'object') { // 참이면 조회결과가 있다. 회원가입이 되어 있다.
              if (Array.isArray(res.data)) {
                console.log("조회 결과가 배열 일 때")
                dispatch(setToastMsg('해당 구글 계정은 회원가입 대상입니다. 회원가입을 부탁드립니다.'))
                navigate('/auth/signup')
              } // object중에서도 배열일 때
              else {
                console.log("object이지만 배열이 아닐 때") // {키:값, 키:값, 키:값}
                localStorage.setItem('uid', res.data.MEM_UID)
                localStorage.setItem('email', res.data.MEM_EMAIL)
                localStorage.setItem('nickname', res.data.MEM_NICKNAME)
                localStorage.setItem('status', res.data.MEM_STATUS) // 다시 정리
                localStorage.setItem('auth', res.data.MEM_AUTH)
                localStorage.setItem('no', res.data.MEM_NO) // pk값은 관리
              } // 배열이 아닐 때
            } // end of object타입일 때
          } //end of auth가 false일 때
        } 
      }
    }
    asyncCloud()
  }, [userAuth.auth, pathname, auth, dispatch]) //// end of useEffect
  // Route의 path와 Header의 Link to는 일치해야 한다.
  // 사용자 정의 컴포넌트는 함수 이다.
  return (
    <>
      {/* Toast를 활용한 메시지가 출력될 물리적인 공간을 한정짓기 */}
      <div style={{ height: "100vh" }}>
        {toastStatus.status && <Toast0120 />}
        <Routes>
          <Route path="/" exact={true} element={<HomePage1216 />} />
          {/* pay */}
          <Route path="/pay/ready" exact={true} element={<PayReadyPage0117 />} />
          <Route path="/pay/action" exact={true} element={<KakaoPay0117 />} />
          <Route path="/hello" exact={true} element={<Hello1216 />} />
          {/* 인증/인가 */}
          <Route path="/login" exact={true} element={<LoginPage1216 />} />
          <Route path="/mypage" exact={true} element={<MyPage0127 />} />
          <Route path="/auth/signup" exact={true} element={<SignupPage0120 />} />
          <Route path="/auth/emailVerified" exact={true} element={<EmailVerifiedPage0122 />} />
          <Route path="/auth/findEmail" exact={true} element={<FindEmailPage0123 />} />
          <Route path="/auth/resetPwd" exact={true} element={<ResetPwdPage0123 />} />
          {/* 스프링 게시판 및 POJO */}
          <Route path="/reboard" exact={true} element={<ReBoardDBList0124 />} />
          <Route path="/reboard/:b_no" exact={true} element={<ReBoardDBDetail0131 />} />
          <Route path="/reboard/update/:b_no" exact={true} element={<ReBoardDBUpdate0131 />} />
          <Route path="/reboard/write" exact={true} element={<ReBoardDBWrite0203 />} />
          {/* NodeJS 게시판 */}
          <Route path="/board" exact={true} element={<BoardDBList1226 />} />
          <Route path="/board/write" exact={true} element={<BoardDBWrite1226 />} />
          <Route path="/board/:b_no" exact={true} element={<BoardDBDetail1226 />} />
          <Route path="/board/update/:b_no" exact={true} element={<BoardDBUpdate1226 />} />
          <Route path="/quill/write" exact={true} element={<QuillWrite1224 />} />
          <Route path="/noticeDB" exact={true} element={<NoticeDBList1219 />} />
          <Route path="/noticeDB/:n_no" exact={true} element={<NoticeDBDetail1220 />} />
          <Route path="/notice" exact={true} element={<NoticeList1216 />} />
          <Route path="/notice/:n_no" exact={true} element={<NoticeDetail1216 />} />
          <Route path="/noticeT" exact={true} element={<NoticeTestList1218 />} />
          <Route path="/noticeTD" exact={true} element={<NoticeTestDetail1218 />} />
          <Route path="/page" exact={true} element={<PaginationTest1230 />} />
        </Routes>
      </div>
    </>
  );
}

export default App;

/* 
- http://localhost:3000 뒤에 index.html 가 생략 되어 있다. http://localhost:3000/index.html 
- <div id="root"></div>
- root에 대한 정보는 index.js에서 참조 한다.
document.querySelector("#root")
- index.js에서 App을 import한다.
- 이 때 App.jsx의 erturn에 있는 태그가 화면에 출력된다.
- 그런데 이번에는 App.jsx에 메뉴를 클릭했을 때 보여줄 페이지에
대한 링크를 걸어 준다.
*/