package com.example.board_back.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.DAO.BoardDAO;
import com.example.model.vo.Board;

@Service
public class BoardService {

    @Autowired
    private BoardDAO boardDAO; // DAO를 주입받음

    public List<Board> getAllBoards() {
        return boardDAO.getAllBoards(); // 모든 게시글 조회
    }

    public Board getBoardById(int boardNo) {
        return boardDAO.getBoardById(boardNo); // 특정 게시글 조회
    }

    public void createBoard(Board board) {
        boardDAO.createBoard(board); // 게시글 생성
    }

    public void updateBoard(int boardNo, Board board) {
        boardDAO.updateBoard(boardNo, board); // 게시글 수정
    }

    public void deleteBoard(int boardNo) {
        boardDAO.deleteBoard(boardNo); // 게시글 삭제
    }
}
