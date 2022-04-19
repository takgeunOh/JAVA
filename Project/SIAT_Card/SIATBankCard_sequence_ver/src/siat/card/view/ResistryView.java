package siat.card.view;

import resource.R;
import siat.card.model.CardDto;

public class ResistryView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		int id;				// 고유번호
		String cardName;
		String cardType;
		int annualFee;
		int cardRecord;
		String profit;
		
		/*
		System.out.print("카드 순번 : ");
		id = scan.nextInt();
		*/
		System.out.print("카드 이름 : ");
		cardName = scan.next();
		System.out.print("카드 타입 : ");
		cardType = scan.next();
		System.out.print("연회비 : ");
		annualFee = scan.nextInt();
		System.out.print("카드 실적 : ");
		cardRecord = scan.nextInt();
		System.out.print("카드 혜택 : ");
		profit = scan.next();
		
		intent.put("CardData", new CardDto(0, cardName, cardType, annualFee, cardRecord, profit));
		intent.put("no", 1);
		// 입력을 다 받으면 메뉴가 아닌 1로 이동
	}

}
