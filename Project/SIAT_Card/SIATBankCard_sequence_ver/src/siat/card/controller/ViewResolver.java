package siat.card.controller;

import java.util.HashMap;

import siat.card.view.DeleteView;
import siat.card.view.EndView;
import siat.card.view.ListView;
import siat.card.view.MenuView;
import siat.card.view.ModifyView;
import siat.card.view.ResistryView;
import siat.card.view.SearchView;
import siat.card.view.View;

public class ViewResolver {
	
	static HashMap<String, View> mapper = new HashMap<String, View>();
	static {
		mapper.put("MENU", new MenuView());
		mapper.put("RESISTRY", new ResistryView());
		mapper.put("LIST", new ListView());
		mapper.put("SEARCH", new SearchView());
		mapper.put("MODIFY", new ModifyView());
		mapper.put("DELETE", new DeleteView());
		mapper.put("END", new EndView());
	}
	
	
	public static void dispatcher(String viewName) {
		View view = mapper.get(viewName);
		
		view.display(viewName);
	}
}
