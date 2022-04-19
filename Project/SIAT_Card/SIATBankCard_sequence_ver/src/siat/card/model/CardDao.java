package siat.card.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcp.JdbcUtil;
import resource.R;

/*
그러니까 여기에서 우리가 할 때 지금 컨트롤러 꼭 안 써도 된다고. 
그냥 이벤트핸들러 안에서 이벤트핸들러 함수 있죠? 
이벤트발생하면 실행하는 함수. 거기에 함수 안에서 Dao를 바로 호출해도 된다고. 
거기에서 Dao를 호출하라고. 
그래서 Dao에 값을 넣줘기도 하고 Dao에 값을 갖고 오기도 하고. 
그렇게 할 수 있도록 하세요. 아시겠어요?

그러면 조금 더 편하잖아. 
이미 Dao는 다 만들어놨고 그리고 구현하는 부분에서 GUI에서 Dao만 
호출해 주면 되는 거 아니야.
*/

public class CardDao {
	
	final static String SQL_RESISTRY = "insert into SIATCARD values(?, ?, ?, ?, ?, ?)";
	final static String SQL_SELECT_ALL = "SELECT * FROM SIATCARD ORDER BY SEQ_NO";
	final static String SQL_SELECT_NO = "SELECT * FROM SIATCARD WHERE SEQ_NO=?";
	final static String SQL_SELECT_NAME = "SELECT * FROM SIATCARD WHERE CARDNAME=?";
	final static String SQL_UPDATE = "UPDATE SIATCARD SET CARDNAME=?, CARDTYPE=?, ANNUALFEE=?, CARDRECORD=?, PROFIT=? WHERE SEQ_NO=?";
	final static String SQL_DELETE = "DELETE FROM SIATCARD WHERE SEQ_NO=?";
	
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet rs;
	
	// private static int sequence = 1;
	
	public static void insert(CardDto dto) throws SQLException {
		// System.out.println("���⼭ �߰��߰�����");
		ResultSet rs = selectAll();
		int flag=0;
		rs.beforeFirst();			// 커서의 위치를 가장 처음으로 이동 first()보다 이전 공간
		while(rs.next()) {
			// rowCount++;
			flag=1;
		}
		
		rs.previous();				// 마지막 행 커서 포인트
		int sequence=0;
		if(flag==1)
			sequence = rs.getInt("seq_no");
		
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_RESISTRY);
			
			stmt.setInt(1, sequence+1);
			stmt.setString(2, dto.getCardName());
			stmt.setString(3, dto.getCardType());
			stmt.setInt(4, dto.getAnnualFee());
			stmt.setInt(5, dto.getCardRecord());
			stmt.setString(6, dto.getProfit());
			
			int resCnt = stmt.executeUpdate();
			// insert, delete, update ���� �������� �ݿ��� ���ڵ��� �Ǽ��� ��ȯ
			
			if(resCnt>0)
				conn.commit();
			else
				conn.rollback();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, stmt, rs);
	}
	
	public static ResultSet selectAll() {
		
		// ArrayList<CardDto> result = new ArrayList<CardDto>();
		
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(SQL_SELECT_ALL,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();
			
			// System.out.println(rs.getString("cardname"));
			// JdbcUtil.close(conn, stmt);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static CardDto selectOne(String search_name) {
		
		CardDto result = new CardDto();
		
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_NAME);
			stmt.setString(1, search_name);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				result.setNo(rs.getInt("seq_no"));
				result.setCardName(rs.getString("cardname"));
				result.setCardType(rs.getNString("cardtype"));
				result.setAnnualFee(rs.getInt("annualfee"));
				result.setCardRecord(rs.getInt("cardrecord"));
				result.setProfit(rs.getNString("profit"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JdbcUtil.close(conn, stmt, rs);
		return result;
	}
	
	public static void modify(CardDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			// System.out.println("�Ѿ���� dto" + dto);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, dto.getCardName());
			stmt.setString(2, dto.getCardType());
			stmt.setInt(3, dto.getAnnualFee());
			stmt.setInt(4, dto.getCardRecord());
			stmt.setString(5, dto.getProfit());
			stmt.setInt(6, dto.getNo());

			int resCnt = stmt.executeUpdate();
			
			if(resCnt>0)
				conn.commit();
			else {
				R.intent.put("modify_check", 1);		// ���� �۾��� �ϳ��� �̷������ �ʾ��� �� view �ʿ��� �긦 ���� �� ��
				conn.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, rs);
	}
	
	public static void delete(int del_no) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_DELETE);
			int changeDelNo = del_no;
			stmt.setInt(1, changeDelNo);
			
			int resCnt = stmt.executeUpdate();
			
			if(resCnt>0)
				conn.commit();
			else {
				R.intent.put("delete_check", 1);		// ���� �۾��� �ϳ��� �̷������ �ʾ��� �� view �ʿ��� �긦 ���� �� ��
				conn.rollback();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stmt, rs);
	}
}
