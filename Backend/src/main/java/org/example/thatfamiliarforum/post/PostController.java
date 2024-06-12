package org.example.thatfamiliarforum.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "ThatFamiliarForum/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> GetPosts() {return postService.GetPosts();}

    @GetMapping(path = "{postId}")
    public Optional<Post> GetPost(@PathVariable("postId") Long postId) {
        return postService.GetPost(postId);}

    @PostMapping
    public void AddNewPost(@RequestBody Post post) {postService.AddNewPost(post);
        if(post.getThread()==-1L) {
            postService.UpdatePost(post.getId(),null,null, post.getId());
        }
    }

    @PutMapping(path = "{postId}")
    public void UpdatePost(@PathVariable("postId") Long postId,
                           @RequestParam(required = false) String contents,
                           @RequestParam(required = false) String imagePath,
                           @RequestParam(required = false) Long thread
                           ) {
        postService.UpdatePost(postId,contents, imagePath, thread);

    }

    @DeleteMapping(path = "{postId}")
    public void DeletePost(@PathVariable("postId") Long postId) {
        postService.DeletePost(postId);
    }

}


