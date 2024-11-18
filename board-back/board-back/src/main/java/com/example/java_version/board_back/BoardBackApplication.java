package com.example.java_version.board_back;

import com.example.java_version.jdbc.db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class BoardBackApplication {

	public static void main(String[] args) {
		try {
			db.dbs();
			SpringApplication.run(BoardBackApplication.class, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
