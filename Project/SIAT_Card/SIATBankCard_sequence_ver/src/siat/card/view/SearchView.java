package siat.card.view;

import resource.R;
import siat.card.model.CardDao;
import siat.card.model.CardDto;

public class SearchView extends View implements R {

	@Override
	public void display(String viewTitle) {
		
		String search_name;
		System.out.println("��ȸ(�۾�)�� ī�� �̸��� �Է����ּ���.");
		search_name = scan.next();
		
		CardDto result = CardDao.selectOne(search_name);
		
		System.out.println(result);
		if(result!=null) {
			System.out.println("\n�˻��Ͻ� ī���� ������ ������ �����ϴ�.");
			System.out.println(result.toString());
			System.out.println();
			// intent.put("search_check", 1);
		} else {
			System.out.println("\n�˻��Ͻ� ī��� �����Ϳ� �������� �ʽ��ϴ�.\n");
			intent.put("menu", 0);
			intent.put("search_check", null);
			return;
		}
		
		if(intent.get("search_check")==null)
			intent.put("menu", 0);				// ī��˻��� ���� ���
		else if ((Integer)intent.get("search_check")==0) {
			intent.put("menu", 4);				// �����۾��� ���� �˻��۾����� ������ �� �˻� �Ϸ� �Ŀ��� ��ٷ� ���� �۾����� ���ư���
			intent.put("modifyData", result);
		} else if ((Integer)intent.get("search_check")==1) {
			intent.put("menu", 5);				// �����۾��� ���� �˻��۾����� ������ �� �˻� �Ϸ� �Ŀ��� ��ٷ� ���� �۾����� ����
			intent.put("deleteData", result);
		}
		
		intent.put("notExistDataCheck", null);
		// intent.put("search_check", null);
	}

}
