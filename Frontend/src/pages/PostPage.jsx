import React from 'react'
import { useParams, useLoaderData, useNavigate } from 'react-router-dom'
import PostBox from '../components/PostBox';
import PostList from '../components/PostList';

const PostPage = ({}) => {
    const post = useLoaderData();
  return (
    //<PostBox post={post} />
    <PostList apiUrl={`/api/threads/${post.thread}`}/>
  )
}

const postLoader = async ({params}) => {
    const res = await fetch(`/api/posts/${params.id}`);
    const data = await res.json();
    return data;
}

export {PostPage as default, postLoader}