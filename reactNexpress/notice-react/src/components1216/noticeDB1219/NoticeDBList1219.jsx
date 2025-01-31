import React, { useEffect, useState } from 'react'
import { noticeInsertDB, noticeListDB } from '../../service1216/dbLogic1218'
import { Button, Modal } from 'react-bootstrap'
import { Form } from 'react-bootstrap'
import Header1216 from '../include1216/Header1216'
import Footer1216 from '../include1216/Footer1216'
import NoticeDBItem1220 from './NoticeDBItem1220'

const NoticeDBList1219 = () => {
  const [gubun, setGubun] = useState('')
  const [keyword, setKeyword] = useState('')
  const [notice, setNotice] = useState({
    n_no: 0,
    n_title: '',
    n_writer: '',
    n_content: ''
  })
  const [notices, setNotices] = useState([])
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  // 선언부
  // Realtime database이용시에는 필요없는 코드이다.
  const [refresh, setRefresh] = useState(0)

  // db 경유하여 공지글 목록 가져오기
  useEffect(() => {
    console.log('effect refresh : ' + refresh)
    noticeList()
    // DB에서 가져온 값이 있는지 출력해 보기
    // notice - 한 건 or 쓰길할 때, 상세보기 할때
    // notice
    console.log(notices)
  }, []) //// 의존성 배열이 빈통이니깐 최초 한 번만 실행된다.

  // 공지 글 쓰기
  const noticeAdd = async (event) => {
    event.preventDefault()
    // useState훅은 이전 상태값을 기억해 준다. - 일반변수와 다른점이다.
    const res = await noticeInsertDB(notice)
    console.log(res.data) // 1이면 입력 성공
    console.log(res.data.success)
    console.log(res.data.result)
    console.log(JSON.stringify(res.data.result))
    if (res.data.success === true) {
      // 입력 성공
      console.log("입력성공")
      // window.location.reload()
      // 리액트 화면을 재조정하는 경우가 있다. 1)props변경될때, 2)state변경될때
      // 일반변수는 이전 상태를 기억하지 못하지만 리액트의 useState를 사용하면 이전상태를 기억한다.
      // 최초 0으로 초기화 했다가 글등록이 성공하면 이전 상태값 0에 1을 더하여 상태값이 0에서 1로 변하도록 강제하였다.
      // 그래서 화면에 재조정이 일어난다.(다시 그린다.)
      setRefresh((prev) => prev + 1) // const [refresh, setRefresh] = useState(0)
      // useEffect가 다시 한 번 자동 호출되는 조건은 재조정이 일어나도록 강제한다.
      // useEffect는 의존성 배열을 가지고있다. 의존성 배열에 상태값이 바뀌면 useEffect에 실행문이 다시 한번 호출된다.
    }
    else {
      //입력 실패
      alert("글 등록에 실패 하셨습니다.")
    }
    handleClose() // 모달창 닫기
  }

  const noticeList = () => {
    const asyncDB = async () => {
      //select처리
      const res = await noticeListDB(notice)
      console.log(res.data)

      // props나 state가 변하면 화면을 새로 그린다.
      setNotices(res.data)
    } //// end of asyncDB
    asyncDB()
  }

  // 조건 검색 구현하기
  const noticeSearch = () => {
    const gubun = document.querySelector("#gubun").value
    const keyword = document.querySelector("#keyword").value
    console.log(`${gubun}, ${keyword}`) // ""-false -> !false, 제목1

    // 구분을 선택하지 않은 경우 선택하도록 유도한다.
    if (!gubun) {
      alert("구분을 선택하세요.")
      // 구분 (n_title, n_writer, n_content)을 선택하지 않으면
      return
    }

    // 구분(gubun)과 입력값(keyword)에 대한 초기화 처리할 것
    // 구분을 선택하고 입력값을 입력한 뒤에는 그 조건에 따라 필터링이된 결과를 useState에 담는다.
    // mdn filter API - 깊은 복사인가 아니면 얕은복사인가?
    // 입력한 값이 DB에 저장되어 있다. - 목록을 가져오는 것은 db에서 가져온다.
    // 조건을 수렴하는 결과만 필터링한 뒤에 setNotice에 (result)하고 있다.
    // db에서 가져온 것이 아니다.
    const result = Object.values(notices).filter(notice => {
      if (!notice) return false
    }) //// end of 조건검색 결과를 담는다.
    const asyncDB = async () => {
      const notice = {
        gubun: gubun,
        keyword: keyword
      }
      const res = await noticeListDB(notice)
      console.log(res.data)
      setNotices(res.data)
      setGubun('')
      setKeyword('')
    }
    asyncDB()
  }

  const handleChangeForm = (event) => {
    event.preventDefault()
    // 사용자가 폼에 입력한 값을 notice useState 훅에 담기
    setNotice({
      ...notice,
      [event.target.name]: event.target.value
    })
  }

  // 파라미터에 event객체는 이벤트가 감지 되었을 떄 주입 받는다.
  // 만일 주입을 못 받으면 null이 출력된다. 아니다. undefined.
  const handleGubun = (event) => {
    console.log(event.target.value) // n_title, n_writer, n_content - 왜냐면 select 콤보이니까
    setGubun(event.target.value)
    noticeList()
  }

  const handleKeyword = (event) => {
    console.log(event.target.value) // 사용자가 입력한 문자열
    setKeyword(event.target.value)
    noticeList()
  }

  useEffect(() => {
    console.log('effect호출')
    const notice = {
      n_no: 0,
      n_title: '',
      n_writer: '',
      n_content: ''
    }
    const asynDB = async () => {
      const res = await noticeListDB(notice)
      console.log(res.data)
      setNotices(res.data)
      console.log(notices)
    }
    asynDB();
  }, [refresh]) //// end of uesEffect

  return (
    <>
      <Header1216 />
      <div className='container'>
        <div className='page-header' >
          <h2>공지사항DB <small>글목록</small></h2>
          <hr />
        </div>

        <div className="row">
          <div className="col-sm-3">
            <select className="form-select" id="gubun" value={gubun} onChange={handleGubun} >
              <option value="">분류선택</option>
              <option value="n_title">제목</option>
              <option value="n_writer">작성자</option>
              <option value="n_content">내용</option>
            </select>
          </div>

          <div className="col-sm-6">
            <input type="text" className="form-control" placeholder="검색어를 입력하세요" value={keyword} id="keyword" onChange={handleKeyword} />
          </div>
          <div className="col-sm-3">
            <button type="button" className="btn btn-danger" onClick={noticeSearch} >검색</button>
          </div>
        </div>

        <table className="table table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>제목</th>
              <th>작성자</th>
            </tr>
          </thead>
          {/* 데이터셋 연동하기 */}
          <tbody>
            {
              notices && Object.keys(notices).map(key => (
                <NoticeDBItem1220 key={key} notice={notices[key]} />
              ))}
          </tbody>
          {/* 데이터셋 연동하기 */}
        </table>
        <hr />
        <div className='list-footer' >
          <button className="btn btn-outline-primary" onClick={noticeList}>전체조회</button>
          &nbsp;
          <button className="btn btn-outline-info" onClick={handleShow}>글쓰기</button>
        </div>
      </div>
      <Footer1216 />

      {/* ==================[[ 공지등록 모달 시작 ]] ========================= */}
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Header closeButton>
          <Modal.Title>글등록</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form id="f_board">
            <Form.Group className="mb-3" controlId="boardTitle">
              <Form.Label>제목</Form.Label>
              <Form.Control type="text" name="n_title" onChange={handleChangeForm} placeholder="Enter 제목" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="boardWriter">
              <Form.Label>작성자</Form.Label>
              <Form.Control type="text" name="n_writer" onChange={handleChangeForm} placeholder="Enter 작성자" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="boardContent">
              <Form.Label>내용</Form.Label>
              <textarea className="form-control" name='n_content' onChange={handleChangeForm} rows="3"></textarea>
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            닫기
          </Button>
          <Button variant="primary" onClick={noticeAdd}>
            저장
          </Button>
        </Modal.Footer>
      </Modal>
      {/* ==================[[ 공지등록 모달 끝 ]] ========================= */}
    </>
  )
}

export default NoticeDBList1219
