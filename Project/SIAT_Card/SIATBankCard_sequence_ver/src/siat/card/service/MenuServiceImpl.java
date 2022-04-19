package siat.card.service;

import resource.R;

public class MenuServiceImpl extends Service implements R {

	@Override
	public String requestService(int no) {
		
		// 메뉴 쪽은 구현할 게 전혀 없음.
		// 뷰네임으로 menu 문자열만 리턴할 것
		
		return viewName[no];
	}

}
