package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
   static String url = "jdbc:oracle:thin:@localhost:1521:XE";
   static String user = "SIATBANK";
   static String password = "SIATBANK";
   public static Connection getConnection() {
      Connection conn = null;
      try {
         Class.forName("oracle.jdbc.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 검색 실패");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("접속 실패");
         e.printStackTrace();
      }
      return conn;
   }
   
   public static void close(Connection conn) {
      if(conn != null) {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void close(ResultSet rs) {
      if(rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void close(Statement stmt) {
      if(stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void close(Connection conn, Statement stmt) {
	   close(stmt);
	   close(conn);
   }
   
   public static void close(Connection conn, Statement stmt, ResultSet rs) {
      close(rs);
      close(stmt);
      close(conn);
   }
}