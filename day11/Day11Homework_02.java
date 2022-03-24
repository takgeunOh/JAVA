package org.comstudy21.day11;

public class Day11Homework_02 {

	static int[][] arr = new int[5][5];
	
	public static void main(String[] args) {
		// 1	2	3	4	5
		// 16	17	18	19	6
		// 15	24	25	20	7
		// 14	23	22	21	8
		// 13	12	11	10	9
		
		// 열과 행이 끝에 다다를 때마다 해당 열과 행을 임시 변수에 저장하고
		// 다음 반복 때 임시변수-1만큼 행과 열을 반복해주면 될 것 같다.
		// 짝수번째 반복일 때 행방향 증가, 홀수번째 반복일 때 열방향 증가
		// 어떤 케이스에서는 행만 증가하고, 어떤 케이스에서는 열만 증가하고
		// 멈추는 것도 케이스가 있죠? 뭐 다음 칸에 값이 들어있으면 다음 케이스로 넘어가게끔
		// 4가지 케이스 : 열 증가, 행 증가, 열 감소, 행 감소
		
		
		int number=1;
		int i=0,j=0;
		int start_i=0, start_j=0;
		int direction=0;		// 0일 때 행 방향 증가, 1일 때 열 방향 증가, 2일 때 행 방향 감소, 3일 때 열 방향 감소
		int flag=0;
		
		while(true) {
			//System.out.println(number);
			for(i=0;i<arr.length;i++) {					// 들어가지 않은 숫자가 있는지 판별
				for(j=0;j<arr[i].length;j++)
				{
					if(arr[i][j]==0) {					// 배열 요소 중 0이 하나라도 존재하면 바로 flag=1 주고 판별 반복문 종료
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			
			/*
			if(number>25)
				break;
			*/
			
			// 모든 반복문 종료 판별 업그레이드
			if(flag==0)									// 만약 들어가지 않은 숫자가 하나도 없다면(즉, 0인 요소가 하나도 없다면) 모든 반복문을 중단한다.
				break;
			
			if(direction==0) {
				// 행 방향 증가일 때
				for(j=start_i;j<5;j++) {
					if(arr[start_i][j]!=0)
						break;
					arr[start_i][j] = number;
					//System.out.println(number);
					number++;
				}
			} else if (direction==1) {
				// 열 방향 증가일 떄
				//System.out.println(start_i);
				//System.out.println(start_j);
				//System.out.println(i);
				for(i=start_i;i<5;i++) {
					if(arr[i][start_j]!=0)
						break;
					arr[i][start_j]=number;
					//System.out.println(number);
					number++;
				}
			} else if (direction==2) {
				// 행 방향 감소일 때
				for(j=start_j;j>=0;j--) {
					if(arr[start_i][j]!=0)
						break;
					arr[start_i][j]=number;
					//System.out.println(number);
					number++;
				}
			} else if (direction==3) {
				// 열 방향 감소일 때
				for(i=start_i;i>=0;i--) {
					if(arr[i][start_j]!=0)
						break;
					arr[i][start_j]=number;
					// System.out.println(number);
					number++;
				}
			}
			
			if(direction==0) {
				direction=1;
				start_i++;
				start_j=j-1;
			} else if (direction==1) {
				direction=2;
				start_i=i-1;
				start_j--;
			} else if (direction==2) {
				direction=3;
				start_i--;
				start_j=j+1;
			} else if (direction==3) {
				direction=0;
				start_i=i+1;
				start_j++;
			}
			flag=0;
		}
		// 출력
		printArr();
	}

	public static void printArr() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]!=0? arr[i][j] + "\t" : "\t");
			}
			System.out.println();
		}
	}
}
