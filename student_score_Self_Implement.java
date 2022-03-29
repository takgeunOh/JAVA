package org.comstudy21.day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class student_score_Self_Implement {
	final int MAX = 10;
	String[] name, grade;
	int[] kor, eng, math, total, rank;
	double[] avg;
	int size=0, top=-1;
	Scanner scan;
	
	public student_score_Self_Implement	() {
		
		start();
	}
	
	public void start() {
		
		int choice;
		
		name = new String[MAX];
		kor = new int[MAX];
		eng = new int[MAX];
		math = new int[MAX];
		total = new int[MAX];
		avg = new double[MAX];
		grade = new String[MAX];
		rank = new int[MAX];
		
		System.out.println("----- 학생 성적 관리 프로그램 -----");
		
		while(true) {
			scan = new Scanner(System.in);
			choice = menu();
			switch(choice) {
			case 1: 
				input();
				System.out.println("----- 입력 완료 -----");
				break;
			case 2:
				output();
				System.out.println("----- 출력 완료 -----");
				break;
			case 3: 
				search();
				System.out.println("----- 검색 완료 -----");
				break;
			case 4:
				modify();
				System.out.println("----- 수정 완료 -----");
				break;
			case 5:
				delete();
				System.out.println("----- 삭제 완료 -----");
				break;
			case 6:
				System.out.println("---- 프로그램 종료 ----");
				return;
			}
		}
	}
	
	// 입력 기능
	public void input() {
		size++;
		top++;
		System.out.println("::: INPUT :::");
		InputData();
		calc();
	}
	
	// 출력 기능
	public void output() {
		
		if(!exist_check()) {
			// 학생 성적 정보가 하나도 없으면 함수에서 false 반환
			return;
		}
		
		System.out.println("::: OUTPUT :::");
		data_print_all();
	}
	
	public void search() {
		String search_name;
		int[] save_index = {0,};
		int search_idx=0;
		int count=0;
		
		if(!exist_check()) {
			// 학생 성적 정보가 하나도 없으면 곧바로 수정작업 종료
			return;
		}
		
		System.out.println("현재 데이터베이스에 저장된 학생 성적 정보는 다음과 같습니다.");
		data_print_all();
		
		while(true) {
			System.out.println("::: SEARCH :::");
			System.out.println("검색할 학생 이름을 입력해주세요.");
			search_name = scan.next();
			
			// 입력한 이름이 데이터에 존재하는지 확인
			if(!exist_name_check(search_name)) {
				// 함수에서 이름이 존재하면 true 반환
				repeat_check();
				// 반복 입력 받을지, 메인메뉴로 갈지 결정
				continue;
			}
			
			if(duplicate_name_check(search_name)) {
				// 동명이인이 2명 이상일 때
				System.out.printf("다음과 같이 %s 이름을 가진 학생이 둘 이상 존재합니다.\n", search_name);
				System.out.printf("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");

				// 동명이인의 인원수 구해서 그걸 출력범위로 사용해서 동명이인 리스트 출력할 것.
				count = duplicate_name_count(search_name);
				
				// 원래 데이터에서 동명이인이 존재하는 인덱스 추출
				save_index = duplicate_name_idx(count, search_name);
				
				// 동명이인 리스트 보여주고 번호 선택까지
				duplicate_print(save_index, count, search_name);
				
			} else {
				// 동명이인이 없으면 걔만 출력
				search_idx = find_name_return_idx(search_name);
				System.out.printf("검색하신 %s학생의 정보는 다음과 같습니다.\n", name[search_idx]);
				data_print(search_idx);
				System.out.println("----- 검색 완료 -----");
			}
			
			if(repeat_check())
				continue;
			else
				break;
		}
	}
	
	public void modify() {
		String modify_name;
		int modify_idx;
		int modify_choice=0;
		
		if(!exist_check()) {
			// 학생 성적 정보가 하나도 없으면 곧바로 수정작업 종료
			return;
		}
		
		System.out.println("::: MODIFY :::");
		
		while(true) {
			System.out.println("현재 데이터베이스에 저장된 학생 성적 정보는 다음과 같습니다.");
			data_print_all();
			
			System.out.println("수정할 학생의 이름을 입력하세요.");
			modify_name = scan.next();
			
			if(find_name_return_idx(modify_name)==-1) {
				// 수정할 이름이 없으면 -1 반환할 것.
				System.out.printf("입력하신 %s학생은 데이터에 존재하지 않습니다.\n", modify_name);
				if(repeat_check())
					continue;
				else
					return;
			}
			
			modify_idx = find_name_return_idx(modify_name);
			System.out.printf("%s학생의 정보는 다음과 같습니다.\n", name[modify_idx]);
			data_print(modify_idx);
			System.out.println("\n무엇을 수정하시겠습니까?");
			System.out.println("1)이름 2)국어성적 3)영어성적 4)수학성적");
			System.out.print("선택 >> ");
			modify_choice = scan.nextInt();
			
			if(modify_choice<0 || modify_choice>4) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				
				if(repeat_check())
					continue;
				else
					return;
			}
			
			if(modify_choice==1) {
				System.out.printf("%s학생 이름 수정 >> ", name[modify_idx]);
				name[modify_idx] = scan.next();
			}
			else if (modify_choice==2) {
				System.out.printf("%s학생 국어성적 수정 >> ", name[modify_idx]);
				kor[modify_idx] = scan.nextInt();
			}
			else if (modify_choice==3) {
				System.out.printf("%s학생 영어성적 수정 >> ", name[modify_idx]);
				eng[modify_idx] = scan.nextInt();
			}
			else if (modify_choice==4) {
				System.out.printf("%s학생 수학성적 수정 >> ", name[modify_idx]);
				math[modify_idx] = scan.nextInt();
			}
			
			calc();
			
			System.out.printf("수정된 %s학생의 정보는 다음과 같습니다.\n", name[modify_idx]);
			data_print(modify_idx);
			
			if(repeat_check())
				continue;
			else
				return;
		}
	}
	
	public void delete() {
		
		String delete_name;
		int delete_idx;
		int i;
		
		while(true) {
			if(!exist_check()) {
				// 학생 성적 정보가 하나도 없으면 함수에서 false 반환
				return;
			}
			
			System.out.println();
			System.out.println("::: DELETE :::");
			
			System.out.println("현재 데이터베이스에 저장된 학생 성적 정보는 다음과 같습니다.");
			data_print_all();
			System.out.print("삭제할 학생 이름을 입력하세요. >> ");
			delete_name = scan.next();
			delete_idx = find_name_return_idx(delete_name);				// 삭제할 학생이 존재하면 해당 인덱스 반환, 없으면 -1 반환
			if(delete_idx==-1) {
				System.out.println("해당 학생명은 존재하지 않습니다. ");
				if(repeat_check()) {				
					// 계속해서 삭제작업 진행할거면 true 반환
					continue;
				} else
					return;				// 메인메뉴 이동
			}
			System.out.println(delete_idx);
			System.out.println(top);
			for(i=delete_idx;i<size-1;i++) {		// 2
				name[i] = name[i+1];
				kor[i] = kor[i+1];
				eng[i] = eng[i+1];
				math[i] = math[i+1];
				total[i] = total[i+1];
				avg[i] = avg[i+1];
				grade[i] = grade[i+1];
			}
			
			top--;
			size--;
			setRank();
			
			System.out.println("\n삭제 후 데이터베이스에 저장된 학생 정보는 다음과 같습니다.");
			data_print_all();
			
			if(repeat_check())
				continue;
			else
				return;
		}
	}
	
	public void duplicate_print(int[] save_index, int count, String search_name) {
		int i=0;
		int search_no_choice=0;
		
		for(i=0;i<count;i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
					i+1,name[save_index[i]], kor[save_index[i]], eng[save_index[i]], 
					math[save_index[i]], total[save_index[i]], avg[save_index[i]], 
					grade[save_index[i]], rank[save_index[i]]);		
		}
		System.out.println("검색을 원하는 학생의 번호를 선택해주세요.");
		search_no_choice = scan.nextInt();
		
		System.out.printf("%d번의 %s학생 정보는 다음과 같습니다.\n", search_no_choice, search_name);
		System.out.printf("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
		for(i=0;i<save_index.length;i++) {
			if(search_no_choice==i+1) {
				System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
						i+1,name[save_index[i]], kor[save_index[i]], eng[save_index[i]], 
						math[save_index[i]], total[save_index[i]], avg[save_index[i]], 
						grade[save_index[i]], rank[save_index[i]]);
				break;
			}
		}
	}
	
	public int[] duplicate_name_idx(int count, String search_name) {
		int[] save_index;
		int i;
		
		save_index = new int[count];
		// 원래 데이터에서 동명이인인 학생의 인덱스를 배열 save_index에 저장
		for(i=0;i<count;i++) {
			if(search_name.equals(name[i]))
				save_index[i] = i;
		}
		
		return save_index;
	}
	
	public int duplicate_name_count(String search_name) {
		int i;
		int count=0;
		
		for(i=0;i<size;i++) {
			if(search_name.equals(name[i])) {
				count++;
			}
		}
		
		return count;
	}
	
	public boolean exist_name_check(String search_name) {
		int i;
		int flag=0;
		for(i=0;i<size;i++) {
			if(search_name.equals(name[i])) {
				flag=1;
				break;
			}
		}
		
		if(flag==0) {
			System.out.println("입력하신 이름은 데이터에 없는 이름입니다.");
			return false;
		}
		return true;
	}
	
	public boolean duplicate_name_check(String dup_name) {
		
		int i;
		int count=0;
		
		for(i=0;i<size;i++) {
			if(dup_name.equals(name[i])) {
				count++;
			}
		}
		
		if(count>=2)
			return true;
		else
			return false;
	}
	public void data_print_all() {
		int i;
		
		System.out.printf("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
		for(i=0;i<=top;i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
					i+1,name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
		}
	}
	
	public void data_print(int idx) {
		System.out.printf("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
				idx+1,name[idx], kor[idx], eng[idx], math[idx], total[idx], avg[idx], grade[idx], rank[idx]);
	}
	
	public int find_and_print(String s_name) {
		int search_idx=-1;
		
		search_idx = find_name_return_idx(s_name);
		/*
		for(i=0;i<size;i++) {
			if(s_name.equals(name[i])) {
				save_index = i;
				flag=1;
				break;
			}
		}*/
		
		if(search_idx>=0) {
			// 찾았으면 해당 인덱스 정보 출력
			System.out.printf("검색한 학생 이름은 %s이며 성적 정보는 다음과 같습니다.\n", name[search_idx]);
			System.out.printf("성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n", name[search_idx], kor[search_idx], eng[search_idx], 
					math[search_idx], total[search_idx], avg[search_idx], grade[search_idx], rank[search_idx]);
			return 0; 
		} else {
			System.out.println("검색한 학생 이름은 존재하지 않습니다.");
			
			if(repeat_check()) {
				return 1;
			}
		}
		return 2;
	}
	
	public boolean repeat_check() {
		char choice=0;
		
		System.out.println("계속해서 작업을 진행하시겠습니까? (y/n) n 입력 시 메인메뉴로 이동합니다.");
		choice = scan.next().charAt(0);
		
		if(choice=='y')
			return true;
		else
			return false;
	}
	
	public boolean exist_check() {
		if(size<=0) {
			System.out.println("현재 데이터베이스에 저장된 학생 성적 정보는 존재하지 않습니다.");
			return false;
		}
		return true;
	}
	
	public int find_name_return_idx(String s_name) {
		int i;
		for(i=0;i<size;i++) {
			if(s_name.equals(name[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public void InputData() {
		System.out.print("성명 입력 : ");
		name[top] = scan.next();
		System.out.print("국어점수 : ");
		kor[top] = scan.nextInt();
		System.out.print("영어점수 : ");
		eng[top] = scan.nextInt();
		System.out.print("수학점수 : ");
		math[top] = scan.nextInt();
	}
	
	public void calc() {
		total[top] = kor[top] + eng[top] + math[top];
		avg[top] = total[top]/3.0;
		
		if(avg[top]>=90 && avg[top]<=100)
			grade[top] = "A";
		else if (avg[top]>=80 && avg[top]<90)
			grade[top] = "B";
		else if (avg[top]>=70 && avg[top]<80)
			grade[top] = "C";
		else if (avg[top]>=60 && avg[top]<70)
			grade[top] = "D";
		else
			grade[top] = "F";
		
		if(avg[top]%10>=7 && avg[top]>=60 || avg[top]==100)
			grade[top] = grade[top] + "+";
		else if (avg[top]%10<=3 && avg[top]>=60)
			grade[top] = grade[top] + "-";
		
		// 순위 계산
		setRank();
	}
	
	public void setRank() {
		int i,j;
		int[] temp_count_arr=new int[top+1];
		
		for(i=0;i<=top;i++) {
			temp_count_arr[i] = 1;
			for(j=0;j<=top;j++) {
				if(avg[i]<avg[j])
					temp_count_arr[i]++;
			}
			rank[i] = temp_count_arr[i];
		}
	}
	
	public int menu() {
		int choice=0;

		System.out.println("1)INPUT 2)OUTPUT 3)SEARCH 4)MODIFY 5)DELETE 6)END");
		System.out.print("Choice : ");
		scan = new Scanner(System.in);
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("잘못된 입력값입니다. 다시 입력하세요.");
		}
		
		return choice;
	}
	
	public static void main(String[] args) {
		
		new student_score_Self_Implement();

	}

}
