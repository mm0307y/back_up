import React from 'react'

const YoutubeItem1213 = ({ video }) => {

  return (
    <>
      <li className='videoli'>
        <div className='videodiv'>
          <img className='thumb' src={video.snippet.thumbnails.medium.url} alt='video thumbanail' />
          <div className='videoinfo'>
            <p className='ptitle'>{video.snippet.title}</p>
            <p className='cptitle'>{video.snippet.channelTitle}</p>
          </div>
        </div>
      </li>

    </>
  )
}

export default YoutubeItem1213