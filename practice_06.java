package java_chapter03_practice;

import java.util.Scanner;

public class practice_06 {

	public static void main(String[] args) {
		
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		Scanner scan = new Scanner(System.in);
		int input_money;
		int i;
		int temp;
		
		System.out.print("금액을 입력하시오>>");
		input_money = scan.nextInt();
		temp = input_money;
		
		for(i=0;i<unit.length;i++) {
			if(temp/unit[i]==0)
				continue;
			System.out.println(unit[i] + "원 짜리 : " + temp/unit[i] + "개");
			temp = temp % unit[i];
		}
		
		scan.close();
	}
}
