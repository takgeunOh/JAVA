package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class ModifyView extends View {
	
	@Override
	protected void draw() {
		
		int modify_number=0;
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();
		PhoneDTO result = new PhoneDTO();
		int modify_choice=0;
		String modify_name="";
		
		
		System.out.print("������ ��ȣ >> ");
		modify_number = scan.nextInt();
		
		for(PhoneDTO abc : list) {
			result = PhoneDAO.selectByNumber(abc);
			if((result!=null) && (result.getNumber()==modify_number)) {
				System.out.println("������ �����͸� �����ϼ���.");
				System.out.println("1)����\t2)��ȭ��ȣ\t\t3)�̸���");
				modify_choice = scan.nextInt();

				if(modify_choice==1) {
					System.out.printf("%s�� �̸� ���� >> ", result.getName());
					modify_name = scan.next();
					result.setName(modify_name);
				} else if (modify_choice==2) {
					System.out.printf("%s�� ��ȭ��ȣ ���� >> ", result.getName());
					modify_name = scan.next();
					result.setPhone(modify_name);
				} else if (modify_choice==3) {
					System.out.printf("%s�� �̸��� ���� >> ", result.getName());
					modify_name = scan.next();
					result.setEmail(modify_name);
				}
				break;
			}
		}
		
		intent.put("number", 2);
	}

}
