package siat.card.service;

public class SearchServiceImpl extends Service {

	@Override
	public String requestService(int no) {
		
		return viewName[no];
	}

}
