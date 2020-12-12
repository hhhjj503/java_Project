package part2.ex3.dataStructure;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exam[] exams= new Exam[3];
		Boolean loop = true;
		int current = 0;
		
		quit :
			while(loop) {
			int menu = menu();
			
				switch(menu) {
				case 1 :
				insertList(exams, current); //insertScores 에 kors 의 참조매핑주소값을 넘겨줌
				break;
				case 2 :
				printList(exams, current); ////kors 의 참조매핑 주소값을 넘겨줌
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
	
	private static void insertList(Exam[] exams,int current) {
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
			exams[current] = exam;
			current++;
	}

	private static void printList(Exam[] exams, int size) { 
		// TODO Auto-generated method stub
		// ----------���� ��� �κ�-----------------------------------
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적출력      |");
		System.out.println("----------------------------");
		for(int i = 0 ; i < size; i++) {
			Exam exam = exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
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
					return menu;
	}

}
