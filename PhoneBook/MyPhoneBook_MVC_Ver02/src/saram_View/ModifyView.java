package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class ModifyView extends View {
	
	@Override
	protected void draw() {
		
		int modify_number=0;
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();
		
		System.out.print("수정할 번호 >> ");
		modify_number = scan.nextInt();

		PhoneDAO.update(modify_number, list);
		
		intent.put("number", 2);
	}

}
