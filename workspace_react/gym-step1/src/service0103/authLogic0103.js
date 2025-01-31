export const logout = (auth) => {
  console.log("logout 호출 성공");
  return new Promise((resolve, reject) => {
    auth.signOut().catch((e) => reject(alert(e + " : 로그아웃 오류 입니다.")));
    localStorage.removeItem("email");
    resolve();
  });
}; //// end of logout
