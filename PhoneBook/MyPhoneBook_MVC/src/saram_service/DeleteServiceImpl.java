package saram_service;

public class DeleteServiceImpl implements Service {
	
	@Override
	public String requestService(String param) {
		
		if(intent.get("search_check")==null) {
			// 수정 이름 검색 전
			intent.put("search_check", 1);
			return "detail";
		}
		// 수정할 이름 검색 후
		intent.put("search_check", null);
		return "delete";
	}
}
