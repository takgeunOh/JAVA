package siat.card.view;

import resource.R;

public class MenuView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		int choice;
		
		System.out.printf(":::::::::: 조회할 서비스를 선택해주세요. ::::::::::\n", viewTitle);
		System.out.printf("1)카드등록\t2)카드조회\t3)카드검색\t4)카드수정\t5)카드삭제\t6)서비스종료\n");
		System.out.print("서비스 선택 >> ");
		choice = scan.nextInt();
		
		intent.put("menu", choice);
	}

}
