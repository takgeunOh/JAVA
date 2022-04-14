package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;
import saram_Resource.resource;

public class DeleteView extends View {

	@Override
	protected void draw() {
		// System.out.println("��������");
		
		int delete_number;
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();
		
		// System.out.println(resource.intent.get("duplicate_cnt"));
		if((Integer)resource.intent.get("duplicate_cnt")>0) {
			System.out.print("������ DB �ε��� >> ");
			delete_number = scan.nextInt();
			
			PhoneDAO.delete(delete_number, list);
		}
		
		intent.put("number", 2);
		
	}

}
