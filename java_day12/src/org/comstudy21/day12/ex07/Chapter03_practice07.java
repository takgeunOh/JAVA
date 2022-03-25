package org.comstudy21.day12.ex07;

import java.util.Arrays;

public class Chapter03_practice07 {

	
	public Chapter03_practice07() {
		
		ex11();
	}
	
	public void ex11() {
		final int SIZE = 10;				// 지역변수 선언
		final int MAX = 100;
		int[] arr = new int[SIZE];
		double avg = 0.0;
		// 랜덤한 숫자 10개를 배열에 저장하고 평균을 계산해서 출력한다.
		int i,j;
		int sum=0;
		
		
		for(i=0;i<SIZE;i++) {						
			// SIZE를 쓰면 효율적인 이유
			// 1. 개발 편의성
			// 2. arr : 참조변수니까 힙에 만들어진다. 지역변수는 스택에 만들어지는데 스택의 속도가 힙보다는 빠르다.
			// arr.length를 쓴다면 반복을 하면서 힙에 있는 것을 계속 참조하니까 성능 면에서 효율적이기 때문이다. (요약 : 스택이 힙보다 빠르다.)
			arr[i] = (int)(Math.random()*MAX+1);		// 정수 캐스팅 필요
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					arr[i] = (int)(Math.random()*MAX+1);
					j = -1;
				}
			}
			sum = sum + arr[i];
		}
		avg = (double)sum / (double)SIZE;			// 둘 다 double로 주는 것이 원래 정석!
		
		System.out.println("배열에 저장된 수는 ");
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));	// 편하게 배열을 출력하는 방법
		for(i=0;i<SIZE;i++)
			System.out.print(arr[i] + " ");
		System.out.println("이며," + "\n" + "평균은 " + avg + "입니다.");
	}

	public static void main(String[] args) {
		
		new Chapter03_practice07();

	}

}
