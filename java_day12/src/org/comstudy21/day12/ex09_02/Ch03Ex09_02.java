package org.comstudy21.day12.ex09_02;

public class Ch03Ex09_02 {
	
	public Ch03Ex09_02() {
		ex09_02();
	}
	
	public void ex09_02() {
		int i,j;
		int[][] arr = new int[4][4];				// 0���� �ʱ�ȭ�Ǿ�����.
		int[] cnt_check = new int[8];				// �ߺ� ���� üũ��
		int num;
		
		for(i=0;i<4;i++) {							// �ε����� [0][0] ���� ������� ��������ǵ�
			for(j=0;j<4;j++) {
				// System.out.println(j);
				if(arr[i][j]==0) {
					num = (int)(Math.random()*8+1);
					if(cnt_check[num-1]<2) {				// �����ϰ� ���� ���ڰ� �� �� ������ �ʾ��� ������ �� ���� ��.
						arr[i][j] = num;
						cnt_check[num-1]++;
					} else {
						j--;						// 2�� ���� �ָ� �ٽ� ����.
					}
				}
			}
		}
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		new Ch03Ex09_02();

	}

}
