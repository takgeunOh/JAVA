package day12.homework;

import java.util.Scanner;

//�ָ�����(2)
//���� ��� ���α׷� �����
/*
----- ���� ���� ���α׷� -----			
// ������ �˻��ؼ� �ش��ϴ� ��� ����� (������ �� �ڿ� �ֵ��� ������ �����), 1�����̵� 2�����̵� ��Ա�
// ������ �̸� �ߺ��� ���ٴ� ���� �Ͽ� �Է��� �ް� �ϴµ� �ߺ� üũ �����ϸ� �����غ���
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 1
���� : ȫ�浿
�������� : 80
�������� : 80
�������� : 80
--- �Է� �Ϸ� ---
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 2
����	����	����	����	����	���	����	���
ȫ�浿	80	80	80	240	80.0	B	1
--- ��� �Ϸ� ---
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 1
���� : ��浿
�������� : 80
�������� : 80
�������� : 80
--- �Է� �Ϸ� ---
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 3
�˻��� �̸� : ȫ�浿
����	����	����	����	����	���	����	���
ȫ�浿	80	80	80	240	80.0	B	1
--- ��� �Ϸ� ---
*/

public class Ch03Homework02_1D_array {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// ������, �ε��� ���� ������
		int size=0;
		int i=-1,j=0, k=0;
		
		// ��¥ �л� ������ �����ϴ� �迭
		String[] student_name= {,};
		int[] kor= {0,}, eng= {0,}, math= {0,}, total= {0,}, rank= {0,};
		double[] avg= {0,};
		String[] grade= {,};
		
		// �߰�, ���� ���� �ӽ÷� �л� ������ �����ϴ� �迭
		String[] temp_name= {,};
		int[] temp_kor= {0,}, temp_eng= {0,}, temp_math= {0,}, temp_total= {0,}, temp_rank= {0,};
		double[] temp_avg= {0,};
		String[] temp_grade= {,};
		String[] del_temp_name= {,};
		int[] del_temp_kor= {0,}, del_temp_eng= {0,}, del_temp_math= {0,}, del_temp_total= {0,}, del_temp_rank= {0,};
		double[] del_temp_avg= {0,};
		String[] del_temp_grade= {,};
		double[] temp_avg_rank= {0,};
		int rank_count=0;
		double max=0;
		int save_index=0;
		int count=0;
		
		// ���� ���� ������
		int choice;
		char input_choice;
		char search_choice;
		String search_name;
		int modify_index=0;
		char modify_choice1=0;
		int modify_choice2=0;
		char modify_choice3=0;
		String modify_name="";
		String delete_name="";
		int delete_index=0;
		char delete_choice=0;
		char delete_choice2=0;
		
		
		int flag=0;
		
		System.out.println("---- ���� ���� ���α׷� ----");
		
