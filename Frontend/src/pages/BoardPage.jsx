import React from 'react'
import { useParams, useLoaderData, useNavigate } from 'react-router-dom'
import PostBox from '../components/PostBox';
import PostList from '../components/PostList';

const BoardPage = ({}) => {
    const board = useLoaderData();
  return (
    <>
    <div className='text-center text-red-800 text-4xl font-semibold'>{`/${board.initial} - ${board.name}`}</div>
    <PostList apiUrl={`/api/boards/${board.initial}`} />
    </>
  )
}

const boardLoader = async ({params}) => {
    const res = await fetch(`/api/boards?initial=${params.initial}`);
    const data = await res.json();
    return data;
}

export {BoardPage as default, boardLoader}