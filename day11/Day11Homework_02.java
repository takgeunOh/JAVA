package org.comstudy21.day11;

public class Day11Homework_02 {

	static int[][] arr = new int[5][5];
	
	public static void main(String[] args) {
		// 1	2	3	4	5
		// 16	17	18	19	6
		// 15	24	25	20	7
		// 14	23	22	21	8
		// 13	12	11	10	9
		
		// ���� ���� ���� �ٴٸ� ������ �ش� ���� ���� �ӽ� ������ �����ϰ�
		// ���� �ݺ� �� �ӽú���-1��ŭ ��� ���� �ݺ����ָ� �� �� ����.
		// ¦����° �ݺ��� �� ����� ����, Ȧ����° �ݺ��� �� ������ ����
		// � ���̽������� �ุ �����ϰ�, � ���̽������� ���� �����ϰ�
		// ���ߴ� �͵� ���̽��� ����? �� ���� ĭ�� ���� ��������� ���� ���̽��� �Ѿ�Բ�
		// 4���� ���̽� : �� ����, �� ����, �� ����, �� ����
		
		
		int number=1;
		int i=0,j=0;
		int start_i=0, start_j=0;
		int direction=0;		// 0�� �� �� ���� ����, 1�� �� �� ���� ����, 2�� �� �� ���� ����, 3�� �� �� ���� ����
		int flag=0;
		
		while(true) {
			//System.out.println(number);
			for(i=0;i<arr.length;i++) {					// ���� ���� ���ڰ� �ִ��� �Ǻ�
				for(j=0;j<arr[i].length;j++)
				{
					if(arr[i][j]==0) {					// �迭 ��� �� 0�� �ϳ��� �����ϸ� �ٷ� flag=1 �ְ� �Ǻ� �ݺ��� ����
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
			
			// ��� �ݺ��� ���� �Ǻ� ���׷��̵�
			if(flag==0)									// ���� ���� ���� ���ڰ� �ϳ��� ���ٸ�(��, 0�� ��Ұ� �ϳ��� ���ٸ�) ��� �ݺ����� �ߴ��Ѵ�.
				break;
			
			if(direction==0) {
				// �� ���� ������ ��
				for(j=start_i;j<5;j++) {
					if(arr[start_i][j]!=0)
						break;
					arr[start_i][j] = number;
					//System.out.println(number);
					number++;
				}
			} else if (direction==1) {
				// �� ���� ������ ��
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
				// �� ���� ������ ��
				for(j=start_j;j>=0;j--) {
					if(arr[start_i][j]!=0)
						break;
					arr[start_i][j]=number;
					//System.out.println(number);
					number++;
				}
			} else if (direction==3) {
				// �� ���� ������ ��
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
		// ���
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
