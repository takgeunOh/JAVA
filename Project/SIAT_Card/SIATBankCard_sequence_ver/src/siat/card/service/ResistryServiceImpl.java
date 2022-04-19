package siat.card.service;

import java.sql.SQLException;

import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class ResistryServiceImpl extends Service {

	@Override
	public String requestService(int no) {
		// System.out.println("no : " + no);
		if(intent.get("CardData")==null) {
			// 카드정보 등록 전에는 ResistryView 이름을 보내줄 것.
			return viewName[no];
		} else {
			// 카드정보 입력 후
			try {
				CardDao.insert((CardDto)intent.get("CardData"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			intent.put("CardData", null);
			
			return viewName[2];
		}

		
		
	}
	
}
