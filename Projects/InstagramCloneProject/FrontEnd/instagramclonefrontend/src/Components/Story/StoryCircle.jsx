import React from 'react'
import { useNavigate } from 'react-router-dom'

const StoryCircle = () => {

  const navigate = useNavigate()

  const handleNavigate=()=>{
    navigate("/story")
  }

  return (
    <div onClick={handleNavigate} className='cursor-pointer flex flex-col item-center'>
        <img className='w-16 h-16 rounded-full' src="https://cdn.pixabay.com/photo/2023/05/02/15/52/support-7965543_1280.jpg" alt=""/>
        <p>user_name</p>
    </div>
  )
}

export default StoryCircle