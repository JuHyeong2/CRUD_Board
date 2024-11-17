package board.board_fullstack;

import board.board_fullstack.board_back.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.SQLException;

@SpringBootApplication
public class BoardFullstackApplication {

	public static void main(String[] args) {
        try {
            jdbc.db.dbs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SpringApplication.run(BoardFullstackApplication.class, args);
	}
}
