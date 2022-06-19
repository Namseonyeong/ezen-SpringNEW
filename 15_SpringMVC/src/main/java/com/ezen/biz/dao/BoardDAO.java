package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;

/*
 *    -------  BOARD 테이블과 CRUD 기능을 처리할 클래스.  -------
 */

@Repository("boardDAO")
public class BoardDAO {
   // JDBC 관련 변수
   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   // SQL 명령어들
   private final static String BOARD_INSERT =
         "INSERT INTO board(seq, title, writer, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
   private final static String BOARD_UPDATE =
         "UPDATE board SET title=?, writer=?, content=? WHERE seq=?";
   private final static String BOARD_DELETE =
         "DELETE board WHERE seq=? ";
   private final static String BOARD_GET =
         "SELECT * FROM board WHERE seq=?";
   private final static String BOARD_LIST =
         "SELECT * FROM board ORDER BY seq DESC";
   
   // CRUD 기능의 메소드 구현
      //   ---- 게시글 전체 목록 조회. ----
   public List<BoardVO> getBoardList() {
      List<BoardVO> boardList = null;
      System.out.println("===> JDBC로 getBoardList() 기능 처리");
      
      try {
         conn = JDBCUtil.getConnection();
         pstmt = conn.prepareStatement(BOARD_LIST);
         rs= pstmt.executeQuery();
         
         boardList = new ArrayList<>();
         
         while (rs.next()) {
            BoardVO board = new BoardVO();
            
            board.setSeq(rs.getInt("seq"));
            board.setTitle(rs.getString("title"));
            board.setWriter(rs.getString("writer"));
            board.setContent(rs.getString("content"));
            board.setRegDate(rs.getDate("regDate"));
            board.setCnt(rs.getInt("cnt"));
            
            boardList.add(board);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         JDBCUtil.close(conn, pstmt, rs);
      }
      return boardList;
   }
   
   
      //   ---- 글 상세 조회 – seq 번호에 의한 조회. ----
   public BoardVO getBoard(BoardVO vo) {
      System.out.println("===> JDBC로 getBoard() 기능 처리");
      BoardVO board = null; 
      
      try {
         conn = JDBCUtil.getConnection();
         pstmt = conn.prepareStatement(BOARD_GET);
         
         pstmt.setInt(1, vo.getSeq());
         
         rs= pstmt.executeQuery();
         
         while (rs.next()) {
            board = new BoardVO();
            
            board.setSeq(rs.getInt("seq"));
            board.setTitle(rs.getString("title"));
            board.setWriter(rs.getString("writer"));
            board.setContent(rs.getString("content"));
            board.setRegDate(rs.getDate("regDate"));
            board.setCnt(rs.getInt("cnt"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         JDBCUtil.close(conn, pstmt, rs);
      }
      return board;
   }
   

      //   ---- 글 등록. ----
   public void insertBoard(BoardVO board) {
      System.out.println("===> JDBC로 insertBoard() 기능 처리");
      
      try {
         conn = JDBCUtil.getConnection();
         pstmt = conn.prepareStatement(BOARD_INSERT);
         
         pstmt.setString(1, board.getTitle());
         pstmt.setString(2, board.getWriter());
         pstmt.setString(3, board.getContent());
         
         pstmt.executeUpdate();
         
      }  catch (Exception e) {
         e.printStackTrace();
      } finally {
         JDBCUtil.close(conn, pstmt);
      }
   }
   
   
      //  ---- 글 수정.  ----
   public void updateBoard(BoardVO board) {
      System.out.println("===> JDBC로 updateBoard() 기능 처리");
      
      try {
         conn = JDBCUtil.getConnection();
         pstmt = conn.prepareStatement(BOARD_UPDATE);
         
         pstmt.setString(1, board.getTitle());
         pstmt.setString(2, board.getWriter());
         pstmt.setString(3, board.getContent());
         pstmt.setInt(4, board.getSeq());
         
         pstmt.executeUpdate();
         
      }  catch (Exception e) {
         e.printStackTrace();
      } finally {
         JDBCUtil.close(conn, pstmt);
      }
   }

   
      //   ---- 글 삭제 ----
   public void deleteBoard(BoardVO board) {
      System.out.println("===> JDBC로 deleteBoard() 기능 처리");
      
      try {
         conn = JDBCUtil.getConnection();
         pstmt = conn.prepareStatement(BOARD_DELETE);
         
         pstmt.setInt(1, board.getSeq());
         
         pstmt.executeUpdate();
         
      }  catch (Exception e) {
         e.printStackTrace();
      } finally {
         JDBCUtil.close(conn, pstmt);
      }
   }

   
}
