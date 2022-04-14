package saram_Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.comstudy21.myapp.dbcp.JdbcUtil;

import saram_Resource.resource;

// DataAccessObject
// DTO�� ������ �� �ִ� ArrayList�� �����.
public class PhoneDAO {

	final static String SQL_INSERT = "insert into saram values(?, ?, ?, ?)";
	final static String SQL_SELECT_ALL = "SELECT * FROM SARAM";
	final static String SQL_SELECT_NO = "SELECT * FROM SARAM WHERE NO=?";
	final static String SQL_SELECT_NAME = "SELECT * FROM SARAM WHERE NAME=?";
	final static String SQL_UPDATE = "UPDATE SARAM SET NAME=?, PHONE=?, EMAIL=? WHERE NO=?";
	final static String SQL_DELETE = "DELETE FROM SARAM WHERE NO=?";
	// final static String SQL_GET_NO = "SELECT ROWNUM FROM SARAM";

	// sql ��ü�� ���� ���� ����
	static PreparedStatement stmt; // �� �� �˾ƺ��� PreparedStatement
	static PreparedStatement stmt2;
	static Connection conn;
	static ResultSet rs;
	// static ResultSet rs2;			// �� ���� db�� �ִ� ��ȣ�� ������ ����.
	static int start_no=0;

	private static int sequence = 1;

	public static void insert(PhoneDTO dto) {
		// new SaramDto(0, name, phone, email)

		conn = JdbcUtil.getConnection();
		try {
			
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setInt(1, sequence++);			
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getPhone());
			stmt.setString(4, dto.getEmail());
			
			int resCnt = stmt.executeUpdate();

			
			/*
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getPhone());
			stmt.setString(4, dto.getEmail());
			*/

			if(resCnt>0)
				conn.commit();
			else
				conn.rollback();

			JdbcUtil.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getSequence() {
		return sequence;
	}

	public static void setSequence(int sequence) {
		PhoneDAO.sequence = sequence;
	}

	public static ArrayList<PhoneDTO> selectAll() {
		ArrayList<PhoneDTO> list = new ArrayList<PhoneDTO>();
		int number = 1;
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int no = number++;
				String name = rs.getNString("name");
				String phone = rs.getString("phone");
				String email = rs.getNString("email");
				list.add(new PhoneDTO(no, name, phone, email));
			}
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static ArrayList<PhoneDTO> selectByNumber(String search_name, ArrayList<PhoneDTO> list) {
		// �˻��� �̸��� ��ü ����� �Ķ����
		int count=0;
		resource.intent.put("duplicate_cnt", 0);
		ArrayList<PhoneDTO> result = new ArrayList<PhoneDTO>();
		
		conn = JdbcUtil.getConnection();
		try {
			
			stmt = conn.prepareStatement(SQL_SELECT_NAME);
			stmt.setString(1, search_name);
			rs = stmt.executeQuery();
			
			System.out.println("��ȣ\t�̸�\t\t��ȭ��ȣ\t\t�̸���");
			while(rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				System.out.printf("%s\t%s\t\t%s\t\t%s\n", no, name, phone, email);
				resource.intent.put("duplicate_cnt", 1);
			}
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void update (int modify_number, ArrayList<PhoneDTO> list) {
		Scanner scan = new Scanner(System.in);
		ArrayList<PhoneDTO> result = new ArrayList<PhoneDTO>();
		int modify_choice;
		String modify_change;
		int resCnt=0;
		
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(SQL_UPDATE);
			for(PhoneDTO abc : list) {
				if(abc.getNumber()==modify_number) {
					//System.out.println(abc.getPhone());
					System.out.println("������ �����͸� �����ϼ���.");
					System.out.println("1)����\t2)��ȭ��ȣ\t\t3)�̸���");
					modify_choice = scan.nextInt();

					if(modify_choice==1) {
						System.out.printf("%s�� �̸� ���� >> ", abc.getName());
						modify_change = scan.next();
						stmt.setString(1, modify_change);
						stmt.setString(2, abc.getPhone());
						stmt.setString(3, abc.getEmail());
						stmt.setInt(4, abc.getNumber());
					} else if (modify_choice==2) {
						System.out.printf("%s�� ��ȭ��ȣ ���� >> ", abc.getName());
						modify_change = scan.next();
						stmt.setString(1, abc.getName());
						stmt.setString(2, modify_change);
						stmt.setString(3, abc.getEmail());
						stmt.setInt(4, abc.getNumber());
					} else if (modify_choice==3) {
						System.out.printf("%s�� �̸��� ���� >> ", abc.getName());
						modify_change = scan.next();
						stmt.setString(1, abc.getName());
						stmt.setString(2, abc.getPhone());
						stmt.setString(3, modify_change);
						stmt.setInt(4, abc.getNumber());
					}
					resCnt = stmt.executeUpdate();
					break;
				}
			}
			
			if(resCnt>0)
				conn.commit();
			else
				conn.rollback();
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void delete(int delete_number, ArrayList<PhoneDTO> list) {
		
		conn = JdbcUtil.getConnection();
		int resCnt=0;
		ArrayList<PhoneDTO> result_list = new ArrayList<PhoneDTO>();
		
		try {
			stmt = conn.prepareStatement(SQL_DELETE);

			for(PhoneDTO abc : list) {
				if(abc.getNumber()==delete_number) {
					stmt.setInt(1, abc.getNumber());
					resCnt = stmt.executeUpdate();
					result_list.add(abc);
					// break �����ָ� remove ȣ��� ���� �پ�� ����� ���� ����.
					// �� ��� ConcurrentModificationException �߻�.
					// �ַ� �÷����� delete�� for������ ����� �� �߻�
					// �����ϴ� ������δ� Iterator�� ����϶�� ��.
				}
			}
			
			if(resCnt>0)
				conn.commit();
			else
				conn.rollback();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
