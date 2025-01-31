import React from 'react'
import { Link } from 'react-router'

// const NoticeItem1216 = ({n_no, n_title, n_writer}) => {
const NoticeItem1216 = (props) => {
  // console.log(props) // [object Object]
  console.log(props.notice) // 로그로 props를 찍으면 [object Object] 나온다.
  // 공지 제목을 클릭했을 때 상세보기로 이동하기 - 라우트 처리
  // http://localhost:3000/detail/글번호(n_no)
  const { n_no, n_title, n_writer } = props.notice
  // console.log(n_title)
  return (
    <>
      <tr>
        <td>{n_no}</td>
        <td>
          {/* <Route path="/notice/:n_no" exact={true} element={<NoticeDetail1216 />} /> */}
          <Link to={"/notice/" + n_no} className="btn btn-primary" >{n_title}</Link>
        </td>
        <td>{n_writer}</td>
      </tr>
    </>
  )
}

export default NoticeItem1216