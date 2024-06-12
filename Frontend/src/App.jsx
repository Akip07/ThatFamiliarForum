import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom'
import HomePage from './pages/HomePage'
import MainLayout from './layouts/MainLayout'
import PostPage from './pages/PostPage'
import { postLoader } from './pages/PostPage'
import BoardPage, { boardLoader } from './pages/BoardPage'
import PostsPage from './pages/PostsPage'
import AddPostPage from './pages/AddPostPage'
import AddReplyPage from './pages/AddReplyPage'
import {threadLoader} from './pages/AddReplyPage'

const App = () => {
  const addPost = async (newJob) => {
    const res = await fetch('/api/posts', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(newJob),
    });
    return;
  };
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout />}>
        <Route index element={<HomePage />} />
        <Route path='/posts' element={<PostsPage/>}/>
        <Route path='/posts/:id' element={<PostPage/>} loader={postLoader} />
        <Route path='/:initial' element={<BoardPage/>} loader={boardLoader} />
        <Route path='/add-post/' element={<AddPostPage addPostSubmit={addPost} thread={-1} />}/>
        <Route path='/add-reply/:id' element={<AddReplyPage addPostSubmit={addPost} />} loader={threadLoader}/>
      </Route>
    )
  )
  return (
    <RouterProvider router={router} />
  )
}

export default App
