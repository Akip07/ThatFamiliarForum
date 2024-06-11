package org.example.thatfamiliarforum.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository <Board, Long>{
    boolean existsById(String id);
    void deleteById(String id);

}
