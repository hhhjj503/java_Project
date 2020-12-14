package part3.ex2.method;

import java.util.Scanner;

public class ExamList {

	private Exam[] exams;
	private int current;
	private int menu;
	
	
	//객체 + ()함수
	public ExamList() {
		this(3);
	}
	
	public ExamList(int size) {
		this.exams = new Exam[size];
		this.current = 0;
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
			
			int capacity = exams.length;
			Exam[] origin = exams;
			
			if(capacity == current) {
				
				int amount = 5;
				Exam[] temp = new Exam[amount+capacity];
				
				for(int i = 0; i < capacity;i++) {
					temp[i] = origin[i];
				}
				exams = temp;
			}
			
			exams[this.current] = exam;
			current++; 
	}
	
	public void printList() { 
		printList(this.current);
	}
	
	public void printList(int size) { 
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적출력      |");
		System.out.println("----------------------------");
		Exam[] exams = this.exams;
		for(int i = 0 ; i < size; i++) {
			int total = exams[i].getTotal();
			float avg = exams[i].getAvg();
			
			System.out.printf("\t국어점수 : %d\n", exams[i].getKorr());
			System.out.printf("\t영어점수 : %d\n", exams[i].getEng());
			System.out.printf("\t수학점수 : %d\n", exams[i].getMath());
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %5.2f\n", avg);
			System.out.println("------------------------\n");
	 	}
	}

	public int menu() { 
		// ----------���� �Է� �κ�-----------------------------------
					System.out.println("-----------------------------"); // print() = wtite() + flush()
					System.out.println("|             \\메인메뉴      |");
					System.out.println("----------------------------");
					
					System.out.println("\t1.성적입력");
					System.out.println("\t2.성적출력");
					System.out.println("\t3.종료");
					System.out.println("\t메뉴선택>");
					Scanner scan = new Scanner(System.in);
					this.menu = scan.nextInt();
					return this.menu;
	}
}
