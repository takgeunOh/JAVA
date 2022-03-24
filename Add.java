package java_chapter03_practice;

public class Add {

	public static void main(String[] args) {
		
		
		// try { 예외가 발생할 가능성이 있는 실행문(try 블록) }
		// catch (처리할 예외 타입 선언) { 예외 처리문(catch 블록) }
		// finally { 예외 발생 여부와 상관없이 무조건 실행되는 문장 (finally 블록) }
		
		int sum=0;
		int i;
		
		for(i=0;i<args.length;i++) {
			try {
				sum = sum + Integer.parseInt(args[i]);
			} catch(NumberFormatException e) {
				// 문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발
				continue;
			}
		}
		
		System.out.println(sum);

	}

}
