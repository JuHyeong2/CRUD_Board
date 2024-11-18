package com.example.java_version.controller;

import com.example.java_version.model.vo.Comment;

import java.util.Date;

public class CommentController {
    private Comment cm = new Comment();

    public Comment commentPost(int board, String detail, String userId, Date time) {    //댓글 작성 메소드


        return cm;
    }

    public Comment commentGet(int no) {


        return null;
    }

    public boolean commentPut(String detail) {

        return false;
    }

    public boolean commentDelete() {

        return false;
    }
}