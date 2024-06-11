package org.example.thatfamiliarforum.post;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> GetPosts(){ return postRepository.findAll(); }

    @GetMapping
    public List<Post> GetPostsFromBoard(String initial){return postRepository.findByBoard(initial);}

    public void AddNewPost(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void UpdatePost(Long postId, String contents, String imagePath) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalStateException(
                "post with id " + postId + " does not exist")
        );

        if(contents!=null && contents.length()>0 && !Objects.equals(post.getContents(),contents)) {
            post.setContents(contents);
        }

        if(imagePath!=null && imagePath.length()>0 && !Objects.equals(post.getImagePath(),imagePath)) {
            post.setImagePath(imagePath);
        }
    }

    public void DeletePost(Long postId) {
        boolean exists = postRepository.existsById(postId);
        if(!exists) {
            throw new IllegalStateException("post with id " + postId + " does not exist");
        }
        postRepository.deleteById(postId);
    }
}
