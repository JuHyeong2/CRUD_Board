package com.example.java_version.controller;

import com.example.java_version.jdbc.db;
import com.example.java_version.model.vo.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    private User user = new User();
    private ResultSet rs;
    private String sql;

    //회원가입
    public User userPost(String name, String id, String pwd, String phone, String email, Date date, String address) {
        try {
            sql = "insert into user_tb values(?,?,?,?,?,default,?)"; //입력 sql

            db.stmt = db.con.prepareStatement(sql);
            db.stmt.setString(1, name);
            db.stmt.setString(2, id);
            db.stmt.setString(3, pwd);
            db.stmt.setString(4, phone);
            db.stmt.setString(5, email);
            db.stmt.setString(7, address);
            db.stmt.executeUpdate(); //sql실행

            //가입한 id를 검색해서 user생성자에 넣기
            rs = db.stmt.executeQuery("select * from USER_TB where user_id = '" + id + "'");
            if(rs.next()){
                user.setName(rs.getString(1));
                user.setId(rs.getString(2));
                user.setPhone(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setDate(rs.getDate(6));
                user.setAddress(rs.getString(7));
            }else{
                return null;
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (db.stmt != null) {
                    db.stmt.close();
                }

                if (db.con != null) {
                    db.con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //회원수정
    public boolean userPut(String name, String id, String pwd, String phone, String email, String address){
        try {
            //수정할 회원이 있는지 검색
            rs = db.stmt.executeQuery("select * from USER_TB where user_id = '" + id + "'");
            if(!rs.next()){ //회원이 검색이 안되면 false
                return false;
            }

            //id, date(회원가입한 날짜라 냅둠)를 제회한 데이터들 수정
            sql = "update user_tb set user_name = ?, user_pwd = ?, user_phone = ?, user_email = ?, address = ? where user_id = ?";

            db.stmt = db.con.prepareStatement(sql);
            db.stmt.setString(1, name);
            db.stmt.setString(2, id);
            db.stmt.setString(3, pwd);
            db.stmt.setString(4, phone);
            db.stmt.setString(5, email);
            db.stmt.setString(6, address);
            db.stmt.setString(7, id);
            db.stmt.executeUpdate(); //sql실행
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (db.stmt != null) {
                    db.stmt.close();
                }

                if (db.con != null) {
                    db.con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //회원삭제
    public boolean userDelete(String id){
        try {
            sql = "delete from user_tb where user_id = '" + id + "'";
            db.stmt = db.con.prepareStatement(sql);
            int result = db.stmt.executeUpdate(); //삭제 성공하면 1
            if(result > 0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (db.stmt != null) {
                    db.stmt.close();
                }

                if (db.con != null) {
                    db.con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
