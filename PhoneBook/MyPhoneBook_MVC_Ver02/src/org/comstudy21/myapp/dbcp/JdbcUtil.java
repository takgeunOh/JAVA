package org.comstudy21.myapp.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	// Ȯ���ڴ� �����, ����ó�� ���ش�.
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String user = "comstudy22";
	static String password = "comstudy22";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");			// ����̹� �˻�
			// ����̹��Ŵ��� �̿�
			try {
				conn = DriverManager.getConnection(url, user, password);			// ����
				//System.out.println("���� ����");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// System.out.println("���� ����");
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// System.out.println("����̹� �˻� ����");
			e.printStackTrace();
		}
		return conn;
		// Ŀ�ؼ� ��ü ���� ������ ��.
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