package siat.card.service;

public class DeleteServiceImpl extends Service {

	@Override
	public String requestService(int no) {
		
		if(intent.get("search_check")==null) {
			// ���� �̸� �˻� ��
			intent.put("search_check", 1);
			return viewName[3];
		}
		
		intent.put("search_check", null);
		return viewName[no];
	}
	
}
