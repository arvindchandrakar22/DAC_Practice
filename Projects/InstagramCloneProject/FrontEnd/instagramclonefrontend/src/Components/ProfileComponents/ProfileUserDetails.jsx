import React from 'react'
import {TbCircleDashed} from "react-icons/tb"

export const ProfileUserDetails = () => {
  return (
    <div className='py-10 w-full'>
        <div className='flex items-center'>
            <div className='w-[17%]'>
                <img 
                  className='w-32 h-32 rounded-full' 
                  src='https://cdn.pixabay.com/photo/2023/05/22/11/22/superb-fairywren-8010454_1280.jpg' 
                  alt=''
                />
            </div>
            <div className='space-y-5'>
                <div className='flex space-x-10 items-center'>
                    <p>User Name</p>
                    <button>Edit Profile</button>
                    <TbCircleDashed></TbCircleDashed>
                </div>
                <div className='flex space-x-10'>
                    <div>
                        <span className='font-semibold mr-2'>10</span>
                        <span>Post</span>
                    </div>
                    <div>
                        <span className='font-semibold mr-2'>5</span>
                        <span>Follower</span>
                    </div>
                    <div>
                        <span className='font-semibold mr-2'>7</span>
                        <span>Following</span>
                    </div>
                </div>
                <div>
                    <p className='font-semibold'>Full Name</p>
                    <p className='font-thin text-sm'>ज़िंदगी एक फ़न है लम्हों को अपने अंदाज़ से गँवाने का !  ~जॉन एलिया</p>
                    <p className='font-thin text-sm'>Engineering Grad. 👨🏻‍🎓 | CDAC Certified 👨🏻‍💻 | Traveller 🛄 | Bhilai 🏠</p>
                </div>
            </div>
        </div>
    </div>
  )
}
