package org.example.thatfamiliarforum.thread;

import org.example.thatfamiliarforum.post.Post;
import org.example.thatfamiliarforum.post.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "ThatFamiliarForum/threads")
public class ThreadController {
    private final PostService postService;

    public ThreadController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> GetThreads() {return postService.GetRootPosts();}

    @GetMapping(path = "/{thread}")
    public List<Post> GetBoardByInitial(@PathVariable("thread") Long thread) {
        return postService.GetPostsInThread(thread);
    }

}
