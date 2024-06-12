import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom'
import HomePage from './pages/HomePage'
import MainLayout from './layouts/MainLayout'
import PostPage from './pages/PostPage'
import { postLoader } from './pages/PostPage'
import BoardPage, { boardLoader } from './pages/BoardPage'
import PostsPage from './pages/PostsPage'
import AddPostPage from './pages/AddPostPage'


const App = () => {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout />}>
        <Route index element={<HomePage />} />
        <Route path='/posts' element={<PostsPage/>}/>
        <Route path='/posts/:id' element={<PostPage/>} loader={postLoader} />
        <Route path='/:initial' element={<BoardPage/>} loader={boardLoader} />
        <Route path='/add-post' element={<AddPostPage/>}/>
      </Route>
    )
  )
  return (
    <RouterProvider router={router} />
  )
}

export default App
