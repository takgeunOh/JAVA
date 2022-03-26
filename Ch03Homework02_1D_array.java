package day12.homework;

import java.util.Scanner;

//주말과제(2)
//성적 출력 프로그램 만들기
/*
----- 성적 관리 프로그램 -----			
// 삭제는 검색해서 해당하는 사람 지우기 (삭제된 애 뒤에 애들은 앞으로 땡기기), 1차원이든 2차원이든 써먹기
// 수정은 이름 중복이 없다는 가정 하에 입력을 받게 하는데 중복 체크 가능하면 구현해보기
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 1
성명 : 홍길동
국어점수 : 80
영어점수 : 80
수학점수 : 80
--- 입력 완료 ---
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 2
성명	국어	영어	수학	총점	평균	학점	등수
홍길동	80	80	80	240	80.0	B	1
--- 출력 완료 ---
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 1
성명 : 김길동
국어점수 : 80
영어점수 : 80
수학점수 : 80
--- 입력 완료 ---
1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End
Choice : 3
검색할 이름 : 홍길동
성명	국어	영어	수학	총점	평균	학점	등수
홍길동	80	80	80	240	80.0	B	1
--- 출력 완료 ---
*/

public class Ch03Homework02_1D_array {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 사이즈, 인덱스 관련 변수들
		int size=0;
		int i=-1,j=0, k=0;
		
		// 진짜 학생 정보를 저장하는 배열
		String[] student_name= {,};
		int[] kor= {0,}, eng= {0,}, math= {0,}, total= {0,}, rank= {0,};
		double[] avg= {0,};
		String[] grade= {,};
		
		// 추가, 삭제 전에 임시로 학생 정보를 저장하는 배열
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
		
		// 조작 관련 변수들
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
		
		System.out.println("---- 성적 관리 프로그램 ----");
		
