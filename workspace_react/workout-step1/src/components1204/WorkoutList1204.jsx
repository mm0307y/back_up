import React from 'react'
import WorkoutItem1203 from './WorkoutItem1204'

// <WorkoutList item={items} />
const WorkoutList1204 = (props) => {
  // 선언부
  // console.log(props)
  const items = props.items

  // 배열 안에는 {}있다. -> Object 객체
  console.log(items.length) // 배열의 원소 수 3

  // items -> [{}, {}, {}]
  // item -> {id:1, name:"밴치프레스", count:0}
  // item -> {id:2, name:"랫풀다운", count:5}
  // item -> {id:3, name:"스쿼트", count:7}
  const handleIncrement = (item) =>{
    console.log("증가 : " + item.name)
    props.handleIncrement(item)
  }

  return (
    <>
      <ul>
        {/* jsx에서는 태그안에 주소번지를 넘길 수 있다. */}
        {items.map(item => (
          <WorkoutItem1203 handleIncrement={handleIncrement} key={item.id} item={item} />
        ))}
      </ul>
    </>
  )
}

export default WorkoutList1204