package com.example.model.vo;

import java.util.Date;

public class Board {
    private int boardNo, view;
    private String boardtitle, boardDetail, userId;
    private Date boardTime;

    public Board() {
    }

    public Board(int no, int view, String title, String detail, String userId, Date time) {
        this.boardNo = no;
        this.view = view;
        this.boardtitle = title;
        this.boardDetail = detail;
        this.userId = userId;
        this.boardTime = time;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int no) {
        this.boardNo = no;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getBoardTitle() {
        return boardtitle;
    }

    public void setBoardTitle(String title) {
        this.boardtitle = title;
    }

    public String getBoardDetail() {
        return boardDetail;
    }

    public void setBoardDetail(String detail) {
        this.boardDetail = detail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBoardTime() {
        return boardTime;
    }

    public void setBoardTime(Date time) {
        this.boardTime = time;
    }
}
