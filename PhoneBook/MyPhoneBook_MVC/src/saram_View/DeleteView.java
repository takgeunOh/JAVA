package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class DeleteView extends View {

	@Override
	protected void draw() {
		// System.out.println("��������");
		
		int delete_number;
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();
		PhoneDTO result;
		int re_sequence=1;
		
		System.out.print("������ ��ȣ >> ");
		delete_number = scan.nextInt();
		
		for(PhoneDTO abc : list) {
			result = PhoneDAO.selectByNumber(abc);
			if((result!=null) && (result.getNumber()==delete_number)) {
				PhoneDAO.delete(result);
				break;
				// break �����ָ� remove ȣ��� ���� �پ�� ����� ���� ����.
				// �� ��� ConcurrentModificationException �߻�.
				// �ַ� �÷����� delete�� for������ ����� �� �߻�
				// �����ϴ� ������δ� Iterator�� ����϶�� ��.
			}
		}
		
		// ���� �۾� �� ��ȣ �������� �ʿ���
		for(PhoneDTO abc : list) {
			abc.setNumber(re_sequence++);
		}
		
		
		intent.put("number", 2);
		
	}

}
