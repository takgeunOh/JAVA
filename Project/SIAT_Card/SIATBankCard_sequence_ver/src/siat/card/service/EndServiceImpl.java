package siat.card.service;

public class EndServiceImpl extends Service {

	@Override
	public String requestService(int no) {
		
		// 종료는 보여주기만 하고 종료하면 됨.
		
		return viewName[no];
	}

}
