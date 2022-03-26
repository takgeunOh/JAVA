package day12.homework;

import java.util.Scanner;

public class Ch03Homework01_practice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		char cor_arr[][] = new char[4][4];
		int num_arr[][] = new int[4][4];
		int i,j;
		int count=1;			// ��, �� ������ �� ���� �뵵
		int count2=0;			// ī�� 2�� ����� �� ���俩�� �˻� �����ϴ� ������ ���ϴ� �뵵
		int count3=0;			// ī�� 2�� ������ �� ����ī��Ʈ �ø��� �뵵 (8�� �Ǹ� ����ǰ� �� ����)
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
		// 4�� 4�� �����ϰ� �ֱ�
		count=0;

		for(i=0;i<16;) {
			row = (int)(Math.random()*4);			// 0���� 3����
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
		
		// 5�� �Ŀ� �����
		System.out.println("3���Ŀ� ���� ����");
		int cnt = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			} // ���ͷ�Ʈ(�Ͻ� ����)
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
			System.out.print("����1 : ");
			choice1 = scan.nextInt();
			
			// choice1 �� �ش��ϴ� ��,�� ����
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
			
			// num_arr[save_row][save_col] �ڸ��� cor_arr[save_row][save_col] ���ڸ� ���� ��.
			// �� ���� �ӽú����� num_arr[save_row][save_col] ���� ��� �����ؼ� ���� �����̸� �ٽ� ���ڷ� ���� �� ���
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					if(i==save_row && j==save_col) {
						temp1 = num_arr[i][j];
						num_arr[save_row][save_col] = cor_arr[i][j];
						save_char1 = cor_arr[i][j];
						// �̷��� �Ǹ� num_arr[save_row][save_col]�� ��Ҵ� 65 �̻��� ���� ������.
						// ���� ���� �� num_arr�� ��Ұ��� 65 ������ �ֵ鸸 �˻��ϸ� �� ��.
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
			
			// �� ��° ����
			System.out.print("����2 : ");
			choice2 = scan.nextInt();
			
			if(choice1==choice2) {
				System.out.println("���� �ڸ��� �����ϼ̽��ϴ�. ó������ �ٽ� �����ϼ���.");
				num_arr[save_row][save_col] = temp1;
				for(i=0;i<4;i++) {
					for(j=0;j<4;j++)
						System.out.print(num_arr[i][j] + "\t");
					System.out.println();
				}
				continue;
			}
			// System.out.println("choice2 : " + choice2);		// ���� �۵� Ȯ��
			// save_row2, save_col2 ���ϱ�
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
				System.out.println("�����!\n");
				count3++;
			} else {
				System.out.println("Ʋ�ȴ�!\n");
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
		System.out.println("���� ����");
	}

}
