package siat.card.view;

import resource.R;
import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class ModifyView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		int choice;
		String cardName, cardType, profit;
		int annualFee, cardRecord;
		
		System.out.print("수정을 원하는 번호를 입력해주세요. >> ");
		// 어차피 중복이름은 맨 처음 카드등록 시 중복체크할 것이기 때문에 여기선 신경 안 써도 될듯
		choice = scan.nextInt();
		
		if(intent.get("modify_check")!=null) {
			System.out.println("검색하신 번호는 존재하지 않습니다.");
			intent.put("menu", 0);
			return;
		}
		
		System.out.print("카드 이름 수정 >> ");
		cardName = scan.next();
		System.out.print("카드 타입 수정 >> ");
		cardType = scan.next();
		System.out.print("연회비 수정 >> ");
		annualFee = scan.nextInt();
		System.out.print("카드실적 수정 >> ");
		cardRecord = scan.nextInt();
		System.out.print("혜택 수정 >> ");
		profit = scan.next();
		
		// intent.put("modifyData", new CardDto(choice, cardName, cardType, annualFee, cardRecord, profit));
		CardDao.modify(new CardDto(choice, cardName, cardType, annualFee, cardRecord, profit));
		intent.put("menu", 2);
		intent.put("modify_check", null);
	}

}
