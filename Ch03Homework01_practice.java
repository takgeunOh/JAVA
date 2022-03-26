package day12.homework;

import java.util.Scanner;

public class Ch03Homework01_practice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		char cor_arr[][] = new char[4][4];
		int num_arr[][] = new int[4][4];
		int i,j;
		int count=1;			// 행, 열 추적할 때 쓰는 용도
		int count2=0;			// 카드 2개 찍었을 때 정답여부 검사 시작하는 기준을 정하는 용도
		int count3=0;			// 카드 2개 맞췄을 떄 정답카운트 올리는 용도 (8이 되면 종료되게 할 것임)
		int row, col;
		int choice1, choice2;
		int save_row=0, save_col=0, save_row2=0, save_col2=0;
		int flag=0;
		int temp1=0, temp2=0;
		char save_char1=0, save_char2=0;
		
		// 1	2	3	4
		// 5	6	7	8
		// 9	10	11	12
		// 13	14	15	16
		for(i=0;i<num_arr.length;i++) {
			for(j=0;j<num_arr[i].length;j++) {
				num_arr[i][j]=count;
				count++;
			}
		}
		
		/*
		A	F	G	B	
		D	D	C	F	
		B	A	C	H	
		E	E	H	G
		*/
		// 4행 4열 랜덤하게 넣기
		count=0;

		for(i=0;i<16;) {
			row = (int)(Math.random()*4);			// 0부터 3까지
			col = (int)(Math.random()*4);
			if(cor_arr[row][col]==0) {
				cor_arr[row][col] = (char)((char)(i%8)+65);
				i++;
				count++;
			}
		}
		/*
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++)
				System.out.print(cor_arr[i][j] + "\t");
			System.out.println();
		}*/
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++)
				System.out.print(cor_arr[i][j] + "\t");
			System.out.println();
		}
		
		// 5초 후에 숨기기
		System.out.println("3초후에 게임 시작");
		int cnt = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			} // 인터럽트(일시 정지)
			System.out.print(">");
			cnt++;
			if (cnt >= 30)
				break;
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++)
				System.out.print(num_arr[i][j] + "\t");
			System.out.println();
		}
		
		while(count3<8) {
			System.out.print("선택1 : ");
			choice1 = scan.nextInt();
			
			// choice1 에 해당하는 행,열 추출
			count=1;
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(choice1==count) {
						save_row = i;
						save_col = j;
						flag=1;
						break;
					}
					count++;
				}
				if(flag==1)
					break;
			}
			flag=0;
			
			// System.out.println(save_row + "," + save_col);
			
			// num_arr[save_row][save_col] 자리에 cor_arr[save_row][save_col] 문자를 넣을 것.
			// 그 전에 임시변수로 num_arr[save_row][save_col] 값을 잠시 저장해서 만약 오답이면 다시 숫자로 넣을 때 사용
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(i==save_row && j==save_col) {
						temp1 = num_arr[i][j];
						num_arr[save_row][save_col] = cor_arr[i][j];
						save_char1 = cor_arr[i][j];
						// 이렇게 되면 num_arr[save_row][save_col]의 요소는 65 이상의 값을 가진다.
						// 다음 선택 때 num_arr의 요소값이 65 이하인 애들만 검사하면 될 것.
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			flag=0;
			// System.out.println("temp = " + temp);
			// System.out.println("num_arr[save_row][save_col] = " + num_arr[save_row][save_col]);
			
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(num_arr[i][j]>=65)
						System.out.print((char)num_arr[i][j] + "\t");
					else
						System.out.print(num_arr[i][j] + "\t");
				}
				System.out.println();
			}
			
			// 두 번째 선택
			System.out.print("선택2 : ");
			choice2 = scan.nextInt();
			
			if(choice1==choice2) {
				System.out.println("같은 자리를 선택하셨습니다. 처음부터 다시 선택하세요.");
				num_arr[save_row][save_col] = temp1;
				for(i=0;i<4;i++) {
					for(j=0;j<4;j++)
						System.out.print(num_arr[i][j] + "\t");
					System.out.println();
				}
				continue;
			}
			// System.out.println("choice2 : " + choice2);		// 정상 작동 확인
			// save_row2, save_col2 구하기
			count=1;
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(choice2==count) {
						save_row2 = i;
						save_col2 = j;
						flag=1;
						break;
					}
					count++;
				}
				if(flag==1)
					break;
			}
			flag=0;
			// System.out.println("choice2 : " + choice2);
			// System.out.println("count : " + count);
			count=1;
			
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(i==save_row2 && j==save_col2) {
						temp2 = num_arr[i][j];
						num_arr[i][j] = cor_arr[i][j];
						save_char2 = cor_arr[i][j];
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			flag=0;
			
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(num_arr[i][j]>=65)
						System.out.print((char)num_arr[i][j] + "\t");
					else
						System.out.print(num_arr[i][j] + "\t");
				}
				System.out.println();
			}
			
			if(save_char1==save_char2) {
				System.out.println("맞췄다!\n");
				count3++;
			} else {
				System.out.println("틀렸다!\n");
				// System.out.println("temp1 : " + temp1 + " temp2 : " + temp2);
				num_arr[save_row][save_col] = temp1;
				num_arr[save_row2][save_col2] = temp2;
				// System.out.println("num_arr[save_row][save_col] : " + num_arr[save_row][save_col]);
				// System.out.println("num_arr[save_row2][save_col2] : " + num_arr[save_row2][save_col2]);
				for(i=0;i<4;i++) {
					for(j=0;j<4;j++) {
						if(num_arr[i][j]>=65) {
							System.out.print((char)num_arr[i][j] + "\t");
						} else {
							System.out.print(num_arr[i][j] + "\t");
						}
					}
					System.out.println();
				}
			}
		}
		System.out.println("게임 종료");
	}

}
