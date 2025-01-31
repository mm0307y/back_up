import React from 'react'

const WorkoutItem1203 = (props) => {
  // console.log(props)
  const item = props.item
  const handleIncrement = () => {
    console.log("WorkoutItem handleIncrement")
    props.handleIncrement(item)
  }
  return (
    <>
      <li onClick={handleIncrement}>{item.name}{item.count}</li>
    </>
  )
}

export default WorkoutItem1203