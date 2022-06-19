package com.ezen.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.ezen.biz.dto.BoardVO;

/*
 * 	-------  BOARD 테이블과 CRUD 기능을 처리할 클래스.  -------
 */

@Repository("boardDAO")
public class BoardDAOSpring {
	// 객체
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 명령어
	
	/*
	// 트랜잭션 처리 연습
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) VALUES(?, ?, ?, ?)";
	*/
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?, writer=?, content=? WHERE seq=?";
	private final String BOARD_DELETE = "DELETE board WHERE seq=? ";
	private final String BOARD_GET = "SELECT * FROM BOARD where seq=?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY seq DESC";

	// CRUD 기능의 메소드 구현
	// ---- 게시글 전체 목록 조회. ----
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");

		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}

	// ---- 글 상세 조회 – seq 번호에 의한 조회. ----
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");

		Object[] args = { vo.getSeq() };

		// 하단의 조회하는 BoardRowMapper 내에서 조회하여 값을 가져온다
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());

	}

	// ---- 글 등록 ----
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_INSERT, board.getTitle(), board.getWriter(), board.getContent());
		
		/* 트랜잭션 처리 연습
		jdbcTemplate.update(BOARD_INSERT, board.getSeq(), board.getTitle(), board.getWriter(), board.getContent());
		*/
	}

	// ---- 글 수정 ----
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");

		jdbcTemplate.update(BOARD_UPDATE, board.getTitle(), board.getWriter(), board.getContent());
	}

	// ---- 글 삭제 ----
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");

		jdbcTemplate.update(BOARD_DELETE, board.getSeq());

	}
}

/*
 * BoardVO 객체에 SQL 조회 결과를 저장하여 반환
 */
class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();

		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getNString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getNString("content"));
		board.setRegDate(rs.getDate("regDate"));
		board.setCnt(rs.getInt("cnt"));

		return board;

	}
}
