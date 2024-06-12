import React from 'react'
import {useState, useEffect} from 'react';
import { NavLink } from 'react-router-dom';

const BoardList = () => {
    const apiUrl = '/api/boards';
    const [boards, setBoards] = useState([]);
  
    useEffect(() => {
      const fetchBoards = async () => {
        try {
          const res = await fetch(apiUrl);
          const data = await res.json();
          setBoards(data);
          }
          catch (error){
            console.log('Error fetching data', error);
          }
          finally{
            setLoading(false);
          }
      }
      fetchBoards();
    }, []);
  return (
    <>
    <div className='text-center text-red-800 text-5xl font-bold'>Choose board</div>
    <div className="flex flex-row justify-center items-center">
  {boards.map((board) => (
    <NavLink key={board.id} className="mr-2 text-2xl hover:text-red-500" to={`${board.initial}`}>{`/${board.initial}`}</NavLink>
  ))}
</div>

    </>
  )
}

export default BoardList