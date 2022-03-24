package org.comstudy21.day11;

public class Day11Homework_01 {
	
	static int[][] arr = new int[5][5];
	
	public static void main(String[] args) {
		// 1	2	3	4	5
		// 		6	7	8
		//			9
		// 		10	11	12
		// 13	14	15	16	17
		
		int number=1;
		for(int i=0;i<arr.length;i++) {
			if(i<3) {
				for(int j=i;j<arr[i].length-i;j++)
					arr[i][j]=number++;
			} else {
				for(int j=arr[i].length-i-1;j<arr[i].length+i-(arr[i].length-1);j++) {
					arr[i][j]=number++;
				}
			}
		}
		// Ãâ·Â
		printArr();
	}

	public static void printArr() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]!=0? arr[i][j] + "\t" : "\t");
			}
			System.out.println();
		}
	}
}
