package com.example.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.vo.Board;

@Repository
public class BoardDAO {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl"; 
    private static final String DB_USER = "CRUD"; 
    private static final String DB_PASSWORD = "CRUD";
    
    //게시글 목록 조회
    public List<Board> getAllBoards() {
        List<Board> boards = new ArrayList<>(); // 결과를 담을 리스트
        String sql = "SELECT board_no, board_title, board_detail, board_time FROM Board"; 

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Board board = new Board();
                board.setBoardNo(rs.getInt("board_no"));
                board.setTitle(rs.getString("board_title"));
                board.setBoardDetail(rs.getString("board_detail"));
                board.setBoardTime(rs.getTimestamp("board_time").toLocalDateTime());
                boards.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return boards; 
    }
    
    //게시글 내용 뿌려주는 메소드
    public Board getBoardById(int boardNo) {
        String sql = "SELECT board_no, board_title, board_detail, board_time FROM Board WHERE board_no = ?"; 
        Board board = null;
        	// 예외처리에서 배웠던 방법으로 한번에 예외처리 반환했음
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, boardNo); // 프라이머리키인 보드넘버를 매개변수로 설정
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    board = new Board();
                    board.setBoardNo(rs.getInt("board_no"));
                    board.setBoardTitle(rs.getString("board_title"));
                    board.setBoardDetail(rs.getString("board_detail"));
                    board.setBoardTime(rs.getTimestamp("board_time").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return board; 
    }
    
    //게시글 생성 사용자로부터 값들 받아와서 insert해주는 부분임
    public void createBoard(Board board) {
        String sql = "INSERT INTO Board (board_no, board_title, board_detail, board_time) VALUES (board_seq.NEXTVAL, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, board.getBoardTitle()); // 첫번째인덱스 제목들어가게끔
            pstmt.setString(2, board.getBoardDetail()); 
            pstmt.setTimestamp(3, Timestamp.valueOf(board.getBoardTime())); 
            pstmt.executeUpdate(); 
            //update만 하면되고 따로 주형이햄이 작성하는 프론트가있기때문에 ResultSet 객체 쓸필요가 없음 여기서 끝내도됨
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //게시글 수정. 사용자로부터 값들 받아와서 update해주는 내용
    public void updateBoard(int boardNo, Board board) {
        String sql = "UPDATE Board SET board_title = ?, board_detail = ? WHERE board_no = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, board.getBoardTitle());
            pstmt.setString(2, board.getBoardDetail());
            pstmt.setInt(3, boardNo);
            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBoard(int boardNo) {
        String sql = "DELETE FROM Board WHERE board_no = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, boardNo); //게시글 pk인 게시글 번호로 세팅하고 그 번호를 삭제 
            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    
    






}
