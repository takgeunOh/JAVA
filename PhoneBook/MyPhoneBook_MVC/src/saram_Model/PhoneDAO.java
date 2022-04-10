package saram_Model;

import java.util.ArrayList;

// DataAccessObject
// DTO�� ������ �� �ִ� ArrayList�� �����.
public class PhoneDAO {
	private static final ArrayList<PhoneDTO> pbList = new ArrayList<PhoneDTO>();
	// �� �κ��� �����ͺ��̽��� �ٲ� ���̹Ƿ� �ܺο��� �������� ���ϰ� private
	// ���(pbList)�� �ٲ��� ���ϰ� static, ������ pbList �ȿ� ���� ���빰�� �ٲ� �� �ִ�.
	// �ٷ� �� �κп� ���DTO�� ��������� ��.
	
	// �������δ� CRUD �� �� �ְԲ� �޼������ ������� ��.
	private static int sequence = 1;
	static {
		
		pbList.add(new PhoneDTO(sequence++, "��Ź��", "010-9480-0259", "breadmaster@naver.com"));
		pbList.add(new PhoneDTO(sequence++, "��Ź��", "010-1234-5678", "takgeun92@gmail.com"));
		pbList.add(new PhoneDTO(sequence++, "ȫ�浿", "010-1111-2222", "hong@naver.com"));
		pbList.add(new PhoneDTO(sequence++, "���̹�", "010-2222-3333", "iver@naver.com"));
		pbList.add(new PhoneDTO(sequence++, "��Ź��", "010-1234-2222", "takgeun48@gmail.com"));
	}
	
	public static int get_sequence() {
		return sequence;
	}
	
	public static void set_sequence(int update_sequence) {
		sequence = update_sequence;
	}
	
	public static void insert(PhoneDTO dto) {
		pbList.add(dto);
		// PhoneDTO�� ����� ������ pbList�� add
	}
	
	public static ArrayList<PhoneDTO> selectAll() {
		return pbList;
		// ArrayList Ÿ���� pbList�� ��ȯ�Ѵ�.
	}
	
	public static PhoneDTO selectByNumber(PhoneDTO dto) {
		// ��ġ�ϸ� �� dto ��ü�� ��ȯ
		PhoneDTO result = null;
		int index = pbList.indexOf(dto);
		if(index!=-1) {
			result = pbList.get(index);
		}
		return result;
	}
	
	public void update(PhoneDTO dto) {
		int index = pbList.indexOf(dto);
		// indexOf : dto�� ��ġ�ϴ� pbList�� �ε����� ��ȯ
		// ���� ��ġ�ϴ� �� ������ -1 ��ȯ
		if(index!=-1) {
			pbList.set(index, dto);
		}
	}
	
	public static void delete(PhoneDTO dto) {
		int index = pbList.indexOf(dto);
		if(index!=-1) {
			pbList.remove(index);
		}
	}
}
