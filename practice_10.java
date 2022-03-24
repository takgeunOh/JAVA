package java_chapter03_practice;

public class practice_10 {

	public static void main(String[] args) {
		
		// 랜덤함수는 0.xxx ~ 0.9xxxx 반환
		// 임의의 위치에 투입..
		// 이미 투입된 자리는 제외시켜야할듯
		// 0으로 모두 초기화하고 어차피 1부터 시작되는 정수를 넣을거니까
		// 해당 인덱스의 배열에 숫자가 0인 경우 숫자가 투입된 적이 없는 것으로 간주
		
		int arr[][] = new int[4][4];
		int i,j;
		int random_i, random_j;
		int count=0;
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++)
				arr[i][j]=0;
		}		// 0으로 우선 초기화
		
		random_i = (int)(Math.random()*4);
		random_j = (int)(Math.random()*4);
		arr[random_i][random_j] = (int)(Math.random()*10+1);
		count=1;
		
		while(count<10) {
			random_i = (int)(Math.random()*4);
			random_j = (int)(Math.random()*4);
			
			if(arr[random_i][random_j]==0) {
				arr[random_i][random_j] = (int)(Math.random()*10+1);
				count++;
			}
		}
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		
		
	}

}
