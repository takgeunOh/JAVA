package java_chapter03_practice;
import java.util.Random;
import java.util.Scanner;

public class Open_Challenge {

	public static void main(String[] args) {
	
		int count=1;
		Scanner scan = new Scanner(System.in);
		int input_number;
		int start_number=0, end_number=99;
		char choice=0;
		
		/* r.nextInt(100) 의 값 범위 확인용
		while(true) {
			System.out.println(k);
			if(k>=99)
				break;
			r = new Random();
			k = r.nextInt(100);
		}
		*/
		
		Random r = new Random();
		int k = r.nextInt(100);
		
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		System.out.println(start_number + "-" + end_number);
		
		while(true) {
			System.out.printf("%d>>", count);
			input_number = scan.nextInt();
			
			if(k>input_number) {
				System.out.println("더 높게");
				start_number = input_number;
				System.out.println(start_number + "-" + end_number);
			} else if (k<input_number) {
				System.out.println("더 낮게");
				end_number = input_number;
				System.out.println(start_number + "-" + end_number);
			} else {
				count=0;
				System.out.println("맞았습니다.");
				System.out.print("다시 하시겠습니까(y/n)>>");
				choice = scan.next().charAt(0);
				
				if(choice=='y') {
					r = new Random();
					k = r.nextInt(100);
					
					System.out.println("수를 결정하였습니다. 맞추어 보세요");
					System.out.println("0-99");
				} else if (choice=='n') {
					break;
				}
			}
			count++;
		}
		
		
		scan.close();
	}

}
