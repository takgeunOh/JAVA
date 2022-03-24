package java_chapter03_practice;

public class practice_09 {

	public static void main(String[] args) {
		
		int arr[][] = new int[4][4];
		int i,j;
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++) {
				arr[i][j] = (int)(Math.random()*10 + 1);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
