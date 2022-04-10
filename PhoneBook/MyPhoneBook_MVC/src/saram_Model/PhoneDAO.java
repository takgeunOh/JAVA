package saram_Model;

import java.util.ArrayList;

// DataAccessObject
// DTO를 저장할 수 있는 ArrayList를 만든다.
public class PhoneDAO {
	private static final ArrayList<PhoneDTO> pbList = new ArrayList<PhoneDTO>();
	// 이 부분은 데이터베이스로 바뀔 것이므로 외부에서 접근하지 못하게 private
	// 대상(pbList)은 바뀌지 못하게 static, 하지만 pbList 안에 들어가는 내용물은 바꿀 수 있다.
	// 바로 이 부분에 사람DTO를 적재시켜줄 것.
	
	// 다음으로는 CRUD 할 수 있게끔 메서드들을 만들어줄 것.
	private static int sequence = 1;
	static {
		
		pbList.add(new PhoneDTO(sequence++, "오탁근", "010-9480-0259", "breadmaster@naver.com"));
		pbList.add(new PhoneDTO(sequence++, "오탁근", "010-1234-5678", "takgeun92@gmail.com"));
		pbList.add(new PhoneDTO(sequence++, "홍길동", "010-1111-2222", "hong@naver.com"));
		pbList.add(new PhoneDTO(sequence++, "네이버", "010-2222-3333", "iver@naver.com"));
		pbList.add(new PhoneDTO(sequence++, "오탁근", "010-1234-2222", "takgeun48@gmail.com"));
	}
	
	public static int get_sequence() {
		return sequence;
	}
	
	public static void set_sequence(int update_sequence) {
		sequence = update_sequence;
	}
	
	public static void insert(PhoneDTO dto) {
		pbList.add(dto);
		// PhoneDTO에 저장된 정보를 pbList에 add
	}
	
	public static ArrayList<PhoneDTO> selectAll() {
		return pbList;
		// ArrayList 타입의 pbList를 반환한다.
	}
	
	public static PhoneDTO selectByNumber(PhoneDTO dto) {
		// 일치하면 그 dto 자체를 반환
		PhoneDTO result = null;
		int index = pbList.indexOf(dto);
		if(index!=-1) {
			result = pbList.get(index);
		}
		return result;
	}
	
	public void update(PhoneDTO dto) {
		int index = pbList.indexOf(dto);
		// indexOf : dto와 일치하는 pbList의 인덱스를 반환
		// 만약 일치하는 게 없으면 -1 반환
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
