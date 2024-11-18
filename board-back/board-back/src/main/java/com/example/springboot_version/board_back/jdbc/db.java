package com.example.springboot_version.board_back.jdbc;

import java.sql.*;

public class db {

    public static Connection con;
    public static PreparedStatement stmt;

    public static void dbs() throws SQLException {
        try { //오라클 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","CRUDBOARD","CRUDBOARD");
            stmt= con.prepareStatement("select * from USER_TB");

            //연결 테스트
            ResultSet rs =  stmt.executeQuery();
            if(rs.next()) {
                System.out.println(rs.getString(1));
            }

            //오류 안나면 성공
            System.out.println("성공");
        } catch (Exception e) {
            //오류 나면 실패
            System.out.println("실패");
            e.printStackTrace();
        }
    }

    public static ResultSet rs(String sql) throws SQLException {
        return stmt.executeQuery(sql);
    }
}
