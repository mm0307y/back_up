import axios from "axios";

// 댓글 쓰기 구현
export const reCommentInsertDB = (comment) => {
  console.log(comment)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "post",
        url: process.env.REACT_APP_SPRING_IP + "api/board/commentInsert",
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
        url: process.env.REACT_APP_SPRING_IP + "api/board/commentUpdate",
        data: cmt
      })
      resolve(res)
    } catch (error) {
      reject(error)
    }
  });
} // end of reCommentUpdateDB

// http://localhost:8000/api/board/boardList
export const boardListDB = (board) => {
  // console.log(board) // [Object Object]
  console.log(JSON.stringify(board)) // JSON.stringify(), JSON.parse()
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "get",
        url: process.env.REACT_APP_SPRING_IP + "api/board/boardList",
        params: board,
      })
      // 스프링에서 응답이 성공적으로 나오면 - 200OK
      resolve(res)
    } catch (error) {
      reject(error)
    } // end of try, catch
  });
}; // end of boardListDB

// 게시글 상세보기 구현
export const boardDetailDB = (b_no) => {
  console.log(b_no)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "get",
        url: process.env.REACT_APP_SPRING_IP + "api/board/boardDetail.do?b_no=" + b_no,
      });
      resolve(res)
    } catch (error) {
      reject(error)
    }
  })
} // end of boardDetailDB

// http://localhost:8000/api/board/boardInsert
export const boardInsertDB = (board) => {
  console.log(board)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "post",
        url: process.env.REACT_APP_SPRING_IP + "api/board/boardInsert",
        data: board,
      })
      // 스프링에서 응답이 성공적으로 나오면 - 200OK
      resolve(res)
    } catch (error) {
      reject(error)
    } // end of try, catch
  });
}; // end of boardInsertDB

// http://localhost:8000/api/board/boardUpdate
export const boardUpdateDB = (board) => {
  console.log(board)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "put",
        url: process.env.REACT_APP_SPRING_IP + "api/board/boardUpdate",
        data: board,
      })
      // 스프링에서 응답이 성공적으로 나오면 - 200OK
      resolve(res)
    } catch (error) {
      reject(error)
    } // end of try, catch
  });
}; // end of boardUpdateDB

// http://localhost:8000/api/board/boardDelete?b_no=
export const boardDeleteDB = (b_no) => {
  console.log(b_no)
  return new Promise((resolve, reject) => {
    try {
      const res = axios({
        method: "delete",
        url: process.env.REACT_APP_SPRING_IP + "api/board/boardDelete?b_no=" + b_no,
      })
      // 스프링에서 응답이 성공적으로 나오면 - 200OK
      resolve(res)
    } catch (error) {
      reject(error)
    } // end of try, catch
  });
}; // end of boardDeleteDB

export const uploadImageDB = (file) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: 'post',
        url: process.env.REACT_APP_SPRING_IP+'api/board/imageUpload',
        headers: {
          'Content-Type': 'multipart/form-data',
        },
        data: file
      })
      resolve(response)
    } catch (error) {
      reject(error)
    }
  })
}