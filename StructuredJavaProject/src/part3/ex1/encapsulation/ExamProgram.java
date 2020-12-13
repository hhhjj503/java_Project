package part3.ex1.encapsulation;

import java.util.Scanner; 

import part3.ex1.encapsulation.Exam;

public class ExamProgram {
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		Boolean loop = true;
		int[] kors = new int[3];
		int[] engs = new int[3];
		int[] maths = new int[3];
		int menu =0;
		Exam exam = new Exam();
		Boolean chk = true;
		//inputKor();
		//inputEng();
		//inputMath();
		
		quit:
		while(chk) {
			
			menu = inputMenu();
			
			switch(menu) {
			case 1 :
				input(exam);
				break;
			case 2:
				print(exam);
				break;
			case 3 :
				System.out.println("종료됩었습니다");
				chk = false;
				break quit;
			default :
				System.out.println("1~3 사이의 번호만 입력해주세요.");
			}
		}
	} //main

	private static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("-------메뉴입니다-----");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택해주세요 > " );
		int menu = scan.nextInt();
		return menu;
		
	}

	private static void print(Exam exam) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적출력      |");
		System.out.println("----------------------------");
		System.out.println();
		
		int kor = exam.kor;
		int eng = exam.eng;
		int math = exam.math;
		
		int total = kor + eng + math;
		float avg = total/3.0f;
		
		System.out.printf("\t국어 : %d\n", kor);
		System.out.printf("\t영어 : %d\n", eng);
		System.out.printf("\t수학 : %d\n", math);
		
		System.out.printf("\t총점 ㅣ %d\n",total);
		System.out.printf("\t평균 : %5.2f\n" , avg);
		
	}

	private static void input(Exam exam) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적입력      |");
		System.out.println("----------------------------");
		
		int kor = 0;
		int eng = 0 ;
		int math = 0;
		 
		do {
			System.out.printf("국어 성적 : ");
			kor = scan.nextInt();
			if(kor < 0 || kor > 100)
			System.out.println("국어 성적은 0~100 사이만 입력해주세요");
		}while(kor < 0 || kor > 100);
		do {
			System.out.printf("영어 성적 : ");
			eng = scan.nextInt(); 
			if(kor < 0 || kor > 100)
			System.out.println("영어 성적은 0~100 사이만 입력해주세요");
		}while(eng < 0 || eng > 100);
		do {
			System.out.printf("수학 성적 : ");
			math = scan.nextInt(); 
			if(kor < 0 || kor > 100)
			System.out.println("수학 성적은 0~100 사이만 입력해주세요");
		}while(math < 0 || math > 100);
		
		exam.kor= kor;
		exam.eng = eng;
		exam.math = math;
	}
	
	
	
} //class