package com.example.controller;
import java.util.List;

import com.example.board_back.service.BoardService;
import com.example.model.vo.Board;

@RestController  // 이건 @Controller + @RespinseBody 라고 생각하면됨 JSON형식의 객체를 반환해준다는뜻
@RequestMapping("/api/boards") // /api/board 까지는 공통적으로 쓰는 url이므로 (나중에다른걸로바꾸기가능) RequestMapping써주고 나머지 url을 아래서 처리해줌
public class BoardController {

    @Autowired // 의존성 주입하는 어노테이션임
    private BoardService boardService; 
    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();     
        }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable int id) {
        return boardService.getBoardById(id);     
        }

    @PostMapping // http메소드중 하나로 
    public void createBoard(@RequestBody Board board) {
        boardService.createBoard(board);    
        }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable int id, @RequestBody Board board) {
        boardService.updateBoard(id, board);    
        }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);     
        }
}
