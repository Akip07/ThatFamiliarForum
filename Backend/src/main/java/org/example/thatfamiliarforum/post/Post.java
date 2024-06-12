package org.example.thatfamiliarforum.post;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String board;
    private Long authorId;
    private Long thread;
    private LocalDateTime postDate;

    public Post() {
        this.postDate = LocalDateTime.now();
    }

    public Post(Long id, String contents, String imagePath, String board, Long thread, Long authorId) {
        this.id = id;
        this.contents = contents;
        this.imagePath = imagePath;
        this.board = board;
        this.authorId = authorId;
        if(thread==-1L || thread==-1L)
            this.thread = 5L;
        else
            this.thread = thread;
        this.postDate = LocalDateTime.now();
    }

    public Post(String contents, String imagePath, String board, Long thread, Long authorId) {
        this.contents = contents;
        this.imagePath = imagePath;
        this.board = board;
        this.authorId = authorId;
        if(thread==-1L || thread==-1L) {
            this.thread = 5L;
        }
        else {
            this.thread = thread;
        }
        this.postDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public Long getThread() {
        return thread;
    }

    public void setThread(Long thread) {
        this.thread = thread;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", board='" + board + '\'' +
                ", authorId=" + authorId +
                ", thread=" + thread +
                ", postDate=" + postDate +
                '}';
    }
}
