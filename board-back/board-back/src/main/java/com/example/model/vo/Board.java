package com.example.model.vo;

import java.util.Date;

public class Board {
    private int no, view;
    private String title, detail, userId;
    private Date time;

    public Board() {
    }

    public Board(int no, int view, String title, String detail, String userId, Date time) {
        this.no = no;
        this.view = view;
        this.title = title;
        this.detail = detail;
        this.userId = userId;
        this.time = time;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
