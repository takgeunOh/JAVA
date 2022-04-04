package java_chapter05_practice;


/*
 * 스택 ADT 다시 정리하기 (복습)
 * 
 * 삽입과 삭제는 LIFO 순서
 * 삽입과 삭제는 스택의 top 위치에서 수행
 * 
 * 주요 메소드
 * push(e) 원소 삽입
 * element pop() : 가장 최근에 삽입된 원소를 삭제하여 반환
 * 
 * 보조 메소드
 * element top() : 가장 최근에 삽입된 원소 반환
 * integer size() : 저장된 원소의 수 반환
 * boolean isEmpty() : 비어있는지 여부 반환
 * iterator element() : 스택 원소 전체 반환 (top부터 반환)
 * 
 * 예외처리
 * emptyStackException() : 비어있는 스택에서 삭제나 top 시도 시 발령
 * fullStackException() : 만원 스택에서 삽입 시도 시 발령 (배열로 구현 시)
 */

import java.util.Scanner;

interface Stack {
	int length();				// 현재 스택에 저장된 개수 리턴
	int capacity();				// 스택의 전체 저장 가능한 개수 리턴
	String pop();				// 스택의 탑에 실수 저장
	boolean push(String val);	// 스택의 탑에 저장된 실수 리턴(??? 이건 무슨 소리지...)
}

class StringStack implements Stack {
	// 일단 인터페이스에 선언된 모든 추상 메소드를 구현한다.
	
	String[] stack;
	int size;
	int top;
	int i;
	int flag=0;
	
	StringStack(int size) {
		this.size = size;
		top = -1;
		stack = new String[this.size];
	}
	
	@Override
	public int length() {
		return top+1;
	}
	@Override
	public int capacity() {
		return size-top;
	}
	@Override
	public String pop() {
		/*
		 * if(isEmpty()) >> 예외처리 발생
		 * 탑 하나 줄이고
		 * 탑+1 자리 반환하기
		 */
		
		// System.out.println(top);
		// System.out.println(length());
		// System.out.println(flag);
		if(top==-1 && flag==0) {
			System.out.println("현재 스택에 저장된 실수가 존재하지 않습니다.");
			return "";
		} else if (top==-1) {
			return "";
		}
		
		flag=1;
		//System.out.println(top);
		top--;
		return stack[top+1];
	}
	@Override
	public boolean push(String val) {
		// 그냥 내 방식대로 구현할 것.
		if(top==size-1) {
			return true;		// 만약에 다 차면 true 반환할 것.
		}
		
		top++;
		stack[top] = val;
		// System.out.println(top); // top 정상출력 확인
		
		return false;
	}
}
public class Chapter05_practice_09 {

	public static void main(String[] args) {
		
		int size=0;
		Scanner scan = new Scanner(System.in);
		int i;
		String input_str;
		
		StringStack stack;
		
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		size = scan.nextInt();
		stack = new StringStack(size);
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			input_str = scan.next();
			
			if(input_str.equals("그만")) {
				break;
			}
			if(stack.push(input_str)) {
				// 다 차면 true 반환하게 해놨음
				System.out.println("스택이 꽉 차서 푸시 불가!");
				continue;
			} 
		}
		
		// System.out.println(stack.length());
		if(stack.length()==0) {
			stack.pop();
		} else {
			System.out.print("스택에 저장된 모든 문자열 팝 : ");
			// System.out.println(stack.length());				// 정상 출력 확인
			for(i=0;i<stack.length()+2;i++) {
				System.out.print(stack.pop() + " ");
			}
		}

		scan.close();
	}

}
