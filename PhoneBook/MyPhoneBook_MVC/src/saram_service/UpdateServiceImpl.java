package saram_service;

public class UpdateServiceImpl implements Service {
	@Override
	public String requestService(String param) {
		
		// 최초에 "update" 로 인자 들어오면 intent.get("search_check", value) 확인하기
		// value가 null이면 intent.put("search_check", 0) 진행 후 detail에 대해 ViewResolver가 돌아갈 것이고
		// detail에 대한 뷰가 끝나면 
		// 수정작업 구현 후 value는 다시 null로 초기화
		
		if(intent.get("search_check")==null) {
			// 수정 이름 검색 전
			intent.put("search_check", 0);
			return "detail";
		}
		// 수정할 이름 검색 후
		intent.put("search_check", null);
		return "update";
	}
}
