package siat.card.view;

import resource.R;

public class MenuView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		int choice;
		
		System.out.printf(":::::::::: ��ȸ�� ���񽺸� �������ּ���. ::::::::::\n", viewTitle);
		System.out.printf("1)ī����\t2)ī����ȸ\t3)ī��˻�\t4)ī�����\t5)ī�����\t6)��������\n");
		System.out.print("���� ���� >> ");
		choice = scan.nextInt();
		
		intent.put("menu", choice);
	}

}
