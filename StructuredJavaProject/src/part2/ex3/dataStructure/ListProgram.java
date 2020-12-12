package part2.ex3.dataStructure;

import java.util.Scanner;

public class ListProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExamList list = new ExamList();
		list.exam = new Exam[3];
		Boolean loop = true;
		list.current = 0;
		
		quit :
			while(loop) {
			int menu = menu();
			
				switch(menu) {
				case 1 :
				insertList(list, list.current); //insertScores 에 kors 의 참조매핑주소값을 넘겨줌
				break;
				case 2 :
				printList(list);
				break;
				case 3 : 
					//강제종료 System.exit(0);
					System.out.println("Bye~~Bye~~");
					break quit;
				default : 
					System.out.println("1~3 사이의 숫자만 입력하세요!");
			}//switch
		} //while
	} //main
	
	private static void insertList(ExamList list,int current) {
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
			
			int capacity = list.exam.length;
			Exam[] origin = list.exam;
			
			if(capacity == current) {
				
				int amount = 5;
				Exam[] temp = new Exam[amount+capacity];
				
				for(int i = 0; i < capacity;i++) {
					temp[i] = origin[i];
				}
				list.exam = temp;
			}
			
			list.exam[list.current] = exam;
			list.current++; 
			scan.close();
	}
	
	private static void printList(ExamList list) { 
		printList(list, list.current);
	}
	
	private static void printList(ExamList list, int size) { 
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적출력      |");
		System.out.println("----------------------------");
		Exam[] exams = list.exam;
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

	static int menu() {
		// ----------���� �Է� �κ�-----------------------------------
					System.out.println("-----------------------------"); // print() = wtite() + flush()
					System.out.println("|             \\메인메뉴      |");
					System.out.println("----------------------------");
					
					System.out.println("\t1.성적입력");
					System.out.println("\t2.성적출력");
					System.out.println("\t3.종료");
					System.out.println("\t메뉴선택>");
					Scanner scan = new Scanner(System.in);
					int menu = scan.nextInt();
					scan.close();
					return menu;
	}

}
