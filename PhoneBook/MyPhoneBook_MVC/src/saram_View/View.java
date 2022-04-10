package saram_View;

import saram_Resource.resource;

public abstract class View implements resource {
	public void display(String viewTitle) {
		System.out.printf(":::::::: %s ::::::::\n", viewTitle);
		draw();
		// draw는 요청서비스에 맞는 View에서 구현하기
	}

	protected abstract void draw();
}
