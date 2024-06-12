import React from 'react';
import PostList from '../components/PostList';

const PostsPage = () => {
  

  return (
    <PostList apiUrl='/api/posts'/>
  )
}

export default PostsPage