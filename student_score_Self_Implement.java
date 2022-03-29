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
		
		System.out.println("----- �л� ���� ���� ���α׷� -----");
		
		while(true) {
			scan = new Scanner(System.in);
			choice = menu();
			switch(choice) {
			case 1: 
				input();
				System.out.println("----- �Է� �Ϸ� -----");
				break;
			case 2:
				output();
				System.out.println("----- ��� �Ϸ� -----");
				break;
			case 3: 
				search();
				System.out.println("----- �˻� �Ϸ� -----");
				break;
			case 4:
				modify();
				System.out.println("----- ���� �Ϸ� -----");
				break;
			case 5:
				delete();
				System.out.println("----- ���� �Ϸ� -----");
				break;
			case 6:
				System.out.println("---- ���α׷� ���� ----");
				return;
			}
		}
	}
	
	// �Է� ���
	public void input() {
		size++;
		top++;
		System.out.println("::: INPUT :::");
		InputData();
		calc();
	}
	
	// ��� ���
	public void output() {
		
		if(!exist_check()) {
			// �л� ���� ������ �ϳ��� ������ �Լ����� false ��ȯ
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
			// �л� ���� ������ �ϳ��� ������ ��ٷ� �����۾� ����
			return;
		}
		
		System.out.println("���� �����ͺ��̽��� ����� �л� ���� ������ ������ �����ϴ�.");
		data_print_all();
		
		while(true) {
			System.out.println("::: SEARCH :::");
			System.out.println("�˻��� �л� �̸��� �Է����ּ���.");
			search_name = scan.next();
			
			// �Է��� �̸��� �����Ϳ� �����ϴ��� Ȯ��
			if(!exist_name_check(search_name)) {
				// �Լ����� �̸��� �����ϸ� true ��ȯ
				repeat_check();
				// �ݺ� �Է� ������, ���θ޴��� ���� ����
				continue;
			}
			
			if(duplicate_name_check(search_name)) {
				// ���������� 2�� �̻��� ��
				System.out.printf("������ ���� %s �̸��� ���� �л��� �� �̻� �����մϴ�.\n", search_name);
				System.out.printf("��ȣ\t����\t����\t����\t����\t����\t���\t����\t���\n");

				// ���������� �ο��� ���ؼ� �װ� ��¹����� ����ؼ� �������� ����Ʈ ����� ��.
				count = duplicate_name_count(search_name);
				
				// ���� �����Ϳ��� ���������� �����ϴ� �ε��� ����
				save_index = duplicate_name_idx(count, search_name);
				
				// �������� ����Ʈ �����ְ� ��ȣ ���ñ���
				duplicate_print(save_index, count, search_name);
				
			} else {
				// ���������� ������ �¸� ���
				search_idx = find_name_return_idx(search_name);
				System.out.printf("�˻��Ͻ� %s�л��� ������ ������ �����ϴ�.\n", name[search_idx]);
				data_print(search_idx);
				System.out.println("----- �˻� �Ϸ� -----");
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
			// �л� ���� ������ �ϳ��� ������ ��ٷ� �����۾� ����
			return;
		}
		
		System.out.println("::: MODIFY :::");
		
		while(true) {
			System.out.println("���� �����ͺ��̽��� ����� �л� ���� ������ ������ �����ϴ�.");
			data_print_all();
			
			System.out.println("������ �л��� �̸��� �Է��ϼ���.");
			modify_name = scan.next();
			
			if(find_name_return_idx(modify_name)==-1) {
				// ������ �̸��� ������ -1 ��ȯ�� ��.
				System.out.printf("�Է��Ͻ� %s�л��� �����Ϳ� �������� �ʽ��ϴ�.\n", modify_name);
				if(repeat_check())
					continue;
				else
					return;
			}
			
			modify_idx = find_name_return_idx(modify_name);
			System.out.printf("%s�л��� ������ ������ �����ϴ�.\n", name[modify_idx]);
			data_print(modify_idx);
			System.out.println("\n������ �����Ͻðڽ��ϱ�?");
			System.out.println("1)�̸� 2)����� 3)����� 4)���м���");
			System.out.print("���� >> ");
			modify_choice = scan.nextInt();
			
			if(modify_choice<0 || modify_choice>4) {
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
				
				if(repeat_check())
					continue;
				else
					return;
			}
			
			if(modify_choice==1) {
				System.out.printf("%s�л� �̸� ���� >> ", name[modify_idx]);
				name[modify_idx] = scan.next();
			}
			else if (modify_choice==2) {
				System.out.printf("%s�л� ����� ���� >> ", name[modify_idx]);
				kor[modify_idx] = scan.nextInt();
			}
			else if (modify_choice==3) {
				System.out.printf("%s�л� ����� ���� >> ", name[modify_idx]);
				eng[modify_idx] = scan.nextInt();
			}
			else if (modify_choice==4) {
				System.out.printf("%s�л� ���м��� ���� >> ", name[modify_idx]);
				math[modify_idx] = scan.nextInt();
			}
			
			calc();
			
			System.out.printf("������ %s�л��� ������ ������ �����ϴ�.\n", name[modify_idx]);
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
				// �л� ���� ������ �ϳ��� ������ �Լ����� false ��ȯ
				return;
			}
			
			System.out.println();
			System.out.println("::: DELETE :::");
			
			System.out.println("���� �����ͺ��̽��� ����� �л� ���� ������ ������ �����ϴ�.");
			data_print_all();
			System.out.print("������ �л� �̸��� �Է��ϼ���. >> ");
			delete_name = scan.next();
			delete_idx = find_name_return_idx(delete_name);				// ������ �л��� �����ϸ� �ش� �ε��� ��ȯ, ������ -1 ��ȯ
			if(delete_idx==-1) {
				System.out.println("�ش� �л����� �������� �ʽ��ϴ�. ");
				if(repeat_check()) {				
					// ����ؼ� �����۾� �����ҰŸ� true ��ȯ
					continue;
				} else
					return;				// ���θ޴� �̵�
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
			
			System.out.println("\n���� �� �����ͺ��̽��� ����� �л� ������ ������ �����ϴ�.");
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
		System.out.println("�˻��� ���ϴ� �л��� ��ȣ�� �������ּ���.");
		search_no_choice = scan.nextInt();
		
		System.out.printf("%d���� %s�л� ������ ������ �����ϴ�.\n", search_no_choice, search_name);
		System.out.printf("��ȣ\t����\t����\t����\t����\t����\t���\t����\t���\n");
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
		// ���� �����Ϳ��� ���������� �л��� �ε����� �迭 save_index�� ����
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
			System.out.println("�Է��Ͻ� �̸��� �����Ϳ� ���� �̸��Դϴ�.");
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
		
		System.out.printf("��ȣ\t����\t����\t����\t����\t����\t���\t����\t���\n");
		for(i=0;i<=top;i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
					i+1,name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
		}
	}
	
	public void data_print(int idx) {
		System.out.printf("��ȣ\t����\t����\t����\t����\t����\t���\t����\t���\n");
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
			// ã������ �ش� �ε��� ���� ���
			System.out.printf("�˻��� �л� �̸��� %s�̸� ���� ������ ������ �����ϴ�.\n", name[search_idx]);
			System.out.printf("����\t����\t����\t����\t����\t���\t����\t���\n");
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n", name[search_idx], kor[search_idx], eng[search_idx], 
					math[search_idx], total[search_idx], avg[search_idx], grade[search_idx], rank[search_idx]);
			return 0; 
		} else {
			System.out.println("�˻��� �л� �̸��� �������� �ʽ��ϴ�.");
			
			if(repeat_check()) {
				return 1;
			}
		}
		return 2;
	}
	
	public boolean repeat_check() {
		char choice=0;
		
		System.out.println("����ؼ� �۾��� �����Ͻðڽ��ϱ�? (y/n) n �Է� �� ���θ޴��� �̵��մϴ�.");
		choice = scan.next().charAt(0);
		
		if(choice=='y')
			return true;
		else
			return false;
	}
	
	public boolean exist_check() {
		if(size<=0) {
			System.out.println("���� �����ͺ��̽��� ����� �л� ���� ������ �������� �ʽ��ϴ�.");
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
		System.out.print("���� �Է� : ");
		name[top] = scan.next();
		System.out.print("�������� : ");
		kor[top] = scan.nextInt();
		System.out.print("�������� : ");
		eng[top] = scan.nextInt();
		System.out.print("�������� : ");
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
		
		// ���� ���
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
			System.out.println("�߸��� �Է°��Դϴ�. �ٽ� �Է��ϼ���.");
		}
		
		return choice;
	}
	
	public static void main(String[] args) {
		
		new student_score_Self_Implement();

	}

}
