package saram_View;

public class MenuView extends View {

	@Override
	protected void draw() {
		int number;
		
		System.out.println("1)INPUT 2)OUTPUT 3)SEARCH 4)MODIFY 5)DELETE 6)END");
		System.out.print("Choice >> ");
		number = scan.nextInt();
		if(number == 1) {
			// �Է� �ޱ� �� ��������� ������ �ʱ�ȭ�� ��
			intent.put("saramData", null);
		}
		intent.put("number", number);
	}
	
}
