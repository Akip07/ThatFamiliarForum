import React from 'react'
import { useParams, useLoaderData, useNavigate } from 'react-router-dom'
import PostBox from '../components/PostBox';

const PostPage = ({}) => {
    const {id} = useParams();
    const post = useLoaderData();
  return (
    <PostBox post={post} isRoot = {true}/>
  )
}

const postLoader = async ({params}) => {
    const res = await fetch(`/api/posts/${params.id}`);
    const data = await res.json();
    return data;
}

export {PostPage as default, postLoader}