// 클래스 선언
class AuthLogic {
  // 생성자 함수 - 전역 변수 초기화
  // 사용자 정의 함수 구현
}
export default AuthLogic // 외부 js에서 사용할 때 반드시 추가할 것

// 로그아웃 버튼 클릭시 호출하기
export const logout = auth => {
  return new Promise((resolve, reject) =>{
    // 로그아웃 처리하기
    localStorage.removeItem("mem_id")
    resolve()
  })
} //// end of logout

//카카오 로그인
export const logoinKako = auth => {
  return new Promise((resolve, reject) =>{
    // 로그아웃 처리하기
    localStorage.setItem("mem_id","kakaoid")
    resolve()
  })
} //// end of logoinKako

export const logoinGoogle = auth => {
  return new Promise((resolve, reject) =>{
    // 로그아웃 처리하기
    localStorage.setItem("mem_id","googleid")
    resolve()
  })
} //// end of logoinGoogle