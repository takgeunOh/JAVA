package java_chapter03_practice;

import java.util.Scanner;

public class practice_03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int input_number;
		int i,j;
		
		System.out.print("������ �Է��Ͻÿ�>>");
		input_number = scan.nextInt();
		
		for(i=0;i<input_number;i++) {
			for(j=0;j<input_number-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		scan.close();
	}

}