		while(true) {
			System.out.println("\n���Ͻô� ������ �Է����ּ���.");
			System.out.println("1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End");
			System.out.print("Choice :");
			choice = scan.nextInt();
			if(choice==6) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			
			// input
			if(choice==1) {
				i++;					// 0 1 2 ...
				size++;					// 1 2 3 ...
				
				// �迭�� ũ�⸦ input ������ ���Ҵ��ؾ��ϴµ�
				// �ܼ��� new int[count] �̷� ������ �ϸ� �Է� ���� �ε������� ��� �ʱ�ȭ�� �ȴ�.
				// ��... �׷��� �迭�� ũ�⸦ �ϳ� �� �ø� ���ο� �迭�� �����
				// ���ο� �迭�� ������ �迭(temp)�� ������ �����ϰ�
				// ������ �ε����� ���ο� ���� ����ִ� ������ �غ���.
				
				// ����� �ϳ��� �þ ���ο� �迭 ����
				student_name = new String[size];
				kor = new int[size];
				eng = new int[size];
				math = new int[size];
				total = new int[size];
				avg = new double[size];
				grade = new String[size];
				rank = new int[size];
				
				// ���ο� �迭�� ������ �迭 ������ �ε����� �� �ִ� ��ҵ��� ����
				for(j=0;j<size-1;j++) {						
					// ù �Է� ������ �� ���簡 �̷������ �ʰ�
					// ������ �迭 ������� �� �ݺ����� �̷���� ��� size������ 1 ����
					student_name[j] = temp_name[j];
					kor[j] = temp_kor[j];
					eng[j] = temp_eng[j];
					math[j] = temp_math[j];
					total[j] = temp_total[j];
					avg[j] = temp_avg[j];
					grade[j] = temp_grade[j];
					rank[j] = temp_rank[j];
				}
				
				System.out.print("���� : ");
				student_name[i] = scan.next();
				for(j=0;j<size;j++) {
					if(student_name[i].equals(student_name[j])) {
						count++;
					}
				}
				// count�� 2�̻��̸� �ߺ��̸� �Է��ߴٰ� �Ǻ�
				while(count>=2) {
					System.out.println(count);
					System.out.println("�̹� ��ϵǾ��ִ� ȸ�� �̸��Դϴ�.");
					System.out.println("�ٽ� �Է��Ͻ÷��� y, ���� �޴��� �����÷��� n�� �����ּ���.");
					input_choice=scan.next().charAt(0);
					if(input_choice=='y') {
						System.out.print("���� : ");
						student_name[i] = scan.next();
						count=0;
						for(j=0;j<size;j++) {
							if(student_name[i].equals(student_name[j])) {
								count++;
							}
						}
					} else {
						flag=1;
						break;
					}
				}
				if(flag==1)
					continue;
				
				flag=0;
				count=0;
				System.out.print("�������� : ");
				kor[i] = scan.nextInt();
				System.out.print("�������� : ");
				eng[i] = scan.nextInt();
				System.out.print("�������� : ");
				math[i] = scan.nextInt();
				System.out.println();
				
				total[i] = kor[i] + eng[i] + math[i];
				avg[i] = (double)total[i] / 3;
				
				switch((int)avg[i]/10) {
				case 10:
					grade[i]="A+";
					break;
				case 9:
					grade[i]="A";
					break;
				case 8:
					grade[i]="B";
					break;
				case 7:
					grade[i]="C";
					break;
				case 6:
					grade[i]="D";
					break;
				default:
					grade[i]="F";
				}
				
				rank[i]=1;
				
				// temp �迭 ũ�⵵ �ϳ��� �����ϸ鼭 ���� �������ְ� (���鵵 ��� �ʱ�ȭ)
				temp_name = new String[size];
				temp_kor = new int[size];
				temp_eng = new int[size];
				temp_math = new int[size];
				temp_total = new int[size];
				temp_avg = new double[size];
				temp_grade = new String[size];
				temp_rank = new int[size];
				// �ű⿡ ���� �ٽ� ����
				for(j=0;j<size;j++) {
					temp_name[j] = student_name[j];
					temp_kor[j] = kor[j];
					temp_eng[j] = eng[j];
					temp_math[j] = math[j];
					temp_total[j] = total[j];
					temp_avg[j] = avg[j];
					temp_grade[j] = grade[j];
					temp_rank[j] = rank[j];
				}
				System.out.println("--- �Է� �Ϸ� ---");
			}
			
			//output
			else if (choice==2) {
				/*
				����	����	����	����	����	���	����	���
				ȫ�浿	80	80	80	240	80.0	B	1
				*/
				
				// �ƹ� ������ ������� ���� �� output ��� ��
				// i=-1, size=0
				if(size<=0) {
					System.out.println("\n���� �����ͺ��̽��� ����� �л��� ���� �� �� �������� �ʽ��ϴ�.");
					System.out.println("�л� ������ Ȯ�����ֽ� �� �õ����ּ���.\n");
					continue;
				}
				
				System.out.println("����" + "\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" +
				"����" + "\t" + "���" + "\t" + "����" + "\t" + "���");
				for(j=0;j<size;j++) {
					/*
					System.out.println(student_name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + math[i] + "\t" 
							+ total[i] + "\t" + avg[i] + "\t" + grade[i] + "\t" + rank[i]);
					*/
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n", 
							student_name[j], kor[j], eng[j], math[j], total[j], avg[j], grade[j], rank[j]);
				}
				System.out.println("--- ��� �Ϸ� ---");
			}
			
