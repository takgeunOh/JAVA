package saram_service;

public class UpdateServiceImpl implements Service {
	@Override
	public String requestService(String param) {
		
		// ���ʿ� "update" �� ���� ������ intent.get("search_check", value) Ȯ���ϱ�
		// value�� null�̸� intent.put("search_check", 0) ���� �� detail�� ���� ViewResolver�� ���ư� ���̰�
		// detail�� ���� �䰡 ������ 
		// �����۾� ���� �� value�� �ٽ� null�� �ʱ�ȭ
		
		if(intent.get("search_check")==null) {
			// ���� �̸� �˻� ��
			intent.put("search_check", 0);
			return "detail";
		}
		// ������ �̸� �˻� ��
		intent.put("search_check", null);
		return "update";
	}
}
