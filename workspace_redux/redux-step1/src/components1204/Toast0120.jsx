import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components'; // react-bootstrap활용
import { setToastFalse } from '../redux0120/toastStatus/action';

// div태그에 css코드를 자바스크립트의 컴포넌트 문법으로 변경한 예시
const ToastDiv = styled.div`
    position: fixed;
    top: 50%;
    left: 50%;
    padding: 11px;
    min-width: 350px;
    transform: translate(-50%, -50%);
    justify-content: center;
    text-align: center;
    font-size: 18px;
    z-index: 99;
    background: rgba(0, 0, 0, 0.7);
    color: #ffffff;
    border-radius: 4px;
    border: 1px solid #000000;
    opacity: 0;
    visibility: hidden;
    transition: opacity 0.5s ease-in-out, visibility 0.5s ease-in-out;
`;

// Toast0120 함수 선언하기 - 리액트에서는 대문자로 시작되는 함수는 태그로 사용한다.
const Toast0120 = () => {
  // useSelector 훅을 통해서 store에 설정된 상태값을 참조하기
  // store설정이 가리키는 toastStatus에는 어떤 상태값이 있나요?
  const toastStatus = useSelector((store) => store.toastStatus);
  const dispatch = useDispatch();

  useEffect(() => {
    if (toastStatus.status) {
      let x = document.getElementById('snackbar');
      x.style.opacity = '0.8';
      x.style.visibility = 'visible';
      setTimeout(() => {
        x.style.opacity = '0';
        x.style.visibility = 'hidden';
        dispatch(setToastFalse());
      }, 3000);
    }
  }, [toastStatus.status, dispatch]);

  // <div id="snackbar"></div> 랑 같다.
  return <ToastDiv id="snackbar">{toastStatus.msg || 'Operation Successful'} </ToastDiv>;
  
}

export default Toast0120