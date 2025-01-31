// 기본 내보내기
// 주의 : 하나의 모듈에는 하나의 default ewport만 가능하다.
// default를 import할 때 좌,우 중괄호는 필요 없다.
export default 123
// export default 'abc' // 에러 발생

export const arr = [1, 2, 3]
export const hamsu = () => console.log("hamsu 호출")
export function add(a,b){
  return a + b
}