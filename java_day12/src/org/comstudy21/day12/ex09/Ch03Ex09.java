package org.comstudy21.day12.ex09;

public class Ch03Ex09 {
	
	public Ch03Ex09() {
		ex09();
	}
	
	public void ex09() {
		int[][] arr = new int[4][4];			// �迭 �غ� �Ϸ�
		int i,j;
		
		//  1~10 ������ ������ ���ڸ� arr�迭�� ������� ����
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++)
				arr[i][j] = (int)(Math.random()*10+1);
		}
		// arr�迭�� ������ ����Ѵ�.
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		new Ch03Ex09();

	}

}
