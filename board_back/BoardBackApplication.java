package board.board_back;

import board.board_back.jdbc.db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class BoardBackApplication {

	public static void main(String[] args) {
		try {
			db.dbs();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		SpringApplication.run(BoardBackApplication.class, args);
	}
}
