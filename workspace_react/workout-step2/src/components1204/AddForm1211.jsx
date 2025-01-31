import React from 'react'

const AddForm1211 = (props) => {
  const formRef = React.createRef()
  const inputRef = React.createRef()
  const onSubmit = (event) => {
    // 브라우저 기본 기능을 막아준다.
    event.preventDefault()
    
    const name = inputRef.current.value
    console.log("사용자가 입력한 운동이름 : " + name)
    name && props.handleAdd(name)

    // 입력한 운동이름이 남아있다. - 초기화 하기
    formRef.current.reset()
  }

  return (
    <>
      <form ref={formRef} className="add-for" onSubmit={onSubmit} >
        <input ref={inputRef} type="text" className="add-input" />
        <button className="add-button">Add</button>
      </form>
    </>
  )
}

export default AddForm1211