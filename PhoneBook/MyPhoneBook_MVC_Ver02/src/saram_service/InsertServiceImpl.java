package saram_service;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class InsertServiceImpl implements Service {

	@Override
	public String requestService(String path) {
		// System.out.println(path + " run");
		if(intent.get("saramData") == null) {
			// �Է� �ޱ� �� - �Է� �������� �̵�
			return "input";
		}
		// �Է� �� DAO�� ����
		PhoneDAO.insert((PhoneDTO)intent.get("saramData"));
		intent.put("saramData", null);
		return "list";
	}
}
