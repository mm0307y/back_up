export const toastStatus = {
    status: false, // false이면 메시지가 출력이 안된다. - true 일때 메시지 출력이 된다.
    msg: '', // 메시지가 들어와야 하는 부분, 외부에 페이지마다 출력된다. 메시지가 다르다. - 정할 수 없다. - ''
    session_email: '',
}

// FLUX 아키텍쳐에 의하면 화면에서 새로운 요청이 있을 때
// dispatch를 통해서 상태변화를 요청하는 함수를 호출하면
// state선언된 초기값들이 변한다.