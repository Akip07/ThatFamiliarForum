package org.example.thatfamiliarforum.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository <Board, Long>{
    List<Board> findByName(String name);
    List<Board> findByInitial(String initial);
}
