import { Fragment, useCallback, useEffect, useState } from "react";
import RenderingUI1212 from "./conmponents1212/RenderingUI1212";

const BlogApp = () => {
  const [state, setState] = useState(0)
  console.log("1")
  const handleClick = () => {
    console.log("handleClick호출")
  }

  // handleClick함수가 매번 새로 만들어질 필요가 없다.
  // 왜냐면 변화가 없다.
  // 메모리에 handleClick를 띄워준다. - useCallback() 감싼다.
  // 의존성 배열에 값이 변하면 그 때는 새로 생성이 된다.
  const memoizationCallback = useCallback(() => {
    handleClick()
  }, [])

  // useEffect 훅은 의존성 배열이 깡동일 때 딱 한번 호출된다.
  useEffect(() => {
    console.log('Componen re-rendered')
    setTimeout(() => {
      setState(1)
      console.log('updated')
    }, 1000)
  }, []) // Only re-render when state changes
  // 두 번째 파라미터는 의존성 배열이다.

  return (
    <>
      {/* 어떤 값을 props로 넘길 때 메모이제이션 된것을 리턴해주면 불필요한 렌더링을 줄인다. */}
      <RenderingUI1212 onClick={memoizationCallback} />
      {/* 위처럼 메모이제잉션된 함수를 쓰면 함수변경이 안 일어난다. */}
    </>
  );
}

export default BlogApp;

/* 
  상태는 바뀌었는데 이 바뀐 상태가 RenderingUI와 아무 상관이 없다.
  심지어 state를 사용하고 있지도 않다.
  그런데 state가 변경됨에 의해서 이 BlogApp.jsx파일은 다시 실행이 됐고
  그 과정에서 RenderingUI1212 컴포넌트도 다시 실행이 되서 무려 100번 실행이 되었다.
  
  그럼 이 경우에는 왜 문제가 발생했나?
  첫번째는 RenderingUI1212 onClick의 props가 일정하지 않다. - 새로 만들어진 함수다.
  handleClick()은 변경된게 없다.
  훅(Hook)이 사용되지 않고 선언된 어떤 함수나 값은 매번 BlogApp.jsx파일이 다시
  실행될 때 마다 새로 할당이 된다.
  그래서 우리 눈에는 똑같지만 handleClick() 매번 렌더링이 될 때 마다 다른 주소번지를 갖는다.
  그렇게 달라진 함수 이므로 이것을 props로 넘기는 Rendering1212 태그도 변경이 되는 것이다.
  즉, props가 변경이 된 것이다.
  그러면 이 props를 변경되지 않도록 하면 된다. How?
*/