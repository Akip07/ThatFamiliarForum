package org.example.thatfamiliarforum.board;
import org.example.thatfamiliarforum.post.Post;
import org.example.thatfamiliarforum.post.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ThatFamiliarForum/boards")
public class BoardController {
    private final BoardService boardService;
    private final PostService postService;

    public BoardController(BoardService boardService, PostService postService) {this.boardService = boardService; this.postService = postService;}

    @GetMapping
    public List<Board> GetBoards(@RequestParam(required = false) String name) {
        if (name != null) {
            return boardService.GetBoardsByName(name);
        }
        return boardService.GetBoards();
    }

    @GetMapping(path = "/{initial}")
    public List<Post> GetBoardByInitial(@PathVariable("initial") String initial) {
        return postService.GetPostsFromBoard(initial);
    }

    @PostMapping
    public void AddNewBoard(@RequestBody Board board) {boardService.AddNewBoard(board);}

    @DeleteMapping(path = "{boardId}")
    public void DeleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.DeleteBoard(boardId);
    }

}
