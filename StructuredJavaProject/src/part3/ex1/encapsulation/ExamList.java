package part3.ex1.encapsulation;

import java.util.Scanner;

public class ExamList {

	Exam[] exams;
	int current;
	
	static void insertList(ExamList list,int current) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적입력      |");
		System.out.println("----------------------------");
		
			int kor,eng,math;
			Exam exam = new Exam();
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
			
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;
			
			int capacity = list.exams.length;
			Exam[] origin = list.exams;
			
			if(capacity == current) {
				
				int amount = 5;
				Exam[] temp = new Exam[amount+capacity];
				
				for(int i = 0; i < capacity;i++) {
					temp[i] = origin[i];
				}
				list.exams = temp;
			}
			
			list.exams[list.current] = exam;
			list.current++; 
			scan.close();
	}
	
	static void printList(ExamList list) { 
		printList(list, list.current);
	}
	
	private static void printList(ExamList list, int size) { 
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적출력      |");
		System.out.println("----------------------------");
		Exam[] exams = list.exams;
		for(int i = 0 ; i < size; i++) {
			int kor = exams[i].kor;
			int eng = exams[i].eng;
			int math = exams[i].math;
			int total = kor + eng + math;
			float avg = total/3.0f;
			
			System.out.printf("\t국어점수 : %d\n", kor);
			System.out.printf("\t영어점수 : %d\n", eng);
			System.out.printf("\t수학점수 : %d\n", math);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %5.2f\n", avg);
			System.out.println("------------------------\n");
	 	}
	}

	
	public static void init(ExamList list) {
		// TODO Auto-generated method stub
		list.exams = new Exam[3];
		list.current = 0;
	}
}
