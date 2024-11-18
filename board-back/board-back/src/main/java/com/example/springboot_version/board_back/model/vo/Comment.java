package com.example.springboot_version.board_back.model.vo;

import java.util.Date;

public class Comment {
    private int no, boardNo;
    private String userId, detail;
    Date time;

    public Comment() {
    }

    public Comment(int no, int boardNo, String userId, String detail, Date time) {
        this.no = no;
        this.boardNo = boardNo;
        this.userId = userId;
        this.detail = detail;
        this.time = time;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
