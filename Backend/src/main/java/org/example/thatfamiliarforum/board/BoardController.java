package org.example.thatfamiliarforum.board;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ThatFamiliarForum/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {this.boardService = boardService;}

    @GetMapping
    public List<Board> GetBoards() {return boardService.GetBoards();}

    @PostMapping
    public void AddNewBoard(@RequestBody Board board) {boardService.AddNewBoard(board);}

    @DeleteMapping(path = "{boardId}")
    public void DeleteBoard(@PathVariable("boardId") String boardId) {
        boardService.DeleteBoard(boardId);
    }
}
