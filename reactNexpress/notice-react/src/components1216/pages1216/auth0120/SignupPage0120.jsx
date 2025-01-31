import React from 'react'
import Signup0120 from '../../auth1216/Signup0120'
import SignupType0120 from '../../auth1216/SignupType0120'

const SignupPage0120 = () => {
  const type = window.location.search.split('=')[1]
  const signuppage = () =>{
    if(type){
      return <Signup0120 />
    }
    else{
      return <SignupType0120 />
    }
  } //// end of signuppage
  
  return (
    signuppage()
  )
}

export default SignupPage0120