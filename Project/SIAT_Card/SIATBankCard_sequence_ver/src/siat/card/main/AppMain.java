package siat.card.main;

import resource.R;
import siat.card.controller.DispatcherServlet;

public class AppMain {

	public static void main(String[] args) {
		
		System.out.println("SIAT-Bank�� ���� ���� ȯ���մϴ�.\n");
		R.intent.put("menu", 0);
		
		new DispatcherServlet().request();

	}

}
