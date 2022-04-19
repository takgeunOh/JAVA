package siat.card.controller;

import java.util.HashMap;

import siat.card.service.DeleteServiceImpl;
import siat.card.service.EndServiceImpl;
import siat.card.service.ListServiceImpl;
import siat.card.service.MenuServiceImpl;
import siat.card.service.ModifyServiceImpl;
import siat.card.service.ResistryServiceImpl;
import siat.card.service.SearchServiceImpl;
import siat.card.service.Service;

public class ServiceMapping {
	
	static HashMap<Integer, Service> mapper = new HashMap<Integer, Service>();
	
	static {
		mapper.put(0, new MenuServiceImpl());
		mapper.put(1, new ResistryServiceImpl());
		mapper.put(2, new ListServiceImpl());
		mapper.put(3, new SearchServiceImpl());
		mapper.put(4, new ModifyServiceImpl());
		mapper.put(5, new DeleteServiceImpl());
		mapper.put(6, new EndServiceImpl());
	}
	
	
	public static Service get(int no) {
		
		Service service = mapper.get(no);
		
		return service;
	}
}
