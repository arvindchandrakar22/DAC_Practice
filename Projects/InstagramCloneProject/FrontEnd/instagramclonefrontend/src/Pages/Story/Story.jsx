import React from 'react'
import StoryViewerr from '../../Components/StoryComponents/StoryViewerr'

const Story = () => {

    const story = [
        {
            image:"https://images.pexels.com/photos/17111340/pexels-photo-17111340/free-photo-of-city-water-street-building.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/16447305/pexels-photo-16447305/free-photo-of-city-art-street-building.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/17117466/pexels-photo-17117466.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/16979580/pexels-photo-16979580/free-photo-of-wood-summer-wall-garden.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/17088087/pexels-photo-17088087/free-photo-of-aicante.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load"
        }
    ]

  return (
    <div>
        <StoryViewerr stories={story}/>
    </div>
  )
}

export default Story