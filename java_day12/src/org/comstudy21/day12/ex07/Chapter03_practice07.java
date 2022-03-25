package org.comstudy21.day12.ex07;

import java.util.Arrays;

public class Chapter03_practice07 {

	
	public Chapter03_practice07() {
		
		ex11();
	}
	
	public void ex11() {
		final int SIZE = 10;				// �������� ����
		final int MAX = 100;
		int[] arr = new int[SIZE];
		double avg = 0.0;
		// ������ ���� 10���� �迭�� �����ϰ� ����� ����ؼ� ����Ѵ�.
		int i,j;
		int sum=0;
		
		
		for(i=0;i<SIZE;i++) {						
			// SIZE�� ���� ȿ������ ����
			// 1. ���� ���Ǽ�
			// 2. arr : ���������ϱ� ���� ���������. ���������� ���ÿ� ��������µ� ������ �ӵ��� �����ٴ� ������.
			// arr.length�� ���ٸ� �ݺ��� �ϸ鼭 ���� �ִ� ���� ��� �����ϴϱ� ���� �鿡�� ȿ�����̱� �����̴�. (��� : ������ ������ ������.)
			arr[i] = (int)(Math.random()*MAX+1);		// ���� ĳ���� �ʿ�
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					arr[i] = (int)(Math.random()*MAX+1);
					j = -1;
				}
			}
			sum = sum + arr[i];
		}
		avg = (double)sum / (double)SIZE;			// �� �� double�� �ִ� ���� ���� ����!
		
		System.out.println("�迭�� ����� ���� ");
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));	// ���ϰ� �迭�� ����ϴ� ���
		for(i=0;i<SIZE;i++)
			System.out.print(arr[i] + " ");
		System.out.println("�̸�," + "\n" + "����� " + avg + "�Դϴ�.");
	}

	public static void main(String[] args) {
		
		new Chapter03_practice07();

	}

}
