package controller;

import resource.Resource;

public class ExtractMenu extends HandlerMapping {
	
	public static String return_menu() {
		// intent의 "menu"키의 값을 이용하여
		// Resource 인터페이스의 배열을 가져오기.
		int input_number = (Integer)Resource.intent.get("menu");
		
		return Resource.menuItem[input_number];
	}
}
