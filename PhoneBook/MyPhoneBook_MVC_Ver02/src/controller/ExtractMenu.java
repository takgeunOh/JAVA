package controller;

import resource.Resource;

public class ExtractMenu extends HandlerMapping {
	
	public static String return_menu() {
		// intent�� "menu"Ű�� ���� �̿��Ͽ�
		// Resource �������̽��� �迭�� ��������.
		int input_number = (Integer)Resource.intent.get("menu");
		
		return Resource.menuItem[input_number];
	}
}
