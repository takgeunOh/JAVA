package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class SearchView extends View {

	@Override
	protected void draw() {
		int count=0;
		
		// 구현된 걸 보여준 후 메뉴로 이동하기
		System.out.print("검색할 이름을 입력해주세요. >> ");
		String search_name = scan.next();
		
		/*
		PhoneDTO dto = new PhoneDTO();
		System.out.println(dto.getName());
		
		 * 이 방법은 통하지 않는다.
		 * 입력 받을 때 DTO를 초기화시켜버려서 dto쪽에서 데이터를 얻을 수 없기도 하고
		 * 배열리스트인 pbList 모두에 접근할 수 있는 방법이 아님.
		*/
		
		// 결국은 pbList를 사용해야할 것 같다.
		// PhoneDTO 타입의 참조변수와 PhoneDAO의 selectByNumber 메소드를 이용해본다면
		PhoneDTO result = new PhoneDTO();
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();	// 현재 저장된 pbList 모두 불러오기
		ArrayList<PhoneDTO> duplicate_array = new ArrayList<PhoneDTO>();
		
		for(PhoneDTO abc : list) {
			result = PhoneDAO.selectByNumber(abc);
			if((result!=null) && (result.getName().equals(search_name))) {
				duplicate_array.add(result);		
				count++;
			}
		}
		// 검색정보와 일치하는 데이터를 result에 담은 상태
		if(count==0)
			System.out.println("!! 찾으시는 이름이 데이터에 존재하지 않습니다. !!\n");
		else if (count>0) {
			System.out.println(">> 찾으시는 이름이 다음과 같이 데이터에 존재합니다. <<");
			System.out.println("번호\t성명\t전화번호\t\t이메일");
			for(PhoneDTO abc : duplicate_array) {
				System.out.println(abc);
			}
		}
		
		if(intent.get("search_check")==null)
			intent.put("number", 0);
		else if((Integer)intent.get("search_check")==0)
			intent.put("number", 4);
		else if ((Integer)intent.get("search_check")==1)
			intent.put("number", 5);
	}
	
}
