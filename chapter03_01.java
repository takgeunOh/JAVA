package java_chapter03_practice;

public class chapter03_01 {

	public static class WhileTest {
		public static void main(String[] args) {
			
			int sum=0, i=0;
			
			while(i<100) {
				sum = sum + i;
				i += 2;
			}
			System.out.println(sum);
		}
	}

}
