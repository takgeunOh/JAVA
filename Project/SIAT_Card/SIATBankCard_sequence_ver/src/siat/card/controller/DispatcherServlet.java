package siat.card.controller;

import resource.R;
import siat.card.service.Service;

public class DispatcherServlet implements R {
	
	public void request() {
		
		int no = (Integer)intent.get("menu");
		// System.out.println(no);						// 정상 출력
		// 1
		// 2
		// 3
		// 4
		// 5
		
		Service service = ServiceMapping.get(no);
		// System.out.println(service);					// 정상출력 확인
		// ResistryServiceImpl()
		// ListServiceImpl()
		// SearchServiceImpl()
		// ModifyServiceImpl()
		// DeleteServiceImpl()
		
		String viewName = service.requestService(no);
		// RESISTRY
		// LIST
		// SEARCH
		// 처음엔 SEARCH
		
		// System.out.println(viewName);				// viewTitle로 정상출력 확인
		
		
		
		ViewResolver.dispatcher(viewName);
		
		request();
		return;
	}
}
