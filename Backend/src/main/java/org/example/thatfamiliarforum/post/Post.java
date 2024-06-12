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
    private String title;
    private String contents;
    private String imagePath;
    private String board;
    private Long authorId;
    private Long thread;
    private LocalDateTime postDate;

    public Post() {
    }

    public Post(Long id, String title, String contents, String imagePath, String board, Long thread, Long authorId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.imagePath = imagePath;
        this.board = board;
        this.authorId = authorId;
        this.thread = thread;
        this.postDate = LocalDateTime.now();
    }

    public Post(String title, String contents, String imagePath, String board, Long thread, Long authorId) {
        this.title = title;
        this.contents = contents;
        this.imagePath = imagePath;
        this.board = board;
        this.authorId = authorId;
        this.thread = thread;
        this.postDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", board='" + board + '\'' +
                ", authorId=" + authorId +
                ", thread=" + thread +
                ", postDate=" + postDate +
                '}';
    }
}
