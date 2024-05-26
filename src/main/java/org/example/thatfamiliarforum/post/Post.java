package org.example.thatfamiliarforum.post;

import jakarta.persistence.*;
import org.example.thatfamiliarforum.user.User;

@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name="post_sequence",
            sequenceName="post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private String contents;
    private String imagePath;
    private Long authorId;

    public Post() {
    }

    public Post(Long id, String contents, String imagePath, Long authorId) {
        this.id = id;
        this.contents = contents;
        this.imagePath = imagePath;
        this.authorId = authorId;
    }

    public Post(String contents, String imagePath, Long authorId) {
        this.contents = contents;
        this.imagePath = imagePath;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
