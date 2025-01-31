import React from 'react'

// 리액트에서 props(프롭스)를 지원하는데 컴포넌트와 컴포넌트 사이에서
// 주소번지 원본을 넘겨받을 수 있다.
const NewsList1204 = (props) => {
  // 구조분해 할당
  const { newsList } = props
  console.log(newsList)

  return (
    <div>
      <ul>
        {
          Object.keys(newsList).map((key =>
            <li key={key}>[id:{newsList[key].id}]</li>
          ))
        }
      </ul>
    </div>
  )
}

export default NewsList1204
