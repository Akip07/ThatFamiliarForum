import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from 'react-router-dom'
import HomePage from './pages/HomePage'
import MainLayout from './layouts/MainLayout'
import PostPage from './pages/PostPage'
import { postLoader } from './pages/PostPage'


const App = () => {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout />}>
        <Route index element={<HomePage />} />
        <Route path='/posts/:id' element={<PostPage/>} loader={postLoader} />

      </Route>
    )
  )
  return (
    <RouterProvider router={router} />
  )
}

export default App