			//Search
			else if (choice==3) {
				/*
				�˻��� �̸� : ȫ�浿
				����	����	����	����	����	���	����	���
				ȫ�浿	80	80	80	240	80.0	B	1
				*/
				
				if(size<=0) {
					System.out.println("���� �����ͺ��̽��� ����� �л��� ���� �� �� �������� �ʽ��ϴ�.");
					System.out.println("�л� ������ Ȯ�����ֽ� �� �õ����ּ���.\n");
					continue;
				}
				
				while(true) {
					System.out.print("�˻��� �̸� : ");
					search_name = scan.next();
					
					for(i=0;i<size;i++) {
						if(search_name.equals(student_name[i])) {
							flag=1;
							break;
						}
					}
					if(flag==0) {
						System.out.println("�׷� ����� �����ϴ�. �̸��� �ٽ� Ȯ�����ֽð� �Է����ּ���.");
						System.out.print("��� �˻��Ͻðڽ��ϱ�? (y/n) >> ");
						search_choice = scan.next().charAt(0);
						if(search_choice=='n')
							break;
						continue;
					}
					
					flag=0;
					
					for(i=0;i<size;i++) {
						if(search_name.equals(student_name[i])) {
							System.out.printf("����\t����\t����\t����\t����\t���\t����\t���\n");
							System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
									student_name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
							break;
						}
					}
					
					System.out.println("--- �˻� �Ϸ� ---");
					
					System.out.print("��� �˻��Ͻðڽ��ϱ�? (y/n) >> ");
					search_choice = scan.next().charAt(0);
					if(search_choice=='n')
						break;
				}
			}
			
			// Modify
			else if (choice==4) {
				if(size<=0) {
					System.out.println("���� �����ͺ��̽��� ����� �л��� ���� �� �� �������� �ʽ��ϴ�.");
					System.out.println("�л� ������ Ȯ�����ֽ� �� �õ����ּ���.\n");
					continue;
				}
				
				while(true) {
					System.out.println("������ ������ �л� �̸��� �Է��ϼ���.");
					modify_name = scan.next();
					for(j=0;j<size;j++) {
						if(modify_name.equals(student_name[j])) {
							modify_index = j;
							flag=1;
							break;
						}
					}
					
					if(flag==0) {
						System.out.println("�ش� �л��� �����Ϳ� �������� �ʽ��ϴ�.");
						System.out.print("�ٽ� �Է��Ͻðڽ��ϱ�? (y/n) >> ");
						modify_choice1 = scan.next().charAt(0);
						
						if(modify_choice1=='y')
							continue;
						else if (modify_choice1=='n')
							break;
					}
					
					flag=0;
					
					System.out.printf("%s�л��� � ������ �����Ͻðڽ��ϱ�?\n", student_name[modify_index]);
					System.out.printf("%s�л��� ������ ������ �����ϴ�.\n", student_name[modify_index]);
					System.out.printf("����\t����\t����\t����\t����\t���\t����\t���\n");
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
							student_name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
					System.out.println();
					System.out.println("(�̸� : 1, ����� : 2, ����� : 3, ���м��� : 4, �׸� : 5)");
					System.out.println("���ϴ� ��ȣ�� �Է����ּ���.");
					modify_choice2 = scan.nextInt();
					
					if (modify_choice2==5) {
						System.out.printf("%s�л��� ���� �۾��� �����մϴ�.\n", student_name[modify_index]);
						break;
					}
					
					if(modify_choice2==1) {
						System.out.printf("%s�л��� �̸� ���� >> ", student_name[modify_index]);
						student_name[modify_index] = scan.next();
					} else if (modify_choice2==2) {
						System.out.printf("%s�л��� ����� ���� >>", student_name[modify_index]);
						kor[modify_index] = scan.nextInt();
					} else if (modify_choice2==3) {
						System.out.printf("%s�л��� ����� ���� >> ", student_name[modify_index]);
						eng[modify_index] = scan.nextInt();
					} else if (modify_choice2==4) {
						System.out.printf("%s�л��� ���м��� ���� >> ", student_name[modify_index]);
						math[modify_index] = scan.nextInt();
					}
					
					total[modify_index] = kor[modify_index] + eng[modify_index] + math[modify_index];
					avg[modify_index] = (double)total[modify_index]/3;
					
					switch((int)avg[modify_index]/10) {
					case 10:
						grade[modify_index]="A+"; break;
					case 9:
						grade[modify_index]="A"; break;
					case 8:
						grade[modify_index]="B"; break;
					case 7:
						grade[modify_index]="C"; break;
					case 6:
						grade[modify_index]="D"; break;
					default:
						grade[modify_index]="F";
					}
					
					System.out.printf("\n%s�л��� ������ ������ ������ �����ϴ�.\n", student_name[modify_index]);
					System.out.printf("����\t����\t����\t����\t����\t���\t����\t���\n");
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
							student_name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
					System.out.println("--- ���� �Ϸ� ---");
					System.out.println("\n��� �����Ͻðڽ��ϱ�? (y/n)");
					modify_choice3 = scan.next().charAt(0);
					if(modify_choice3=='y')
						continue;
					else if (modify_choice3=='n')
						break;
				}
			}
			
