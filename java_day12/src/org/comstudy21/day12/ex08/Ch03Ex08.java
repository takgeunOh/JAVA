package org.comstudy21.day12.ex08;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03Ex08 {
	Scanner scan = new Scanner(System.in);
	int [] arr;					// �ϴ� ������ ���ϰ� ���������� �����.
	int size;					// �ʵ忡���� �⺻������ 0���� �ʱ�ȭ. �ٸ� �������������� �����Ⱚ�� ����.
	
	public Ch03Ex08() {
		ex08();
	}
	
	public void ex08() {
		// ��ȿ�� �˻�(1~100 ��������?)
		// ������ ���ڸ� �迭�� ����
		// �ߺ��˻�
		// �迭�� ���� ���
		// 10�� 15�б���
		int i,j;
		
		
		System.out.print("������ �迭 ����� �� �Է�(1~100 ����) >>>");
		size = scan.nextInt();
		
		// ��ȿ�� �˻�
		while(size<1 || size>100) {
			System.out.print("��ȿ�� ������ ���� �ƴմϴ�. �ٽ� �Է��ϼ���. >>>");
			size = scan.nextInt();
		}
		
		arr = new int[size];				// �ٷ� ������ size�� �Է� �޾Ƽ� size��ŭ �迭�� ũ�⸦ ���ϰ� �迭 ����.
		
		// ������ ���ڸ� �迭�� ���� + �ߺ��˻�
		for(i=0;i<size;i++) {
			arr[i] = (int)(Math.random()*100 + 1);
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(arr);
		for(i=0;i<size;i++)
			//System.out.print(arr[i] + " ");
			System.out.printf("%d%c", arr[i], (i+1)%10==0 ? '\n':'\t');			// ��Ʈ�ʱ��ϱ�
		// ��ȯ ���ڿ� : %c, %d, %i(integer), %f, %o(8����), %x(16����) ...
		
		// �ָ��� ������Ÿ�� ũ�� ������ ��.
		// ĳ���͵� ���� Ÿ��.
	}

	public static void main(String[] args) {
		
		new Ch03Ex08();

	}

}
