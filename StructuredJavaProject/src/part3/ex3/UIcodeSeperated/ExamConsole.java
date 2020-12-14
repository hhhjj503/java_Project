package part3.ex3.UIcodeSeperated;

import java.util.Scanner;

public class ExamConsole {
	
	private ExamList list = new ExamList();
	
	public int menu() { 
		// ----------���� �Է� �κ�-----------------------------------
					System.out.println("-----------------------------"); // print() = wtite() + flush()
					System.out.println("|             \\메인메뉴      |");
					System.out.println("----------------------------");
					
					System.out.println("\t1.성적입력");
					System.out.println("\t2.성적출력");
					System.out.println("\t3.종료");
					System.out.println("\t메뉴선택>");
					int menu = 0;
					Scanner scan = new Scanner(System.in);
					menu = scan.nextInt();
					return menu;
	}
	
	public void insertList() {
		// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			System.out.println("-----------------------------"); // print() = wtite() + flush()
			System.out.println("|             \\ 성적입력      |");
			System.out.println("----------------------------");
				int kor, eng, math;
			
				do {
					System.out.printf("국어 성적 : ");
					kor = scan.nextInt();
				}while(kor < 0 || kor > 100);
				do {
					System.out.printf("영어 성적 : ");
					eng = scan.nextInt(); 
				}while(eng < 0 || eng > 100);
				do {
					System.out.printf("수학 성적 : ");
					math = scan.nextInt();
					System.out.println("성적을 모두 입력했습니다.");
				}while(math < 0 || math > 100);

				Exam exam = new Exam(kor, eng, math); 
				
				list.add(exam);
		}
		
	public void printList() { 
		printList(list.getSize());
	}
	
	public void printList(int size) { 
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적출력      |");
		System.out.println("----------------------------");
		
		for(int i = 0 ; i < size; i++) {
			
			Exam exam = list.getExam(i);
			
			int total = exam.getTotal();
			float avg = exam.getAvg();
			
			System.out.printf("\t국어점수 : %d\n", exam.getKorr());
			System.out.printf("\t영어점수 : %d\n", exam.getEng());
			System.out.printf("\t수학점수 : %d\n", exam.getMath());
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %5.2f\n", avg);
			System.out.println("------------------------\n");
	 	}
	}
}
