package java_chapter03_practice;

// import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		
		int sum=0;
		int i;
		
		for(i=0;i<args.length;i++) {
			sum = sum + Integer.parseInt(args[i]);
		}
		
		if(args.length>0)
			System.out.println(sum/args.length);

	}

}
