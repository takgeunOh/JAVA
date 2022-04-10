package saram_Controller;

import saram_Resource.resource;
import saram_service.Service;

public class saramController extends Controller {
	
	
	public void handleRequest() {
		int number;
		String path;
		Service service;
		String viewName;
		
		// ù ���� �� �޴��� �������� number�� main���� 0���� �ʱ�ȭ�Ǿ�����.
		// number �� �Է°��� ������ resource �������̽����� �ش��ϴ� ���񽺷� ��Ʈ���� �ް�
		// ���� ��Ʈ��(��û����)�� ��Ʈ�ѷ��� �����ϰ� �Ѵ�.
		number = (Integer)resource.intent.get("number");
		// System.out.println(number);	// ���� ���
		path = resource.menuArr[number];
		// System.out.println(path);		// ���� ���
		
		service = saram_Service_Factory.get(path);
		// path == "input"
		// �޴��� service == null �� ���� ��
		// Impl �����ڷ� ����
		// Service service = new InsertServiceImpl();
		
		viewName = "menu";
		// ����Ʈ.
		
		if(service!=null) {
			// viewName ����
			viewName = service.requestService(path);
			// viewName = path�� ���ϵǰ� ����.
			// �ν��Ͻ�ȭ(service)�ؼ� static�� ���� �ʾƵ� ���� �����ϰ� ������.
		}
		// view ��ü�� ã�� ���� ���� ����
		viewResolver.dispatcher(viewName);
		
		handleRequest();
		return;
	}
}
