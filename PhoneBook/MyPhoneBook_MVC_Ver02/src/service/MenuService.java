package service;

import view.MenuView;

public class MenuService implements service {

	// �θ�Ŭ������ �ڽ�Ŭ������ print() �޼ҵ带 ���� ����ϰ� �ʹ�..
	// �θ�Ŭ������ �߻�޼ҵ�� �����ϰ� �ڽ�Ŭ�������� �߻�޼ҵ带 �����ϴ� ����� ���� ����Ʈ..
	// ������ �θ� �߻����� ����ٸ� HandlerMapping�� ���ƾ���� �� �Ӹ� �ƴ϶�
	// �߿��Ѱ� �ڽ�Ŭ����(view)���� �����Ѵٴ� �� ��ü�� MVC ������ ���� ����.
	
	// �ַ�� : �θ�Ŭ������ ����ĳ������ ��.
	
	@Override
	public void requestService() {
		
		MenuService obj = new MenuView();
		((MenuView)obj).print();
		
		System.out.print("������ �۾��� �����ϼ��� >> ");
		int choice = scan.nextInt();
		
		intent.put("service", choice);
	}
	
	
}
