package siat.card.view;

import resource.R;
import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class DeleteView extends View implements R {

	@Override
	public void display(String viewTitle) {
		int choice;
		
		System.out.print("삭제를 원하는 번호를 입력해주세요. >> ");
		choice = scan.nextInt();
		
		if(intent.get("delete_check")!=null) {
			System.out.println("검색하신 번호는 존재하지 않습니다.");
			intent.put("menu", 0);
			return;
		}
		CardDao.delete(choice);
		intent.put("menu", 2);
		intent.put("delete_check", null);
	}

}
