import React from 'react'
import {Link, NavLink} from 'react-router-dom'
import { useState } from 'react'
import {FaMapMarker} from 'react-icons/fa'

const PostBox = ({post}) => {
    const [showFullDescription, setShowFullDescription] = useState(false);
    let isRoot = false

    if(post.id == post.thread) {
        isRoot = true;
    }



  return (
    <>
    <div className='bg-red-100 text-red-950 w-fit max-w-3xl h-fit pr-2 rounded-sm'>
    <div>
  <img 
    style={{ alignSelf: 'bottom', width: 200, height: 200, float: 'left', margin: '1px 20px 10px 0px' }} 
    src={post.imagePath} 
  />
 {post.contents}
</div>
  <div>
    {isRoot? <NavLink to={`/posts/${post.id}`} className="bg-red-300 mr-3">
      Read More
    </NavLink>
    :
    <div></div>
    }
    <NavLink to={`/add-post`} className="bg-red-300 ">
      Reply
    </NavLink>
    
  </div>
</div>

    </>
  )
}

export default PostBox