import { Fragment, useState } from "react";
import WorkoutList1204 from "./components1204/WorkoutList1204";
import "./app1204.css";
import Navbar1211 from "./components1204/Navbar1211";

const WorkoutApp = () => {
  const [items, setItems] = useState([

  ])
  // console.log(items)
  const handleIncrement = (item) => {
    console.log(`${item.name}, count : ${item.count}`)
    // 파라미터로 넘어온 item의 이름이 있는 로우의 index값
    const index = items.indexOf(item)
    console.log(`index ${index}`)
    items[index].count += 1
    setItems([...items])
  }

  const handleDecrement = (item) => {
    const index = items.indexOf(item)
    const count = items[index].count - 1
    items[index].count = count < 0 ? 0 : count
    setItems([...items])
    // if (items[index].count > 0) {
    //   items[index].count -= 1
    //   setItems([...items])
    // }
  };

  const handleDelete = (item) => {
    // 필터링한 결과를 변수에 담았다가 state훅에 반영한다.
    const workouts = items.filter(row => row.id !== item.id)
    setItems([...workouts])
    // const index = items.indexOf(item)
    // if (index > -1) {
    //   items.splice(index, 1)
    //   setItems([...items])
    // }
  }

  const handleAdd = (name) => {
    const workouts = [...items, { id: Date.now(), name, count: 0 }]
    setItems([...workouts])
  }

  return (
    <Fragment>
      <Navbar1211 totalCount={items.filter(item => item.count > 0).length} />
      <WorkoutList1204
        handleIncrement={handleIncrement}
        handleDecrement={handleDecrement}
        handleDelete={handleDelete}
        items={items}
        handleAdd={handleAdd}
      />
    </Fragment>
  );
}
export default WorkoutApp;

/* 
jsx는 html태그와 javascript는 코드를 섞어 쓸수 있다.
*/