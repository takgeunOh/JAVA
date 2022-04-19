package siat.card.main;

import resource.R;
import siat.card.controller.DispatcherServlet;

public class AppMain {

	public static void main(String[] args) {
		
		System.out.println("SIAT-Bank에 오신 것을 환영합니다.\n");
		R.intent.put("menu", 0);
		
		new DispatcherServlet().request();

	}

}
