import React from 'react'
import styled from 'styled-components'

const CardEditorDiv = styled.div`
  flex-basis: 50%;
  border-right: 1px solid #9E7676;
  color: white;
  display: flex; /* 추가 */
  flex-direction: column; /* 수직 배열 */
  align-items: center; /* 가로 중앙 정렬 */
`

const TitleH1 = styled.h1`
  width: 100%;
  text-align: center;
  margin-bottom: 1em;
  color: #594545;
`

const TextDiv = styled.div`
  font-size: 3em; /* 글씨 크기 */
  margin: 0.5em 0; /* 여백 추가 */
  text-align: center; /* 가로 중앙 정렬 */
  justify-content: center; /* 세로 중앙 정렬 */
`

function CardEditor1210() {
  return (
    <CardEditorDiv>
      <TitleH1>Card Editor</TitleH1>
      <TextDiv>나는 모기 시키~~</TextDiv>
      <TextDiv>아무쓸모가 없네~~</TextDiv>
      <TextDiv>진짜~~ 왜 살고 있을까~~</TextDiv>
      <TextDiv>한강 안 얼을까~~</TextDiv>
      <TextDiv>한강물 차갑던데~~</TextDiv>
      <TextDiv>따뜻할 때 가야지~~</TextDiv>
      <TextDiv>아~ 비가 많이 올때 가야돼~!</TextDiv>
    </CardEditorDiv>
  )
}

export default CardEditor1210