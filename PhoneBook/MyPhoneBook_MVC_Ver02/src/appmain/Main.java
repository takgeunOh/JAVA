package appmain;

import controller.DispatcherServlet;
import resource.Resource;

public class Main {

	public static void main(String[] args) {
		
		Resource.intent.put("menu", 0);
		// ���� ����� ��û�� �޴� ���� ��û���� �ϰ�
		new DispatcherServlet().request();
		// ��û�� ������ DispatcherServlet ȣ��
		// DispatcherServlet�� ���� ��û�� HandlerMapping���� ������ ��.
	}
}
