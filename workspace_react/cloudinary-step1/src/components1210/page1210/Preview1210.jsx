import React from 'react'
import styled from 'styled-components'
import Card1210 from './Card1210'

const PreviewDiv = styled.div`
  flex-basis: 50%;
  overflow-y: auto /* 스크롤링 되게 하기 */;
`

const TitleH1 = styled.h1`
  width: 100%;
  text-align: center;
  margin-bottom: 1em;
  color: #594545;
`

const CardsUl = styled.ul`
  width: 100%;
  height: 100%;
  padding: 0.5em 2em;
  color: #815b5b;
  display: flex;
  flex-direction: column;
  align-items: center;
  list-style: none;
`

const Preview1210 = ({ cards }) => {
  return (
    <PreviewDiv>
      <TitleH1>Card Preview</TitleH1>
      <CardsUl>
        {Object.keys(cards).map(key => (
          <Card1210 key={key} card={cards[key]} />
        ))}

      </CardsUl>
    </PreviewDiv>
  )
}

export default Preview1210