package siat.card.service;

public class ListServiceImpl extends Service{

	@Override
	public String requestService(int no) {
		
		return viewName[no];
	}

}
