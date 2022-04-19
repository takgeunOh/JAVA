package siat.card.view;

public class EndView extends View {

	@Override
	public void display(String viewTitle) {
		
		System.out.println("\n카드 조회 서비스를 종료합니다.");
		System.out.println("이용해주셔서 감사합니다.");
		
		System.exit(0);
	}

}
