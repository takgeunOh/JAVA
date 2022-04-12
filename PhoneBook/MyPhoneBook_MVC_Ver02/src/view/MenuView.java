package view;

import resource.Resource;
import service.MenuService;

public class MenuView extends MenuService {

	public void print() {
		
		System.out.printf(":::::::: %s ::::::::\n", Resource.viewTitle[0]);
		System.out.println("1)input\t\t2)output\t3)search\t4)modify\t5)delete\t6)end");
	}

}
