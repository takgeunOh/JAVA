package org.comstudy21.day12.ex08;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03Ex08 {
	Scanner scan = new Scanner(System.in);
	int [] arr;					// 일단 선언을 안하고 참조변수를 만든다.
	int size;					// 필드에서는 기본적으로 0으로 초기화. 다만 지역변수에서는 쓰레기값이 들어간다.
	
	public Ch03Ex08() {
		ex08();
	}
	
	public void ex08() {
		// 유효성 검사(1~100 사이인지?)
		// 랜덤한 숫자를 배열에 저장
		// 중복검사
		// 배열의 내용 출력
		// 10시 15분까지
		int i,j;
		
		
		System.out.print("생성할 배열 요소의 수 입력(1~100 사이) >>>");
		size = scan.nextInt();
		
		// 유효성 검사
		while(size<1 || size>100) {
			System.out.print("유효한 범위의 값이 아닙니다. 다시 입력하세요. >>>");
			size = scan.nextInt();
		}
		
		arr = new int[size];				// 바로 위에서 size를 입력 받아서 size만큼 배열의 크기를 정하고 배열 생성.
		
		// 랜덤한 숫자를 배열에 저장 + 중복검사
		for(i=0;i<size;i++) {
			arr[i] = (int)(Math.random()*100 + 1);
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(arr);
		for(i=0;i<size;i++)
			//System.out.print(arr[i] + " ");
			System.out.printf("%d%c", arr[i], (i+1)%10==0 ? '\n':'\t');			// 노트필기하기
		// 변환 문자열 : %c, %d, %i(integer), %f, %o(8진수), %x(16진수) ...
		
		// 주말에 데이터타입 크기 복습할 것.
		// 캐릭터도 정수 타입.
	}

	public static void main(String[] args) {
		
		new Ch03Ex08();

	}

}
