import React from 'react'
import styled from 'styled-components'

const CardLi = styled.li`
  display: flex; /* 문자열이 이미지 옆으로 간다. */
  align-items: center;
  width: 100%;
  background-color: lightpink;
  border-radius: 3em;
  padding: 0.2em 0;
  margin-bottom: 0.5em;
  color: white;
`

const AvatarImg = styled.img`
  border-radius: 50%;
  width: 10em;
  height: 10em;
  padding: 1em; /* 이미지 안쪽으로 패딩 주기 */
  margin-right: 1em; /* 이미지와 글자 사이에 마진 주기 */
  margin-left: 0.5em;  /* 이미지와 앞쪽에 마진 주기 */
  
`

function Card1210({ card }) {
  // props로 넘어온 값 구조분해 할당 문법을 처리한다. - ECMAScript6
  const { fileName, fileURL } = card
  const DEFAULT_IMAGE = '/images/default_logo.png'
  const url = fileURL || DEFAULT_IMAGE
  return (
    <CardLi>
      <AvatarImg src={url} alt='이미지' />
      <div style={{ width: "100%" }}>{fileName}</div>
    </CardLi>
  )
}

export default Card1210