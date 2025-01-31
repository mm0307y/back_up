import { data } from 'jquery'
import React, { useState } from 'react'
import DaumPostcode from 'react-daum-postcode'

const ZipcodeSearch0103 = () => {
  const [zonecode, setZonecode] = useState('')
  const [address, setAddress] = useState('')
  const [isOpen, setIsOpen] = useState(false)

  const handleClick = () => {
    setIsOpen((prevOpenState) => !prevOpenState)
  }

  // 카카오가 제공하는 onComplete이벤트는 원하는 주소를 선택했을 때 발동한다.
  const handleComplete = (data) => {
    console.log("handleComplete")
    console.log(data)
    const { address, zonecode } = data
    setZonecode(zonecode)
    setAddress(address)
    setIsOpen(false) // 주소선택 후 창 닫기
  }

  return (
    <>
      <div>
        <label >우편번호 : </label>
        <span>{zonecode}</span>
      </div>
      <div>
        <label >주소 : </label>
        <span>{address}</span>
      </div>
      <button type='button' onClick={handleClick}>
        주소 찾기
      </button>
      {isOpen && (
        <div>
          <DaumPostcode onComplete={handleComplete} />
        </div>
      )}
    </>
  );
}

export default ZipcodeSearch0103