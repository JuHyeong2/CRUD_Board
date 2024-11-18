package board.board_back.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

    public static Connection con;
    public static Statement stmt;

    public static void dbs() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","CRUDBOARD","CRUDBOARD");
            stmt= con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from USER_TB");

            System.out.println("성공");
        } catch (Exception e) {
            System.out.println("실패");
            e.printStackTrace();
        }
    }

    public static ResultSet rs(String sql) throws SQLException {
        return stmt.executeQuery(sql);
    }
}
