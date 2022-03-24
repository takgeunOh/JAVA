package java_chapter03_practice;

public class DoWhileTest {

	public static void main(String[] args) {
		
		int sum=0, i=0;
		
		do {
			sum = sum + i;
			i = i+2;
		} while(i<100);
		
		System.out.println(sum);
	}

}
