package siat.card.controller;

import resource.R;
import siat.card.service.Service;

public class DispatcherServlet implements R {
	
	public void request() {
		
		int no = (Integer)intent.get("menu");
		// System.out.println(no);						// ���� ���
		// 1
		// 2
		// 3
		// 4
		// 5
		
		Service service = ServiceMapping.get(no);
		// System.out.println(service);					// ������� Ȯ��
		// ResistryServiceImpl()
		// ListServiceImpl()
		// SearchServiceImpl()
		// ModifyServiceImpl()
		// DeleteServiceImpl()
		
		String viewName = service.requestService(no);
		// RESISTRY
		// LIST
		// SEARCH
		// ó���� SEARCH
		
		// System.out.println(viewName);				// viewTitle�� ������� Ȯ��
		
		
		
		ViewResolver.dispatcher(viewName);
		
		request();
		return;
	}
}
