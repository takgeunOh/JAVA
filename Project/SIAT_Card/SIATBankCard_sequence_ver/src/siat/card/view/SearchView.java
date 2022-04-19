package siat.card.view;

import resource.R;
import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class SearchView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		String search_name;
		System.out.println("조회(작업)할 카드 이름을 입력해주세요.");
		search_name = scan.next();
		
		CardDto result = CardDao.selectOne(search_name);
		
		System.out.println(result);
		if(result!=null) {
			System.out.println("\n검색하신 카드의 정보는 다음과 같습니다.");
			System.out.println(result.toString());
			System.out.println();
			// intent.put("search_check", 1);
		} else {
			System.out.println("\n검색하신 카드는 데이터에 존재하지 않습니다.\n");
			intent.put("menu", 0);
			intent.put("search_check", null);
			return;
		}
		
		if(intent.get("search_check")==null)
			intent.put("menu", 0);				// 카드검색만 했을 경우
		else if ((Integer)intent.get("search_check")==0) {
			intent.put("menu", 4);				// 수정작업을 통해 검색작업으로 들어왔을 떄 검색 완료 후에는 곧바로 수정 작업으로 돌아가기
			intent.put("modifyData", result);
		} else if ((Integer)intent.get("search_check")==1) {
			intent.put("menu", 5);				// 삭제작업을 통해 검색작업으로 들어왔을 때 검색 완료 후에는 곧바로 삭제 작업으로 들어가기
			intent.put("deleteData", result);
		}
		
		intent.put("notExistDataCheck", null);
		// intent.put("search_check", null);
	}

}
