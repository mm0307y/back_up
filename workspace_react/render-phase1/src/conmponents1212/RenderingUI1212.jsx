import React from 'react'

const RenderingUI1212 = ({ handleClick }) => {
  return (
    <>
      {Array.from({ length: 100 }, (_, i) => {
        if (i == 99) {
          console.log("rendering last item : ", i)
        } //// end of if

        return (
          <div key={i} onClick={handleClick}>버튼 클릭</div>
        )

      })}
    </>
  ) /// end of return
}

export default React.memo(RenderingUI1212)