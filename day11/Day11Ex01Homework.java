package org.comstudy21.day11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day11Ex01Homework {

	public static final Random rand = new Random();
	public static final Scanner scan = new Scanner(System.in);	// ��ĵ�� �߰��� �ٲ� ���� �����Ƿ� ����� ������ ��.
	public static final int SIZE = 6;
	public static final int MAX = 6;							// �ʵ忡 ����
	
	public Day11Ex01Homework() {
		System.out.print("����>>");
		switch(scan.nextInt()) {
		case 1 : lotto01(); break;				// �ζ� ù ��° ����
		case 2 : lotto02(); break;				// �� ���
		case 3 : lotto03(); break;				// �ζ� �� ��° ����
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
			// ���� ������ number�� ���� lotto �迭�� ���� ���� �ֳ�?
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
		// 1. ������ �ݺ��ؼ� ������ �߻���Ų��.
		// 2. �߻��� ������ �迭 lotto�� ������� �����Ѵ�.
		// 3. �߻���Ų ������ �̹� lotto�� ����� ���� ���� ���̸� �ٽ� �����Ѵ�.
		// 4. �ٽ� ������ ������ lotto�� ����� ����� �ٽ� ���Ѵ�. (index �ʱ�ȭ)
		
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
