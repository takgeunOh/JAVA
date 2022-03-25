package org.comstudy21.day12.ex09_02;

public class Ch03Ex09_02 {
	
	public Ch03Ex09_02() {
		ex09_02();
	}
	
	public void ex09_02() {
		int i,j;
		int[][] arr = new int[4][4];				// 0으로 초기화되어있음.
		int[] cnt_check = new int[8];				// 중복 숫자 체크용
		int num;
		
		for(i=0;i<4;i++) {							// 인덱스는 [0][0] 부터 순서대로 집어넣을건데
			for(j=0;j<4;j++) {
				// System.out.println(j);
				if(arr[i][j]==0) {
					num = (int)(Math.random()*8+1);
					if(cnt_check[num-1]<2) {				// 랜덤하게 나온 숫자가 두 번 나오지 않았을 때마다 값 넣을 것.
						arr[i][j] = num;
						cnt_check[num-1]++;
					} else {
						j--;						// 2번 나온 애면 다시 시작.
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
