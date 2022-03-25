package org.comstudy21.day12.ex09;

public class Ch03Ex09 {
	
	public Ch03Ex09() {
		ex09();
	}
	
	public void ex09() {
		int[][] arr = new int[4][4];			// 배열 준비 완료
		int i,j;
		
		//  1~10 사이의 랜덤한 숫자를 arr배열에 순서대로 저장
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++)
				arr[i][j] = (int)(Math.random()*10+1);
		}
		// arr배열의 내용을 출력한다.
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
