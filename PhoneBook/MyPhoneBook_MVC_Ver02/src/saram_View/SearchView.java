package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;
import saram_Resource.resource;

public class SearchView extends View {

	@Override
	protected void draw() {
		int count=0;
		
		// ������ �� ������ �� �޴��� �̵��ϱ�
		System.out.print("�˻��� �̸��� �Է����ּ���. >> ");
		String search_name = scan.next();
		
		/*
		PhoneDTO dto = new PhoneDTO();
		System.out.println(dto.getName());
		
		 * �� ����� ������ �ʴ´�.
		 * �Է� ���� �� DTO�� �ʱ�ȭ���ѹ����� dto�ʿ��� �����͸� ���� �� ���⵵ �ϰ�
		 * �迭����Ʈ�� pbList ��ο� ������ �� �ִ� ����� �ƴ�.
		*/
		
		// �ᱹ�� pbList�� ����ؾ��� �� ����.
		// PhoneDTO Ÿ���� ���������� PhoneDAO�� selectByNumber �޼ҵ带 �̿��غ��ٸ�
		PhoneDTO result = new PhoneDTO();
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();	// ���� ����� pbList ��� �ҷ�����
		ArrayList<PhoneDTO> duplicate_array = new ArrayList<PhoneDTO>();
		
		duplicate_array = PhoneDAO.selectByNumber(search_name, list);
		// �˻��� �̸��� ��ü ����� ������.
		
		/*
		for(PhoneDTO abc : list) {
			result = PhoneDAO.selectByNumber(abc);
			if((result!=null) && (result.getName().equals(search_name))) {
				duplicate_array.add(result);		
				count++;
			}
		}*/
		
		// �˻������� ��ġ�ϴ� �����͸� result�� ���� ����
		if((Integer)resource.intent.get("duplicate_cnt")==0)
			System.out.println("!! ã���ô� �̸��� �����Ϳ� �������� �ʽ��ϴ�. !!\n");
		else if ((Integer)resource.intent.get("duplicate_cnt")>0) {
			System.out.println("\n>> ã���ô� �̸��� �����Ϳ� �����մϴ�. <<\n");
		}
		
		if(intent.get("search_check")==null)
			intent.put("number", 0);
		else if((Integer)intent.get("search_check")==0)
			intent.put("number", 4);
		else if ((Integer)intent.get("search_check")==1)
			intent.put("number", 5);
	}
	
}
