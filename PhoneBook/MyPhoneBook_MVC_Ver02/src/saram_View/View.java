package saram_View;

import saram_Resource.resource;

public abstract class View implements resource {
	public void display(String viewTitle) {
		System.out.printf(":::::::: %s ::::::::\n", viewTitle);
		draw();
		// draw�� ��û���񽺿� �´� View���� �����ϱ�
	}

	protected abstract void draw();
}
