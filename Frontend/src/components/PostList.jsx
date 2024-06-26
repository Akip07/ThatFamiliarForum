import React, { useState, useEffect } from 'react';
import PostBox from './PostBox';

const PostList = ({ apiUrl }) => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const res = await fetch(apiUrl);
        const data = await res.json();
        setPosts(data);
      } catch (error) {
        console.log('Error fetching data', error);
      }
    };
    fetchPosts();
  }, [apiUrl]);

  return (
    <div className="grid grid-rows-1 md:grid-rows-3 gap-6">
      {posts.map((post) => (
        <PostBox key={post.id} post={post} />
      ))}
    </div>
  );
};

export default PostList;
