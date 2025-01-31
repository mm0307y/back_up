import React from 'react'

const WorkoutItem1204 = (props) => {
  // console.log(props)
  const item = props.item

  const handleIncrement = () => {
    console.log("WorkoutItem handleIncrement")
    props.handleIncrement(item)
  }

  const handleDecrement = () => {
    props.handleDecrement(item)
  }

  const handeleDelete = () => {
    props.handleDelete(item)
  }

  return (
    <>
      <li className="workout">
        <span className="workout-name">{item.name}</span>
        <span className="workout-count">{item.count}</span>
        <button className="workout-button workout-incrase" onClick={handleIncrement}>
          <i className='fas fa-plus-square'></i>
        </button>
        <button className="workout-button workout-decrease" onClick={handleDecrement} >
          <i className="fas fa-minus-square"></i>
        </button>
        <button className="workout-button workout-delete" onClick={handeleDelete} >
          <i className="fas fa-trash"></i>
        </button>
      </li>
    </>
  )
}

export default WorkoutItem1204
/* 
<WorkoutList1204 handleIncrement={handleIncrement} items={items} />
        <WorkoutList1204 handleDecrement={handleDecrement} items={items} />
        <WorkoutList1204 handleDelete={handleDelete} items={items} />
*/