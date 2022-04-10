package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class DeleteView extends View {

	@Override
	protected void draw() {
		// System.out.println("삭제삭제");
		
		int delete_number;
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();
		PhoneDTO result;
		int re_sequence=1;
		
		System.out.print("삭제할 번호 >> ");
		delete_number = scan.nextInt();
		
		for(PhoneDTO abc : list) {
			result = PhoneDAO.selectByNumber(abc);
			if((result!=null) && (result.getNumber()==delete_number)) {
				PhoneDAO.delete(result);
				break;
				// break 안해주면 remove 호출로 인해 줄어든 사이즈가 맞지 않음.
				// 그 결과 ConcurrentModificationException 발생.
				// 주로 컬렉션의 delete를 for문에서 사용할 떄 발생
				// 권장하는 방법으로는 Iterator를 사용하라고 함.
			}
		}
		
		// 삭제 작업 후 번호 재정렬이 필요함
		for(PhoneDTO abc : list) {
			abc.setNumber(re_sequence++);
		}
		
		
		intent.put("number", 2);
		
	}

}
