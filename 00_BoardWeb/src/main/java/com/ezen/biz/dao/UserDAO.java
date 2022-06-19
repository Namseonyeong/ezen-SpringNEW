package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.UserVO;


@Repository("userDAO") // 어노테이션 방식으로 구현시 필요 (Setter 등 client에서 방식 쓸경우 방식시 필요 없음)
 public class UserDAO {
	// JDBC 관련 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// SQL 명령어
	private final String USER_GET = "SELECT * FROM users WHERE id=? AND password=?";


	// CRUD 기능의 메소드 구현
	// 사용자 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		UserVO user = null;

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			
			//조회 실행
			rs = pstmt.executeQuery();
			// 상단에 SQL 명령어를 다 지정했기때문에 조회라던가 할 필요가 없음

			// 조회 결과 가져오기, id가 프라이머리 키이기 때문에 while문이 아닌 IF문 사용
			if (rs.next()) {
				user = new UserVO(); //값을 넣을 user객체 생성

				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return user;
	}

}
