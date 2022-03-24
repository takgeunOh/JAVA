package org.comstudy21.day11;

public class Day11Ex03 {
	
	int[][] arr = new int[5][5];
	
	public Day11Ex03() {
		// Ex03Test01();
		// Ex03Test02();
		// Ex03Test03();
		// Ex03Test04();
		Ex03Test05();
	}
	
	public void Ex03Test05() {
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
		
		while(true) {
			//System.out.println(number);
			if(number>25)
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
		}
		// ���
		printArr();
	}
	
	public void Ex03Test04() {
		// 1	2	3	4	5
		// 		6	7	8
		//			9
		// 		10	11	12
		// 13	14	15	16	17
		
		int number=1;
		for(int i=0;i<arr.length;i++) {
			if(i<3) {
				for(int j=i;j<arr[i].length-i;j++)
					arr[i][j]=number++;
			} else {
				for(int j=arr[i].length-i-1;j<arr[i].length+i-(arr[i].length-1);j++) {
					arr[i][j]=number++;
				}
			}
		}
		// ���
		printArr2();
	}
	
	public void Ex03Test03() {
		// 1	2	3	4	5
		// 10	9	8	7	6
		// 11	12	13	14	15
		// 20	19	18	17	16
		// 21	22	23	24	25
		
		int number=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i%2!=0) {
					arr[i][arr[i].length-j-1] = number++;
				}
				else {
					arr[i][j] = number++;
				}
			}
		}
		// ���
		printArr();
	}
	
	public void Ex03Test02() {
		// 5	4	3	2	1
		// 10	9	8	7	6
		// 15	14	13	12	11
		// 20	19	18	17	16
		// 25	24	23	22	21
		
		int number=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][arr[i].length-j-1] = number++;
			}
		}
		// ���
		printArr();
	}
	
	public void Ex03Test01() {
		// 1	2	3	4 	5 
		// 6 	7 	8 	9 	10
		// 11 	12 	13 	14 	15
		// 16 	17	18 	19 	20
		// 21	22	23	24	25
		int number=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = number++;
			}
		}
		// ���
		printArr();
	}
	
	public void printArr() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void printArr2() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]!=0? arr[i][j] + "\t" : "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		new Day11Ex03();

	}

}
