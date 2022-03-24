package java_chapter03_practice;

import java.util.Scanner;

public class practice_08 {

	public static void main(String[] args) {
		
		int count;
		Scanner scan = new Scanner(System.in);
		int arr[];
		int i,j;
		
		System.out.print("정수 몇 개?");
		count = scan.nextInt();
		arr = new int[count];
		
		for(i=0;i<count;i++) {
			arr[i] = (int)(Math.random()*100+1);
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
			}
		}
		
		for(i=0;i<count;i++) {
			System.out.print(arr[i] + " ");
			if(i%10==0)
				System.out.println();
		}
		
		scan.close();
	}

}
