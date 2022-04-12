package controller;

import java.util.HashMap;

import resource.Resource;
import service.DeleteService;
import service.EndService;
import service.InputService;
import service.MenuService;
import service.ModifyService;
import service.OutputService;
import service.SearchService;
import service.service;

public class HandlerMapping {
	
	static HashMap<String, service> service = new HashMap<String, service>();
	static {
		service.put("menu", new MenuService());
		service.put("input", new InputService());
		service.put("output", new OutputService());
		service.put("search", new SearchService());
		service.put("modify", new ModifyService());
		service.put("delete", new DeleteService());
		service.put("end", new EndService());
	}
	
	public service getService() {
		// 1.
		// DispatcherServlet에서 HandlerMapping으로 요청을 보내면
		// HandlerMapping에서 서비스를 DispatcherServlet으로 반환
		
		String requestMenu = ExtractMenu.return_menu();
		// System.out.println(requestMenu);	// 정상 출력 확인
		
		// 맵핑을 이용해서 기능을 구현할 서비스 선택
		return service.get(requestMenu);
	}

	

	
}
