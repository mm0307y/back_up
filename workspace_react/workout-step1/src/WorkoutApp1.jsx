import { Fragment, useState } from "react";

const WorkoutApp1 = () => {
  const [items, setitems] = useState([
    { id: 1, name: "밴치프레스", count: 0 },
    { id: 2, name: "랫풀다운", count: 0 },
    { id: 3, name: "스쿼트", count: 0 }
  ])
  console.log(items)
  return (
    <Fragment>
      <ul>
        {items.map(item => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </Fragment>
  );
}

export default WorkoutApp1;

/* 
jsx는 html태그와 javascript는 코드를 섞어 쓸수 있다.
*/