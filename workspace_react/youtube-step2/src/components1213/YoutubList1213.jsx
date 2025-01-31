import React from 'react'
import YoutubeItem1213 from './YoutubeItem1213'
import './youtube-list1213.css'
const YoutubList1213 = ({ videos }) => {
  console.log(typeof videos)

  return (
    <>
      <ul className='youtubes'>
        {
          videos.map((video, index) => (
            <YoutubeItem1213 key={index} video={video} />
          ))
        }
      </ul>
    </>
  )
}

export default YoutubList1213