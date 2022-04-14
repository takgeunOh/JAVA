package saram_View;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class InputView extends View {

	@Override
	protected void draw() {
		
		System.out.print("성명 >> ");
		String name = scan.next();
		System.out.print("전화번호 >> ");
		String phone_num = scan.next();
		System.out.print("이메일 >> ");
		String email = scan.next();
		
		int sequence = PhoneDAO.getSequence();
		PhoneDTO dto = new PhoneDTO(++sequence, name, phone_num, email);
		PhoneDAO.insert(dto);
		PhoneDAO.setSequence(sequence);
		
		/*
		int sequence=PhoneDAO.getSequence();
		intent.put("saramData", new PhoneDTO(sequence++, name, phone_num, email));
		PhoneDAO.setSequence(sequence);
		// PhoneDAO.insert(PhoneDTO);
		*/
		
		intent.put("number", 0);
		// 최초 입력을 받았으면 다시 메뉴로 바로 가는 것이 아니라 input 페이지로 이동해야한다.
	}
	
	
}
