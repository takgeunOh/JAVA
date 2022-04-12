package controller;

import service.service;

// spring MVC 그림 참고
// https://howtodoinjava.com/spring-mvc/spring-mvc-hello-world-example/

public class DispatcherServlet {
	
	public void request() {
		
		// 1.
		// DispatcherServlet에서 HandlerMapping으로 요청을 보내면
		// HandlerMapping에서 서비스를 DispatcherServlet으로 반환
		service service;
		HandlerMapping hm = new HandlerMapping();
		service = hm.getService();
		// System.out.println(service);	// 서비스 정상 반환 확인 완료
		service.requestService();
		
		// 2.
		// DispatcherServlet에서 Controller로 요청을 보내면
		// Controller에서 ModelAndView를 DispatcherServlet으로 반환
		
		
		
		/*
		request();
		return;
		*/
	}
	
	// 3.
	// DispatcherServlet에서 ViewResolver로 ViewName을 보내면
	// ViewResolver에서 View를 DispatcherServlet으로 반환
	
	// 4.
	// DispatcherServlet에서 View로 Model을 보내면
	// View에서 response를 DispatcherServlet으로 반환
	
}