			// Delete
			else if (choice==5) {
				if(size<=0) {
					System.out.println("���� �����ͺ��̽��� ����� �л��� ���� �� �� �������� �ʽ��ϴ�.");
					System.out.println("�л� ������ Ȯ�����ֽ� �� �õ����ּ���.\n");
					continue;
				}
				
				while(true) {
					if(size<=0) {
						System.out.println("���� �����ͺ��̽��� ����� �л��� ���� �� �� �������� �ʽ��ϴ�.");
						System.out.println("�л� ������ Ȯ�����ֽ� �� �õ����ּ���.\n");
						break;
					}
					
					System.out.println("������ �л� �̸��� �Է��ϼ���.");
					delete_name = scan.next();
					for(j=0;j<size;j++) {
						if(delete_name.equals(student_name[j])) {
							delete_index=j;
							flag=1;
							break;
						}
					}
					
					if(flag==0) {
						System.out.printf("%s �л��� �����ʹ� �������� �ʽ��ϴ�.\n", delete_name);
						System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�? (y/n)");
						delete_choice = scan.next().charAt(0);
						if(delete_choice=='y') {
							continue;
						} else if (delete_choice=='n') {
							break;
						}
					}
					
					flag=0;
					
					// ������ �����Ѵ�. ����� �켱 �ϳ� ���̰�
					size = size-1;
					// ���ο� �ӽ� �迭�� �����ϰ�
					del_temp_name = new String[size];
					del_temp_kor = new int[size];
					del_temp_eng = new int[size];
					del_temp_math = new int[size];
					del_temp_total = new int[size];
					del_temp_avg = new double[size];
					del_temp_grade = new String[size];
					del_temp_rank = new int[size];
					
					// 0���� delete_index ������(j<delete_index)�� �״�� ���� �����ϰ�
					for(j=0;j<delete_index;j++) {
						del_temp_name[j] = student_name[j];
						del_temp_kor[j] = kor[j];
						del_temp_eng[j] = eng[j];
						del_temp_math[j] = math[j];
						del_temp_total[j] = total[j];
						del_temp_avg[j] = avg[j];
						del_temp_grade[j] = grade[j];
						del_temp_rank[j] = rank[j];
					}
					
					// �л������迭���� ������ �ε����� �� ĭ�� ���� �ű� ��
					for(j=delete_index;j<size;j++) {
						student_name[j] = student_name[j+1];
						kor[j] = kor[j+1];
						eng[j] = eng[j+1];
						math[j] = math[j+1];
						total[j] = total[j+1];
						avg[j] = avg[j+1];
						grade[j] = grade[j+1];
						rank[j] = rank[j+1];
					}
					
					// temp �迭�� �������� ���� �ű��.
					for(j=delete_index;j<size;j++) {
						del_temp_name[j] = student_name[j];
						del_temp_kor[j] = kor[j];
						del_temp_eng[j] = eng[j];
						del_temp_math[j] = math[j];
						del_temp_total[j] = total[j];
						del_temp_avg[j] = avg[j];
						del_temp_grade[j] = grade[j];
						del_temp_rank[j] = rank[j];
					}
					// �� �� �л������迭�� ���Ӱ� �����ϰ�
					student_name = new String[size];
					kor = new int[size];
					eng = new int[size];
					math = new int[size];
					total = new int[size];
					avg = new double[size];
					grade = new String[size];
					rank = new int[size];
					
					// temp �迭�� �����͸� ���� �л������迭�� �ٽ� �ű��.
					for(j=0;j<size;j++) {
						student_name[j] = del_temp_name[j];
						kor[j] = del_temp_kor[j];
						eng[j] = del_temp_eng[j];
						math[j] = del_temp_math[j];
						total[j] = del_temp_total[j];
						avg[j] = del_temp_avg[j];
						grade[j] = del_temp_grade[j];
						rank[j] = del_temp_rank[j];
					}
					
					temp_avg_rank = new double[size];
					for(j=0;j<size;j++)
						temp_avg_rank[j]=avg[j];
					
					max=0;
					save_index=0;
					rank_count=1;
					for(j=0;j<size;j++) {
						for(k=0;k<size;k++) {
							if(temp_avg_rank[k]>max) {
								max = temp_avg_rank[k];
								save_index=k;
							}
						}
						temp_avg_rank[save_index]=-1;
						rank[save_index]=rank_count++;
						max=0;
					}
					
					System.out.println("�����۾� ���� �� �л� ������ ������ �����ϴ�.");
					System.out.printf("����\t����\t����\t����\t����\t���\t����\t���\n");
					for(j=0;j<size;j++) {
						System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
								student_name[j], kor[j], eng[j], math[j], total[j], avg[j], grade[j], rank[j]);
					}
					System.out.println("--- ���� �Ϸ� ---");
					System.out.println("��� �����Ͻðڽ��ϱ�? (y/n)");
					delete_choice2 = scan.next().charAt(0);
					if(delete_choice2=='y')
						continue;
					else if (delete_choice2=='n')
						break;
				}
			}
			
			// rank ������Ʈ�ϱ�
			// ����� ������ �Էµ� ������� ������ �ű� ��
			// ����� ���� �� �Էµ� ������� ������ �ű����
			// avg�迭�� �Ȱ��� ���� �� �ִ� �ӽ���չ迭�� �ϳ� ���Ӱ� �����ϰ� ����
			// �ӽ���չ迭���� max���� �ش� �ε����� �����ϰ�
			// �� �ε����� ��ġ�ϴ� rank �ε��� �ڸ��� ������ �ű��
			// �ӽ���չ迭���� ����� �ε����� -1 ���� �ָ� �� ��.
			temp_avg_rank = new double[size];
			for(j=0;j<size;j++)
				temp_avg_rank[j]=avg[j];
			
			max=0;
			save_index=0;
			rank_count=1;
			for(j=0;j<size;j++) {
				for(k=0;k<size;k++) {
					if(temp_avg_rank[k]>max) {
						max = temp_avg_rank[k];
						save_index=k;
					}
				}
				temp_avg_rank[save_index]=-1;
				rank[save_index]=rank_count++;
				max=0;
			}	
		} // ��ü ���α׷� �ݺ��� ��
	}
}
