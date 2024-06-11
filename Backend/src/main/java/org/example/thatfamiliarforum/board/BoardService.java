package org.example.thatfamiliarforum.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {this.boardRepository = boardRepository; }

    @GetMapping
    public List<Board> GetBoards(){return boardRepository.findAll();}

    public void AddNewBoard(Board board) {boardRepository.save(board);}

    public void DeleteBoard(Long boardId) {
        boolean exists = boardRepository.existsById(boardId);
        if(!exists) {
            throw new IllegalStateException("board with id " + boardId + " does not exist");
        }
        boardRepository.deleteById(boardId);
    }

    public List<Board> GetBoardsByName(String name) {
        return boardRepository.findByName(name);
    }

    public List<Board> GetBoardByInitial(String initial) {
        return boardRepository.findByInitial(initial);
    }
}
