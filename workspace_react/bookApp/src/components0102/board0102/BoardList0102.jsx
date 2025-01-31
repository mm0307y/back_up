import React from 'react'
import Header0102 from '../include0102/Header0102'
import Footer0102 from '../include0102/Footer0102'
import BoardItem0102 from './BoardItem0102'

const BoardList0102 = () => {
  return (
    <>
      <Header0102 />
      <div>
        <BoardItem0102 />
        <BoardItem0102 />
        <BoardItem0102 />
        <BoardItem0102 />
      </div>
      <Footer0102 />
    </>
  )
}

export default BoardList0102