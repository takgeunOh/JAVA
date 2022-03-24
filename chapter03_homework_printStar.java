package java_chapter03_practice;

public class chapter03_homework_printStar {

	/*
	 * 주말 과제 오픈챌린지, 연습문제, 실습문제, 수업시간 별찍기
	 * 
	 */
	public static void main(String[] args) {
		// ^^^^*
		// ^^^**
		// ^^***
		// ^****
		// *****

		int i, j;

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5 - i - 1; j++)
				System.out.print("^");
			for (j = 0; j < i + 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void test3(String[] args) {

		// *
		// **
		// ***
		// ****
		// *****
		// ****
		// ***
		// **
		// *

		int i, j;

		for (i = 0; i < 9; i++) {
			if (i < 5) {
				for (j = 0; j < i + 1; j++)
					System.out.print("*");
			} else {
				for (j = 0; j < 9 - i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public static void test2(String[] args) {
		// *****
		// ****
		// ***
		// **
		// *

		int i, j;

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5 - i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void test(String[] args) {

		// *
		// **
		// ***
		// ****
		// *****
		int i, j;

		for (i = 0; i < 5; i++) {
			for (j = 0; j < i + 1; j++)
				System.out.print("*");
			System.out.println("");
		}
	}

}
