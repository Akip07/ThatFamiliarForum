package org.example.thatfamiliarforum.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByBoard(String initial);
    @Query("SELECT p FROM Post p WHERE p.id = p.thread")
    List<Post> findByIdEqualsThread();

    List<Post> findByThreadOrderByPostDateAsc(Long thread);
}
