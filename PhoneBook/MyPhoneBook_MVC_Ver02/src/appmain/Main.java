package appmain;

import controller.DispatcherServlet;
import resource.Resource;

public class Main {

	public static void main(String[] args) {
		
		Resource.intent.put("menu", 0);
		// 최초 사용자 요청은 메뉴 서비스 요청으로 하고
		new DispatcherServlet().request();
		// 요청이 들어오면 DispatcherServlet 호출
		// DispatcherServlet은 받은 요청을 HandlerMapping에게 던져줄 것.
	}
}
