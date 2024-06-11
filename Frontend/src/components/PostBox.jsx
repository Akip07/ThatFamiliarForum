import React from 'react'
import {Link} from 'react-router-dom'
import { useState } from 'react'
import {FaMapMarker} from 'react-icons/fa'

const PostBox = ({post, isRoot = false}) => {
    const [showFullDescription, setShowFullDescription] = useState(false);

    let description = post.contents;
    let contentIsLong=false;
    if(description.length>86 && !isRoot) {
        contentIsLong = true;
    }

    if(!showFullDescription && contentIsLong) {
        description = description.substring(0,90)+'...';
    }

  return (
    <>
    <div style={{alignSelf: 'flex-start', width: 'fit-content', maxWidth: '50em'}} className="bg-white rounded-xl shadow-md relative  p-4 flex">
                      <div className="p-4">
                        <img style={{ alignSelf: 'bottom',width: 200, height: 200, float: 'left', margin: '0 20px 10px 0'}} src={post.imagePath} />
                        <div className="mb-6 flex">
                          <div className="text-gray-600 my-2 ">{post.title}</div>
                        </div>
                        <div className="mb-5, ">
                        {description}
                        </div>
                        {contentIsLong? (<button onClick={() => setShowFullDescription((prevState) => !prevState )} className="text-indigo-500 mb-5 hover:text-indigo-600">
                            {showFullDescription ? 'Less' : 'More'}
                        </button>):(<div></div>)}
                        <div className="flex flex-col lg:flex-row justify-between mb-4">
                          {isRoot ? <div/>: <Link
                            to={`/posts/${post.id}`}
                            className="h-[36px] min-w-5 bg-indigo-500 hover:bg-indigo-600 text-white px-4 py-2 rounded-lg text-center text-sm "
                          >
                           Read More
                          </Link>}
                          
                        </div>
                      </div>
                    </div>
                    
                    </>
  )
}

export default PostBox