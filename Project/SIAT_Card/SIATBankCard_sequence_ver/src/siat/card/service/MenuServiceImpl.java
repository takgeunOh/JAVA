package siat.card.service;

import resource.R;

public class MenuServiceImpl extends Service implements R {

	@Override
	public String requestService(int no) {
		
		// �޴� ���� ������ �� ���� ����.
		// ��������� menu ���ڿ��� ������ ��
		
		return viewName[no];
	}

}
