package service;

import view.MenuView;

public class MenuService implements service {

	// 부모클래스가 자식클래스의 print() 메소드를 먼저 사용하고 싶다..
	// 부모클래스를 추상메소드로 구현하고 자식클래스에서 추상메소드를 구현하는 방법이 제일 베스트..
	// 하지만 부모를 추상으로 만든다면 HandlerMapping도 갈아엎어야 할 뿐만 아니라
	// 중요한건 자식클래스(view)에서 구현한다는 것 자체가 MVC 취지와 맞지 않음.
	
	// 솔루션 : 부모클래스를 강제캐스팅할 것.
	
	@Override
	public void requestService() {
		
		MenuService obj = new MenuView();
		((MenuView)obj).print();
		
		System.out.print("수행할 작업을 선택하세요 >> ");
		int choice = scan.nextInt();
		
		intent.put("service", choice);
	}
	
	
}
