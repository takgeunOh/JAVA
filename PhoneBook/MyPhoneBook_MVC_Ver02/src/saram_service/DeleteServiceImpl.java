package saram_service;

public class DeleteServiceImpl implements Service {
	
	@Override
	public String requestService(String param) {
		
		if(intent.get("search_check")==null) {
			// ���� �̸� �˻� ��
			intent.put("search_check", 1);
			return "detail";
		}
		// ������ �̸� �˻� ��
		intent.put("search_check", null);
		return "delete";
	}
}
