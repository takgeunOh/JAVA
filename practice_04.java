package java_chapter03_practice;

import java.util.Scanner;

public class practice_04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		char input_ch;
		int i;
		char j;
		
		System.out.print("�ҹ��� ���ĺ� �ϳ��� �Է��Ͻÿ�>>");
		input_ch = scan.next().charAt(0);
		
		for(i=0;i<=input_ch-'a';i++) {
			for(j='a';j<=input_ch-i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
