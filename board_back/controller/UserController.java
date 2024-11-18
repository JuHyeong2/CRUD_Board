package board.board_back.controller;

import board.board_back.jdbc.db;
import board.board_back.model.vo.User;

import javax.sql.*;
import java.sql.*;
import java.sql.Date;


public class UserController {
    private final DataSource dataSource;
    private User user = new User();
    private ResultSet rs;

    public UserController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User userPost(String name, String id, String pwd, String phone, String email, Date date, String address) {
        try {

            rs = db.stmt.executeQuery("insert into user values('" + name + "', '" + id + "', '" + pwd +
                    "', '" + phone + "', '" + email + "', " + date + ", '" + address + "')");

            if(rs.next()){
                user.setName(rs.getString(1));
                user.setId(rs.getString(2));
                user.setPhone(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setDate(rs.getDate(6));
                user.setAddress(rs.getString(7));
            }else{
                throw new SQLException("회원가입 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean userPut(String name, String id, String phone, String pwd, String email, Date date,String address){
        return false;
    }
}
