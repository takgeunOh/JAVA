package saram_View;

public class MenuView extends View {

	@Override
	protected void draw() {
		int number;
		
		System.out.println("1)INPUT 2)OUTPUT 3)SEARCH 4)MODIFY 5)DELETE 6)END");
		System.out.print("Choice >> ");
		number = scan.nextInt();
		if(number == 1) {
			// 입력 받기 전 사람데이터 완전히 초기화할 것
			intent.put("saramData", null);
		}
		intent.put("number", number);
	}
	
}
