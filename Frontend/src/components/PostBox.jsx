import { NavLink, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const PostBox = ({ post }) => {
  let isRoot = false;
  const navigate = useNavigate();

  const onDeleteClick = async (postId) => {
    const confirm = window.confirm('Are you sure you want to delete this post?');
    if (!confirm) return;

    await deletePost(postId);

    toast.success("Post deleted successfully");

    // Navigate to the current page to reload
    navigate(0);
  }

  if (post.id === post.thread) {
    isRoot = true;
  }

  return (
    <>
      <div className='bg-red-100 text-red-950 w-fit max-w-3xl h-fit pr-2 rounded-sm'>
        <div>
          <img 
            style={{ alignSelf: 'bottom', width: 200, height: 200, float: 'left', margin: '1px 20px 10px 0px' }} 
            src={post.imagePath} 
          />
          {post.contents}
        </div>
        <div>
          {isRoot ? 
            <NavLink to={`/posts/${post.id}`} className="bg-red-300 mr-3">
              Read More
            </NavLink>
            :
            <div></div>
          }
          <NavLink to={`/add-reply/${post.thread}`} className="bg-red-300 mr-3">
            Reply
          </NavLink>
          <button onClick={() => onDeleteClick(post.id)} className="bg-red-300">
            Delete
          </button>
        </div>
      </div>
    </>
  );
}

export default PostBox;

const deletePost = async (id) => {
  const res = await fetch(`/api/posts/${id}`, {
    method: 'DELETE',
  });
  return res.ok;
}
