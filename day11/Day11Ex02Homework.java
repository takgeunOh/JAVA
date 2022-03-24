package org.comstudy21.day11;
import java.util.Scanner;

public class Day11Ex02Homework {

	// 필드 만들기
	public static final int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static final Scanner scan = new Scanner(System.in);		// 수정할 일이 없으면 이렇게 final 붙이면 된다.
	int month, day, total, nextMonth, nextDay;		// 필드 int(정수형 필드)일 때는 자동으로 0으로 초기화된다. 필드는 함수 밖을 말하는 것
	// 실전에서는 Date 클래스나 Calendar 클래스를 사용하면 편리하다.
	
	public Day11Ex02Homework() {
		findDay();
	}
	
	public void findDay() {
		System.out.print("월/일 입력 >>");
		month = scan.nextInt();
		day = scan.nextInt();
		System.out.print(month+"월 "+day+"일의 100일 후는");
		
		// 반복한다.
		// total = 100 - (현재 월의 남은 날짜);
		total = 100 - (days[month-1]-day);
		int i = month % 12;			// 다음달 인덱스
		while(total>days[i]) {
			total = total - days[i];
			i++;
			i%=12;
		}
		// 위 반복문을 통과했다면 i+1월에 total일이 출력이 되는 것이다.
		nextMonth = i+1;
		nextDay = total;
		System.out.println(nextMonth + "월 " + nextDay + "일입니다.");
	}
	
	public static void main(String[] args) {
		
		new Day11Ex02Homework();

	}

}
