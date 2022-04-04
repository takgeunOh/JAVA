package java_chapter05_practice;


/*
 * ���� ADT �ٽ� �����ϱ� (����)
 * 
 * ���԰� ������ LIFO ����
 * ���԰� ������ ������ top ��ġ���� ����
 * 
 * �ֿ� �޼ҵ�
 * push(e) ���� ����
 * element pop() : ���� �ֱٿ� ���Ե� ���Ҹ� �����Ͽ� ��ȯ
 * 
 * ���� �޼ҵ�
 * element top() : ���� �ֱٿ� ���Ե� ���� ��ȯ
 * integer size() : ����� ������ �� ��ȯ
 * boolean isEmpty() : ����ִ��� ���� ��ȯ
 * iterator element() : ���� ���� ��ü ��ȯ (top���� ��ȯ)
 * 
 * ����ó��
 * emptyStackException() : ����ִ� ���ÿ��� ������ top �õ� �� �߷�
 * fullStackException() : ���� ���ÿ��� ���� �õ� �� �߷� (�迭�� ���� ��)
 */

import java.util.Scanner;

interface Stack {
	int length();				// ���� ���ÿ� ����� ���� ����
	int capacity();				// ������ ��ü ���� ������ ���� ����
	String pop();				// ������ ž�� �Ǽ� ����
	boolean push(String val);	// ������ ž�� ����� �Ǽ� ����(??? �̰� ���� �Ҹ���...)
}

class StringStack implements Stack {
	// �ϴ� �������̽��� ����� ��� �߻� �޼ҵ带 �����Ѵ�.
	
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
		 * if(isEmpty()) >> ����ó�� �߻�
		 * ž �ϳ� ���̰�
		 * ž+1 �ڸ� ��ȯ�ϱ�
		 */
		
		// System.out.println(top);
		// System.out.println(length());
		// System.out.println(flag);
		if(top==-1 && flag==0) {
			System.out.println("���� ���ÿ� ����� �Ǽ��� �������� �ʽ��ϴ�.");
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
		// �׳� �� ��Ĵ�� ������ ��.
		if(top==size-1) {
			return true;		// ���࿡ �� ���� true ��ȯ�� ��.
		}
		
		top++;
		stack[top] = val;
		// System.out.println(top); // top ������� Ȯ��
		
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
		
		System.out.print("�� ���� ���� ������ ũ�� �Է� >> ");
		size = scan.nextInt();
		stack = new StringStack(size);
		
		while(true) {
			System.out.print("���ڿ� �Է� >> ");
			input_str = scan.next();
			
			if(input_str.equals("�׸�")) {
				break;
			}
			if(stack.push(input_str)) {
				// �� ���� true ��ȯ�ϰ� �س���
				System.out.println("������ �� ���� Ǫ�� �Ұ�!");
				continue;
			} 
		}
		
		// System.out.println(stack.length());
		if(stack.length()==0) {
			stack.pop();
		} else {
			System.out.print("���ÿ� ����� ��� ���ڿ� �� : ");
			// System.out.println(stack.length());				// ���� ��� Ȯ��
			for(i=0;i<stack.length()+2;i++) {
				System.out.print(stack.pop() + " ");
			}
		}

		scan.close();
	}

}
