package com.ezen.biz.common;

import java.sql.*;

/*
 * 	-------  데이터베이스 Connection 을 얻거나 해지하는 처리.  -------
 */

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uid = "spring_user";
		String pass = "ora123";
		
		try {
			// 오라클 JDBC 드라이버를 메모리에 로드.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/*
	 * 	Select문 수행 후 close() 메소드.
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	Update, Insert, Delete문 수행후 close() 메소드.
	 */
	public static void close(Connection conn, Statement stmt) { //stmt는 psmt 조상타입.
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




