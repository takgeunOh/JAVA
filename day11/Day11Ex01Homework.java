package org.comstudy21.day11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day11Ex01Homework {

	public static final Random rand = new Random();
	public static final Scanner scan = new Scanner(System.in);	// 스캔은 중간에 바뀔 일이 없으므로 상수로 선언한 것.
	public static final int SIZE = 6;
	public static final int MAX = 6;							// 필드에 선언
	
	public Day11Ex01Homework() {
		System.out.print("선택>>");
		switch(scan.nextInt()) {
		case 1 : lotto01(); break;				// 로또 첫 번째 버전
		case 2 : lotto02(); break;				// 내 방식
		case 3 : lotto03(); break;				// 로또 두 번째 버전
		case 4 : lotto04(); break;
		}
	}
	
	private void lotto04() {
		
		int[] ball = new int[MAX];
		int i;
		int num;
		
		for(i=0,num=1 ; i<MAX ; i++)
			ball[i] = num++;
		
		int[] lotto = new int[SIZE];
		int cnt=0;
		while(cnt<SIZE) {
			int index = rand.nextInt(MAX);
			if(ball[index]!=0) {
				lotto[cnt] = ball[index];
				ball[index]=0;
				cnt++;
			}
		}
		
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));

	}
	
	public void lotto03() {
		int[] lotto = new int[SIZE];
		int cnt=0;
		int number;
		
		while(cnt<SIZE) {
			number = rand.nextInt(MAX)+1;
			// 새로 생성된 number가 기존 lotto 배열에 같은 값이 있나?
			boolean flag=true;
			for(int i=0;i<cnt;i++) {
				if(lotto[i]==number) {
					flag=false;
					break;
				}
			}
			if(flag) {
				lotto[cnt] = number;
				cnt = cnt+1;
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
	
	public void lotto02() {
		int[] lotto = new int[SIZE];
		int i,j;
		int num;
		
		for(i=0;i<SIZE;i++) {
			num = rand.nextInt(MAX)+1;
			lotto[i]=num;
			for(j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		for(i=0;i<SIZE;i++)
			System.out.print(lotto[i]+ " ");
	}
	
	public void lotto01() {
		int[] lotto = new int[SIZE];
		// 1. 여섯번 반복해서 난수를 발생시킨다.
		// 2. 발생된 난수를 배열 lotto에 순서대로 저장한다.
		// 3. 발생시킨 난수가 이미 lotto에 저장된 값과 같은 값이면 다시 생성한다.
		// 4. 다시 생성한 난수를 lotto에 저장된 값들과 다시 비교한다. (index 초기화)
		
		for(int cnt=0;cnt<SIZE;cnt++) {
			lotto[cnt] = 1 + rand.nextInt(MAX);
			for(int i=0;i<cnt;i++) {
				if(lotto[i]==lotto[cnt]) {
					lotto[cnt] = 1 + rand.nextInt(MAX);
					i = -1;
				}
			}
		}
		
		System.out.println(Arrays.toString(lotto));
	}
	
	public static void main(String[] args) {
		
		new Day11Ex01Homework();

	}

}
