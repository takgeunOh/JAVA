package org.comstudy21.myapp.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	// 확장자는 지우고, 예외처리 해준다.
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String user = "comstudy22";
	static String password = "comstudy22";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");			// 드라이버 검색
			// 드라이버매니저 이용
			try {
				conn = DriverManager.getConnection(url, user, password);			// 접속
				//System.out.println("연결 성공");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// System.out.println("접속 실패");
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// System.out.println("드라이버 검색 실패");
			e.printStackTrace();
		}
		return conn;
		// 커넥션 객체 만들어서 리턴한 것.
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(conn);
	}
}