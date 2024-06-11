package org.example.thatfamiliarforum.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ThatFamiliarForum/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> GetPosts() {return postService.GetPosts();}


    @PostMapping
    public void AddNewPost(@RequestBody Post post) {postService.AddNewPost(post);}

    @PutMapping(path = "{postId}")
    public void UpdatePost(@PathVariable("postId") Long postId,
                           @RequestParam(required = false) String contents,
                           @RequestParam(required = false) String imagePath
                           ) {
        postService.UpdatePost(postId,contents, imagePath);

    }

    @DeleteMapping(path = "{postId}")
    public void DeletePost(@PathVariable("postId") Long postId) {
        postService.DeletePost(postId);
    }

}

