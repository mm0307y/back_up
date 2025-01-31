import React from 'react'
import { Link } from 'react-router'

const ReBoardDBItem0131 = (props) => {
  const { B_NO, B_TITLE, MEM_NAME } = props.board
  console.log(props.page)
  return (
    <>
      <tr>
        <td>{B_NO}</td>
        <td>
          {/* <Route path="/notice/:n_no" exact={true} element={<NoticeDetail1216 />} /> */}
          <Link to={`/reboard/${B_NO}?page=${props.page}`} className="btn btn-primary" >{B_TITLE}</Link>
        </td>
        <td>{MEM_NAME}</td>
      </tr >
    </>
  )
}

export default ReBoardDBItem0131