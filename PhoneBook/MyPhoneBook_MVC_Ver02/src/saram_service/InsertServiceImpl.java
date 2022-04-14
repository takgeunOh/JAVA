package saram_service;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class InsertServiceImpl implements Service {

	@Override
	public String requestService(String path) {
		// System.out.println(path + " run");
		if(intent.get("saramData") == null) {
			// 입력 받기 전 - 입력 페이지로 이동
			return "input";
		}
		// 입력 후 DAO에 전달
		PhoneDAO.insert((PhoneDTO)intent.get("saramData"));
		intent.put("saramData", null);
		return "list";
	}
}
