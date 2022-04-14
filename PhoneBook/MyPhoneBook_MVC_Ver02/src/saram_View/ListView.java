package saram_View;

import java.util.ArrayList;

import saram_Model.PhoneDAO;
import saram_Model.PhoneDTO;

public class ListView extends View {

	@Override
	protected void draw() {
		
		System.out.println("번호\t성명\t\t전화번호\t\t이메일");
		ArrayList<PhoneDTO> list = PhoneDAO.selectAll();
		for(PhoneDTO abc : list) {
			System.out.println(abc);
		}
		System.out.println();
		intent.put("number", 0);
	}
}
