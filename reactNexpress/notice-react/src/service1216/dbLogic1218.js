import axios from "axios";

// 댓글 쓰기 구현
export const reCommentInsertDB = (comment) => {
  console.log(comment)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "post",
        url: process.env.REACT_APP_SPRING_IP + "pojo0106/board/commentInsert.do",
        data: comment
      })
      resolve(res)
    } catch (error) {
      reject(error)
    }
  });
} // end of reCommentInsertDB

// 댓글 수정 구현
export const reCommentUpdateDB = (cmt) => {
  // 사용자가 입력한 값을 출력해 보기
  console.log(cmt)

  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "put",
        url: process.env.REACT_APP_SPRING_IP + "pojo0106/board/commentUpdate.do",
        data: cmt
      })
      resolve(res)
    } catch (error) {
      reject(error)
    }
  });
} // end of reCommentUpdateDB

// 게시글 쓰기 구현
export const reBoardInsertDB = (board) => {
  // 사용자가 입력한 값 출력하기
  console.log(board)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_SPRING_IP + "pojo0106/board/boardInsert.do",
        data: board
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  });
} // end of reBoardInsertDB

// QuillEditor에 이미지 처리하기
export const reUploadImageDB = (file) => {
  console.log(file.name)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_SPRING_IP + "pojo0106/board/imageUpload.do",
        headers: {
          "Content-Type": "multipart/form-data"
        },
        data: file
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  });
}

// 게시글 상세보기 구현
export const reBoardDetailDB = (b_no) => {
  console.log(b_no)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "get",
        url: process.env.REACT_APP_SPRING_IP + "pojo0106/board/boardDetail.do?b_no=" + b_no,
      });
      resolve(res)
    } catch (error) {
      reject(error) 
    }
  })
} // end of reBoardDetailDB

// 게시글 삭제하기 구현
export const reBoardDeleteDB = (b_no) => {
  console.log(b_no)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "delete",
        uri: process.env.REACT_APP_SPRING_IP + "pojo0106/board/boardDelete.do?b_no=" + b_no
      });
      resolve(res)
    } catch (error) {
      reject(error)
    }
  })
} // end of reBoardDeleteDB

// 게시글 목록 가져오기 구현
export const reBoardListDB = (params) => {
  //파라미터 값을 출력해 보기 - SELECT * FROM notice WHERE n_content like '%'||?||'%'
  console.log(params)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_SPRING_IP + "pojo0106/board/boardList.do",
        params: params,
      });
      resolve(response) //성공했을 때
    } catch (error) {
      reject(error); //실패했을 때
    } //end of try..catch
  });
}; //// end of boardListDB

// 회원 가입 구현 - 소셜로그인 한 경우, 일반회원, 코치회원
// 비밀번호가 포함되어 있어서 post방식으로 한다.

export const memberInsertDB = (datas) =>{
  // 파라미터로 넘어온 사용자가 입력한 값 확인하기
  console.log(datas) // postman 테스트할 때 body > raw > {} Object

  // 함수의 리턴타입으로 함수를 쓸 수 있다. - 고차함수 
  // 리액트에서 회원가입 버튼을 클릭하면 이함수가 호출된다.
  // 백엔드  스프링부트(8000번)의 URL 이름을 호출한다.
  // 3000번에서 8000번으로 요청이 일어난다. - CORS
  // 2개의 다른 서버를 활용하므로 지연이 발생한다. - 비동기로 처리한다.
  // inser하는 동안 시간이 걸린다. - waiting(자바스레드) -
  // 클라이언트에서 주기적으로 서버에 확인한다 - 준비됐어?(1)
  // 요청을 했어?(전송했어-1-send{get, post, put, delete}) - 처리중이야-2 
  // 처리해서 업로드 중이야(3)
  // 4가지 상태를 파악하고 추적해서 4번일 때 함수를 호출해줘(함수 호출을 약속할게 - callback - 자동)
  // 내가 호출하는 것이 아니다. 콜백함수는 개발자 호출하는게 아니다. - > 시스템이 호출한다.
  // 0->1->2->3->4 - intercept(관여한다.)
  return new Promise((resolve, reject) => { // resolve와 reject콜백함수 이다.
    try {
      const res = axios({
        method: 'post',
        url: process.env.REACT_APP_SPRING_IP+'member/memberInsert',
        data: datas,
      })
      resolve(res)
    } catch (error) {
      // 에러 발생
      reject("에러발생" + error)
    }
  })
} // end of memberInsertDB - 회원가입(커밋과 롤백 : 환경설정 - 일괄처리)

// 소셜 로그인한 경우 우리 회원테이블에 등록되어 있는지 유무를 체크
export const memberListDB = (params) => {
  console.log(params); // {MEM_UID:user.uid, type:'auth'}
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: 'get',
        url: process.env.REACT_APP_SPRING_IP+'member/memberList',
        params: params
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  })
} // end of memberListDB

