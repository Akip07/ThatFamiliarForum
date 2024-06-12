import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const AddPostPage = ({ addPostSubmit, thread}) => {
    const [title, setTitle] = useState('');
    const [contents, setContents] = useState('');
    const [imagePath, setImagePath] = useState('');
    const [board, setBoard] = useState('');
    const [authorId, setAuthorId] = useState('1');

    const navigate = useNavigate();

    const submitForm = (e) => {
        e.preventDefault();
        const newPost = {
            title,
            contents,
            imagePath,
            board,
            authorId,
            thread
        };
        addPostSubmit(newPost);
        toast.success('Post successfully added');
        navigate('/posts');
    };

    return (
        <section className="">
            <div className="container m-auto max-w-2xl py-24">
                <div className="bg-orange-100 px-6 py-8 mb-4 shadow-md rounded-md border m-4 md:m-0">
                    <form onSubmit={submitForm}>
                        <h2 className="text-3xl text-center text-red-800 font-semibold mb-6">Add post</h2>

                        <div className="mb-4">
                            <label className="block text-red-800 font-bold mb-2">Title</label>
                            <input
                                type="text"
                                id="title"
                                name="title"
                                className="border rounded w-full py-2 px-3 mb-2 bg-red-200"
                                required
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                            />
                        </div>

                        <div className="mb-4 ">
                            <label htmlFor="contents" className="block text-red-800 font-bold mb-2">Contents</label>
                            <textarea
                                id="contents"
                                name="contents"
                                className="border rounded w-full py-2 px-3 bg-red-200"
                                rows="4"
                                value={contents}
                                onChange={(e) => setContents(e.target.value)}
                            ></textarea>
                        </div>

                        <div className="mb-4">
                            <label className="block text-red-800 font-bold mb-2">Image</label>
                            <input
                                type="text"
                                id="imagePath"
                                name="imagePath"
                                className="border rounded w-full py-2 px-3 mb-2 bg-red-200"
                                placeholder="Paste your image path here"
                                required
                                value={imagePath}
                                onChange={(e) => setImagePath(e.target.value)}
                            />
                        </div>

                        <div className="mb-4">
                            <label htmlFor="board" className="block text-red-800 font-bold mb-2">Board</label>
                            <input
                                type="text"
                                id="board"
                                name="board"
                                className="border rounded w-full py-2 px-3 bg-red-200"
                                placeholder="select board"
                                value={board}
                                onChange={(e) => setBoard(e.target.value)}
                            />
                        </div>

                        <div>
                            <button
                                className="bg-orange-900 hover:bg-orange-400 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
                                type="submit"
                            >
                                Add Post
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    );
};

export default AddPostPage
