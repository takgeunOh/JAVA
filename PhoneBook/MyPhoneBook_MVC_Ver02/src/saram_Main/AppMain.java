package saram_Main;

import saram_Controller.Controller;
import saram_Controller.saramController;
import saram_Resource.resource;

public class AppMain {

	public static void main(String[] args) {
		
		resource.intent.put("number", 0);			// 0 : �޴� �������� �ʱ�ȭ�ϰ� ����
		// new Controller().handleRequest();
		// ��ó�� �ϸ� �߻�Ŭ������ �ν��Ͻ�ȭ �õ��� �� ������ �߻��Ѵ�.
		// Abstract classes cannot be instantiated, but they can be subclassed.
		new saramController().handleRequest();
	}
}
