package java_chapter03_practice;

import java.util.Scanner;

public class practice_05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int array[] = new int[10];
		int i;
		
		System.out.print("양의 정수 10개를 입력하시오>>");
		for(i=0;i<10;i++) {
			array[i] = scan.nextInt();
		}
		
		System.out.print("3의 배수는 ");
		for(i=0;i<10;i++) {
			if(array[i]%3==0)
				System.out.print(array[i] + " ");
		}
		
		scan.close();
	}
}