// QuillEditor에서 이미지 선택시 express 서버에 업로드 처리 요청하기
export const uploadImageDB = (file) => {
  // 사용자가 입력한 값 출력하기
  console.log(file.name)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_EXPRESS_IP + "users/board/imageUpload",
        headers: {
          "Content-Type": "multipart/form-data"
        },
        data: file
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  });
}; //// end of noticeInsertDB

// 게시글 목록 가져오기 구현
export const boardListDB = (params) => {
  //파라미터 값을 출력해 보기 - SELECT * FROM notice WHERE n_content like '%'||?||'%'
  console.log(params);
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_EXPRESS_IP + "users/board/list",
        params: params,
      });
      resolve(response) //성공했을 때
    } catch (error) {
      reject(error) //실패했을 때
    } //end of try..catch
  });
}; //// end of boardListDB

// 게시글 쓰기구현
// const [notice, setNotice] = useState({})
// 훅(HOOK) - 클래스 중심의 코드 전개에서 this에 대한 헷갈림, 구분을 잘 못한다.
export const boardInsertDB = (board) => {
  // 사용자가 입력한 값 출력하기
  console.log(board)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_EXPRESS_IP + "users/board/insert",
        headers: {
          "Content-Type": "application/json",
        },
        data: board,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
}; //// end of boardInsertDB

export const boardDetailDB = (b_no) => {
  // 파라미터 값을 출력해 보기 - SELECT * FROM react_board WHERE b_no=?
  console.log(b_no); // 목록에서 제목을 클릭했을 때 그 row의 n_no를 가져온다.
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_EXPRESS_IP + "users/board/detail/" + b_no,
      });
      resolve(response) //성공했을 때
    } catch (error) {
      reject(error) //실패했을 때
    } //end of try..catch
  });
}; //// end of boardDetailDB

//  게시글 수정하기
export const boardUpdateDB = (board) => {
  // 사용자가 입력한 값 출력하기
  console.log(board)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "put",
        url: process.env.REACT_APP_EXPRESS_IP + "users/board/update/" + board.b_no,
        headers: {
          "Content-Type": "application/json"
        },
        data: board // get방식 : params
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  });
}; //// end of boadrUpdatDB

// 게시글 삭제하기
// 공지글 삭제
export const boardDeleteDB = (b_no) => {
  // 파라미터 값을 출력해 보기 - delete from react_board where b_no=?
  console.log(b_no); // 목록에서 제목을 클릭했을때 그 row의 b_no를 가져온다.
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "delete",
        url: process.env.REACT_APP_EXPRESS_IP + "users/board/delete/" + b_no,
      });
      resolve(response) // 성공했을 때
    } catch (error) {
      reject(error) // 실패했을 때
    } //// end of try..catch
  });
}; //// end of noticeDeletDB

export const noticeListDB = (params) => {
  //파라미터 값을 출력해 보기 - SELECT * FROM notice WHERE n_content like '%'||?||'%'
  console.log(params);
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_EXPRESS_IP + "users/notice/list",
        params: params,
      });
      resolve(response) //성공했을 때
    } catch (error) {
      reject(error) //실패했을 때
    } //end of try..catch
  });
}; //// end of noticeListDB

export const noticeDetailDB = (n_no) => {
  // 파라미터 값을 출력해 보기 - SELECT * FROM notice WHERE n_no=?
  console.log(n_no); // 목록에서 제목을 클릭했을때 그 row의 n_no를 가져온다.
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_EXPRESS_IP + "users/notice/detail/" + n_no,
      });
      resolve(response) //성공했을 때
    } catch (error) {
      reject(error) //실패했을 때
    } //end of try..catch
  });
}; //// end of noticeDetailDB

// const [notice, setNotice] = useState({})
// 훅(HOOK) - 클래스 중심의 코드 전개에서 this에 대한 헷갈림, 구분을 잘 못한다.
export const noticeInsertDB = (notice) => {
  // 사용자가 입력한 값 출력하기
  console.log(notice)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_EXPRESS_IP + "users/notice/insert",
        headers: {
          "Content-Type": "application/json"
        },
        data: notice
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  });
}; //// end of noticeInsertDB

// REST API -> get(조회), post(입력), put(수정), delete(삭제)
// useState({n_no:1, n_title:제목, n_writer:작성자, n_content:내용})
export const noticeUpdateDB = (notice) => {
  // 사용자가 입력한 값 출력하기
  console.log(notice)
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "put",
        url:
          process.env.REACT_APP_EXPRESS_IP +
          "users/notice/update/" +
          notice.n_no,
        headers: {
          "Content-Type": "application/json",
        },
        data: notice // get방식 : params
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  });
}; //// end of noticeUpdatDB

// 공지글 삭제
export const noticeDeleteDB = (n_no) => {
  // 파라미터 값을 출력해 보기 - delete from notice where n_no=?
  console.log(n_no) // 목록에서 제목을 클릭했을때 그 row의 n_no를 가져온다.
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "delete",
        url: process.env.REACT_APP_EXPRESS_IP + "users/notice/delete/" + n_no,
      });
      resolve(response) // 성공했을 때
    } catch (error) {
      reject(error) // 실패했을 때
    } //// end of try..catch
  });
}; //// end of noticeDeletDB
