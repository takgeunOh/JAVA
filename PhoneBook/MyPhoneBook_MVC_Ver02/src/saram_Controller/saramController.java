package saram_Controller;

import saram_Resource.resource;
import saram_service.Service;

public class saramController extends Controller {
	
	
	public void handleRequest() {
		int number;
		String path;
		Service service;
		String viewName;
		
		// 첫 진입 시 메뉴가 나오도록 number는 main에서 0으로 초기화되어있음.
		// number 로 입력값을 받으면 resource 인터페이스에서 해당하는 서비스로 스트링을 받고
		// 받은 스트링(요청서비스)을 컨트롤러에 전달하게 한다.
		number = (Integer)resource.intent.get("number");
		// System.out.println(number);	// 정상 출력
		path = resource.menuArr[number];
		// System.out.println(path);		// 정상 출력
		
		service = saram_Service_Factory.get(path);
		// path == "input"
		// 메뉴는 service == null 로 나올 것
		// Impl 생성자로 저장
		// Service service = new InsertServiceImpl();
		
		viewName = "menu";
		// 디폴트.
		
		if(service!=null) {
			// viewName 추출
			viewName = service.requestService(path);
			// viewName = path로 리턴되고 있음.
			// 인스턴스화(service)해서 static을 주지 않아도 접근 가능하게 만들음.
		}
		// view 객체를 찾기 위한 질의 시작
		viewResolver.dispatcher(viewName);
		
		handleRequest();
		return;
	}
}
