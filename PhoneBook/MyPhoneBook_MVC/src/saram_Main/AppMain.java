package saram_Main;

import saram_Controller.Controller;
import saram_Controller.saramController;
import saram_Resource.resource;

public class AppMain {

	public static void main(String[] args) {
		
		resource.intent.put("number", 0);			// 0 : 메뉴 진입으로 초기화하고 시작
		// new Controller().handleRequest();
		// 위처럼 하면 추상클래스를 인스턴스화 시도할 때 에러가 발생한다.
		// Abstract classes cannot be instantiated, but they can be subclassed.
		new saramController().handleRequest();
	}
}
