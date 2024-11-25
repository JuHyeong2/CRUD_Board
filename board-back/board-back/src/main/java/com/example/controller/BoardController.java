package com.example.controller;
import com.example.model.vo.Board;
public class BoardController {
    private Board board = new Board();

    public Board boardPost(int no, int view, String title, String detail, String userId, Date time){
        board.setNo(no);
        board.setView(view);
        board.setTitle(title);
        board.setDetail(detail);
        board.setUserId(userId);
        board.setTime(time);
        return board;
    }
}