		while(true) {
			System.out.println("\n원하시는 조작을 입력해주세요.");
			System.out.println("1) Input	2) Output	3) Search	4)Modify	5)Delete	6)End");
			System.out.print("Choice :");
			choice = scan.nextInt();
			if(choice==6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			// input
			if(choice==1) {
				i++;					// 0 1 2 ...
				size++;					// 1 2 3 ...
				
				// 배열의 크기를 input 때마다 재할당해야하는데
				// 단순히 new int[count] 이런 식으로 하면 입력 전의 인덱스값이 모두 초기화가 된다.
				// 음... 그러면 배열의 크기를 하나 더 늘린 새로운 배열을 만들고
				// 새로운 배열에 기존의 배열(temp)의 값들을 복사하고
				// 마지막 인덱스에 새로운 값을 집어넣는 식으로 해보자.
				
				// 사이즈가 하나씩 늘어난 새로운 배열 생성
				student_name = new String[size];
				kor = new int[size];
				eng = new int[size];
				math = new int[size];
				total = new int[size];
				avg = new double[size];
				grade = new String[size];
				rank = new int[size];
				
				// 새로운 배열에 기존의 배열 각각의 인덱스에 들어가 있는 요소들을 복사
				for(j=0;j<size-1;j++) {						
					// 첫 입력 때에는 값 복사가 이루어지지 않고
					// 기존의 배열 사이즈는 이 반복문이 이루어질 당시 size값보다 1 작음
					student_name[j] = temp_name[j];
					kor[j] = temp_kor[j];
					eng[j] = temp_eng[j];
					math[j] = temp_math[j];
					total[j] = temp_total[j];
					avg[j] = temp_avg[j];
					grade[j] = temp_grade[j];
					rank[j] = temp_rank[j];
				}
				
				System.out.print("성명 : ");
				student_name[i] = scan.next();
				for(j=0;j<size;j++) {
					if(student_name[i].equals(student_name[j])) {
						count++;
					}
				}
				// count가 2이상이면 중복이름 입력했다고 판별
				while(count>=2) {
					System.out.println(count);
					System.out.println("이미 등록되어있는 회원 이름입니다.");
					System.out.println("다시 입력하시려면 y, 조작 메뉴로 나가시려면 n을 눌러주세요.");
					input_choice=scan.next().charAt(0);
					if(input_choice=='y') {
						System.out.print("성명 : ");
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
				System.out.print("국어점수 : ");
				kor[i] = scan.nextInt();
				System.out.print("영어점수 : ");
				eng[i] = scan.nextInt();
				System.out.print("수학점수 : ");
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
				
				// temp 배열 크기도 하나씩 증가하면서 새로 생성해주고 (값들도 모두 초기화)
				temp_name = new String[size];
				temp_kor = new int[size];
				temp_eng = new int[size];
				temp_math = new int[size];
				temp_total = new int[size];
				temp_avg = new double[size];
				temp_grade = new String[size];
				temp_rank = new int[size];
				// 거기에 값을 다시 복사
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
				System.out.println("--- 입력 완료 ---");
			}
			
			//output
			else if (choice==2) {
				/*
				성명	국어	영어	수학	총점	평균	학점	등수
				홍길동	80	80	80	240	80.0	B	1
				*/
				
				// 아무 정보도 들어있지 않을 때 output 명령 시
				// i=-1, size=0
				if(size<=0) {
					System.out.println("\n현재 데이터베이스에 저장된 학생이 현재 한 명도 존재하지 않습니다.");
					System.out.println("학생 정보를 확인해주신 후 시도해주세요.\n");
					continue;
				}
				
				System.out.println("성명" + "\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" +
				"총점" + "\t" + "평균" + "\t" + "학점" + "\t" + "등수");
				for(j=0;j<size;j++) {
					/*
					System.out.println(student_name[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + math[i] + "\t" 
							+ total[i] + "\t" + avg[i] + "\t" + grade[i] + "\t" + rank[i]);
					*/
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n", 
							student_name[j], kor[j], eng[j], math[j], total[j], avg[j], grade[j], rank[j]);
				}
				System.out.println("--- 출력 완료 ---");
			}
			
			//Search
			else if (choice==3) {
				/*
				검색할 이름 : 홍길동
				성명	국어	영어	수학	총점	평균	학점	등수
				홍길동	80	80	80	240	80.0	B	1
				*/
				
				if(size<=0) {
					System.out.println("현재 데이터베이스에 저장된 학생이 현재 한 명도 존재하지 않습니다.");
					System.out.println("학생 정보를 확인해주신 후 시도해주세요.\n");
					continue;
				}
				
				while(true) {
					System.out.print("검색할 이름 : ");
					search_name = scan.next();
					
					for(i=0;i<size;i++) {
						if(search_name.equals(student_name[i])) {
							flag=1;
							break;
						}
					}
					if(flag==0) {
						System.out.println("그런 사람은 없습니다. 이름을 다시 확인해주시고 입력해주세요.");
						System.out.print("계속 검색하시겠습니까? (y/n) >> ");
						search_choice = scan.next().charAt(0);
						if(search_choice=='n')
							break;
						continue;
					}
					
					flag=0;
					
					for(i=0;i<size;i++) {
						if(search_name.equals(student_name[i])) {
							System.out.printf("성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
							System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
									student_name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
							break;
						}
					}
					
					System.out.println("--- 검색 완료 ---");
					
					System.out.print("계속 검색하시겠습니까? (y/n) >> ");
					search_choice = scan.next().charAt(0);
					if(search_choice=='n')
						break;
				}
			}
			
			// Modify
			else if (choice==4) {
				if(size<=0) {
					System.out.println("현재 데이터베이스에 저장된 학생이 현재 한 명도 존재하지 않습니다.");
					System.out.println("학생 정보를 확인해주신 후 시도해주세요.\n");
					continue;
				}
				
				while(true) {
					System.out.println("정보를 수정할 학생 이름을 입력하세요.");
					modify_name = scan.next();
					for(j=0;j<size;j++) {
						if(modify_name.equals(student_name[j])) {
							modify_index = j;
							flag=1;
							break;
						}
					}
					
					if(flag==0) {
						System.out.println("해당 학생은 데이터에 존재하지 않습니다.");
						System.out.print("다시 입력하시겠습니까? (y/n) >> ");
						modify_choice1 = scan.next().charAt(0);
						
						if(modify_choice1=='y')
							continue;
						else if (modify_choice1=='n')
							break;
					}
					
					flag=0;
					
					System.out.printf("%s학생의 어떤 정보를 수정하시겠습니까?\n", student_name[modify_index]);
					System.out.printf("%s학생의 정보는 다음과 같습니다.\n", student_name[modify_index]);
					System.out.printf("성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
							student_name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
					System.out.println();
					System.out.println("(이름 : 1, 국어성적 : 2, 영어성적 : 3, 수학성적 : 4, 그만 : 5)");
					System.out.println("원하는 번호를 입력해주세요.");
					modify_choice2 = scan.nextInt();
					
					if (modify_choice2==5) {
						System.out.printf("%s학생의 수정 작업을 종료합니다.\n", student_name[modify_index]);
						break;
					}
					
					if(modify_choice2==1) {
						System.out.printf("%s학생의 이름 수정 >> ", student_name[modify_index]);
						student_name[modify_index] = scan.next();
					} else if (modify_choice2==2) {
						System.out.printf("%s학생의 국어성적 수정 >>", student_name[modify_index]);
						kor[modify_index] = scan.nextInt();
					} else if (modify_choice2==3) {
						System.out.printf("%s학생의 영어성적 수정 >> ", student_name[modify_index]);
						eng[modify_index] = scan.nextInt();
					} else if (modify_choice2==4) {
						System.out.printf("%s학생의 수학성적 수정 >> ", student_name[modify_index]);
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
					
					System.out.printf("\n%s학생의 수정된 정보는 다음과 같습니다.\n", student_name[modify_index]);
					System.out.printf("성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
							student_name[i], kor[i], eng[i], math[i], total[i], avg[i], grade[i], rank[i]);
					System.out.println("--- 수정 완료 ---");
					System.out.println("\n계속 수정하시겠습니까? (y/n)");
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
					System.out.println("현재 데이터베이스에 저장된 학생이 현재 한 명도 존재하지 않습니다.");
					System.out.println("학생 정보를 확인해주신 후 시도해주세요.\n");
					continue;
				}
				
				while(true) {
					if(size<=0) {
						System.out.println("현재 데이터베이스에 저장된 학생이 현재 한 명도 존재하지 않습니다.");
						System.out.println("학생 정보를 확인해주신 후 시도해주세요.\n");
						break;
					}
					
					System.out.println("삭제할 학생 이름을 입력하세요.");
					delete_name = scan.next();
					for(j=0;j<size;j++) {
						if(delete_name.equals(student_name[j])) {
							delete_index=j;
							flag=1;
							break;
						}
					}
					
					if(flag==0) {
						System.out.printf("%s 학생의 데이터는 존재하지 않습니다.\n", delete_name);
						System.out.println("다시 입력하시겠습니까? (y/n)");
						delete_choice = scan.next().charAt(0);
						if(delete_choice=='y') {
							continue;
						} else if (delete_choice=='n') {
							break;
						}
					}
					
					flag=0;
					
					// 삭제를 진행한다. 사이즈를 우선 하나 줄이고
					size = size-1;
					// 새로운 임시 배열을 생성하고
					del_temp_name = new String[size];
					del_temp_kor = new int[size];
					del_temp_eng = new int[size];
					del_temp_math = new int[size];
					del_temp_total = new int[size];
					del_temp_avg = new double[size];
					del_temp_grade = new String[size];
					del_temp_rank = new int[size];
					
					// 0부터 delete_index 전까지(j<delete_index)는 그대로 값을 복사하고
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
					
					// 학생정보배열에서 삭제할 인덱스로 한 칸씩 위로 옮긴 후
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
					
					// temp 배열로 나머지를 마저 옮긴다.
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
					// 이 후 학생정보배열을 새롭게 생성하고
					student_name = new String[size];
					kor = new int[size];
					eng = new int[size];
					math = new int[size];
					total = new int[size];
					avg = new double[size];
					grade = new String[size];
					rank = new int[size];
					
					// temp 배열의 데이터를 전부 학생정보배열로 다시 옮긴다.
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
					
					System.out.println("삭제작업 진행 후 학생 정보는 다음과 같습니다.");
					System.out.printf("성명\t국어\t영어\t수학\t총점\t평균\t학점\t등수\n");
					for(j=0;j<size;j++) {
						System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%d\n",
								student_name[j], kor[j], eng[j], math[j], total[j], avg[j], grade[j], rank[j]);
					}
					System.out.println("--- 삭제 완료 ---");
					System.out.println("계속 삭제하시겠습니까? (y/n)");
					delete_choice2 = scan.next().charAt(0);
					if(delete_choice2=='y')
						continue;
					else if (delete_choice2=='n')
						break;
				}
			}
			
			// rank 업데이트하기
			// 평균이 같으면 입력된 순서대로 순위를 매길 것
			// 평균이 같을 때 입력된 순서대로 순위를 매기려면
			// avg배열을 똑같이 담을 수 있는 임시평균배열을 하나 새롭게 생성하고 복사
			// 임시평균배열에서 max값과 해당 인덱스를 추출하고
			// 그 인덱스와 일치하는 rank 인덱스 자리에 순위를 매기고
			// 임시평균배열에서 추출된 인덱스는 -1 값을 주면 될 듯.
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
		} // 전체 프로그램 반복문 끝
	}
}
