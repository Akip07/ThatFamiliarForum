import React from 'react'
import {NavLink} from 'react-router-dom'

const Navbar = () => {
  const linkClass = ({isActive}) => 
    isActive 
  ? 'bg-black text-white hover:bg-gray-900 hover:text-white rounded-md px-3 py-2' 
  : 'text-white hover:bg-gray-900 hover:text-white rounded-md px-3 py-2' ;
  return (
    <>
    
    <nav className="bg-orange-400 border-b border-orange-100 mb-4">
      <div className="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
        <div className="flex h-10 items-center justify-between">
          <div
            className="flex flex-1 items-center justify-center md:items-stretch md:justify-start"
          >

            <NavLink className="flex flex-shrink-0 items-center mr-4" to="/">

              <span className="hidden md:block text-red-900 text-2xl font-bold ml-2"
                >ThatFamiliarForum</span
              >
            </NavLink>
            <div className="md:ml-auto">
              <div className="flex space-x-2">
                <NavLink
                  to="/"
                  className={linkClass}
                  >Home</NavLink
                >
                <NavLink
                  to="/posts"
                  className={linkClass}
                  >Posts</NavLink
                >
                <NavLink
                  to="/add-post"
                  className={linkClass}
                  >Add Post</NavLink>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>
    </>
  )
}

export default Navbar