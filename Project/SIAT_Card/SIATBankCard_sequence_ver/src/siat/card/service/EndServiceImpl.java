package siat.card.service;

public class EndServiceImpl extends Service {

	@Override
	public String requestService(int no) {
		
		// ����� �����ֱ⸸ �ϰ� �����ϸ� ��.
		
		return viewName[no];
	}

}
