package controller;

import service.service;

// spring MVC �׸� ����
// https://howtodoinjava.com/spring-mvc/spring-mvc-hello-world-example/

public class DispatcherServlet {
	
	public void request() {
		
		// 1.
		// DispatcherServlet���� HandlerMapping���� ��û�� ������
		// HandlerMapping���� ���񽺸� DispatcherServlet���� ��ȯ
		service service;
		HandlerMapping hm = new HandlerMapping();
		service = hm.getService();
		// System.out.println(service);	// ���� ���� ��ȯ Ȯ�� �Ϸ�
		service.requestService();
		
		// 2.
		// DispatcherServlet���� Controller�� ��û�� ������
		// Controller���� ModelAndView�� DispatcherServlet���� ��ȯ
		
		
		
		/*
		request();
		return;
		*/
	}
	
	// 3.
	// DispatcherServlet���� ViewResolver�� ViewName�� ������
	// ViewResolver���� View�� DispatcherServlet���� ��ȯ
	
	// 4.
	// DispatcherServlet���� View�� Model�� ������
	// View���� response�� DispatcherServlet���� ��ȯ
	
}
