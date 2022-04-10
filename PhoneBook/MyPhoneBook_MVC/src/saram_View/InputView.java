package saram_View;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class InputView extends View {

	@Override
	protected void draw() {
		
		System.out.print("���� >> ");
		String name = scan.next();
		System.out.print("��ȭ��ȣ >> ");
		String phone_num = scan.next();
		System.out.print("�̸��� >> ");
		String email = scan.next();
		
		int sequence=PhoneDAO.get_sequence();
		intent.put("saramData", new PhoneDTO(sequence++, name, phone_num, email));
		PhoneDAO.set_sequence(sequence);
		// PhoneDAO.insert(PhoneDTO);
		
		intent.put("number", 1);
		// ���� �Է��� �޾����� �ٽ� �޴��� �ٷ� ���� ���� �ƴ϶� input �������� �̵��ؾ��Ѵ�.
	}
	
	
}
