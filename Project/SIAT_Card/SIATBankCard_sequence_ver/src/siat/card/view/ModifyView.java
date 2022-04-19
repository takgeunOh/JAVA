package siat.card.view;

import resource.R;
import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class ModifyView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		int choice;
		String cardName, cardType, profit;
		int annualFee, cardRecord;
		
		System.out.print("������ ���ϴ� ��ȣ�� �Է����ּ���. >> ");
		// ������ �ߺ��̸��� �� ó�� ī���� �� �ߺ�üũ�� ���̱� ������ ���⼱ �Ű� �� �ᵵ �ɵ�
		choice = scan.nextInt();
		
		if(intent.get("modify_check")!=null) {
			System.out.println("�˻��Ͻ� ��ȣ�� �������� �ʽ��ϴ�.");
			intent.put("menu", 0);
			return;
		}
		
		System.out.print("ī�� �̸� ���� >> ");
		cardName = scan.next();
		System.out.print("ī�� Ÿ�� ���� >> ");
		cardType = scan.next();
		System.out.print("��ȸ�� ���� >> ");
		annualFee = scan.nextInt();
		System.out.print("ī����� ���� >> ");
		cardRecord = scan.nextInt();
		System.out.print("���� ���� >> ");
		profit = scan.next();
		
		// intent.put("modifyData", new CardDto(choice, cardName, cardType, annualFee, cardRecord, profit));
		CardDao.modify(new CardDto(choice, cardName, cardType, annualFee, cardRecord, profit));
		intent.put("menu", 2);
		intent.put("modify_check", null);
	}

}
