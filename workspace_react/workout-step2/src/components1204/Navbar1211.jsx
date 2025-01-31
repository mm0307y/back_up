import React from 'react'

const Navbar1211 = (props) => {
  const totalCount = props.totalCount
  return (
    <div className='navbar'>
      <i className='navbar-logo fas fa-leaf'></i>
      <span>Worout Tracker</span>
      <span className='navber-count'>{totalCount}</span>
    </div>
  )
}

export default Navbar1211