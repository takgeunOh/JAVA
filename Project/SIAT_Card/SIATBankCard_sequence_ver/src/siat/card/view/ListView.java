package siat.card.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.JdbcUtil;
import resource.R;
import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class ListView extends View implements R {

	@Override
	public void display(String viewTitle) {
		// viewTitle : "LIST"
		ResultSet rs = CardDao.selectAll();
		int annualFee, cardRecord;
		String no, cardName, cardType, profit;
		
		if(intent.get("list_check")!=null)
			System.out.println("\n!! ���� ����� ī�� ������ �����ϴ�. !!\n");
		else {
			System.out.println("\n��ȣ\tī���̸�\tī��Ÿ��\t��ȸ��\tī�����\t����");
			
			try {
				while(rs.next()) {
					no = rs.getString("seq_no").toString();
					cardName = rs.getString("cardname").toString();
					cardType = rs.getString("cardtype").toString();
					annualFee = Integer.parseInt(rs.getString("annualfee").toString());
					cardRecord = Integer.parseInt(rs.getString("cardrecord").toString());
					profit = rs.getString("profit").toString();
					
					System.out.printf("%s\t%s\t%s\t%d\t%d\t%s\n", no, cardName, cardType, annualFee, cardRecord, profit);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			for(CardDto dto : list) {
				System.out.println(dto.toString());
			}*/
		}
		System.out.println("\n");
		
		intent.put("list_check", null);
		intent.put("menu", 0);
		JdbcUtil.close(rs);
	}
	
}
