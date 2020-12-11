package part2.ex.parting;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		Boolean loop = true;
		int[] kors = new int[3];
		quit : 
			while(loop) {
			int menu = menu();
			
				switch(menu) {
				case 1 :
				insertScores(kors); //insertScores 에 kors 의 참조매핑주소값을 넘겨줌
				break;
				case 2 :
				printScores(kors); ////kors 의 참조매핑 주소값을 넘겨줌
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
	
	static void insertScores(int[] kor) {
		 // ----------���� �Է� �κ�-----------------------------------
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적입력      |");
		System.out.println("----------------------------");
		int kor1 =0;
		for(int i = 0;i <3;i++) { 
			do {
					System.out.printf("국어 %d 성적 : ", i+1);
					kor1 = scan.nextInt(); 
			}while(kor1 < 0 || kor1 > 100);
			
			kor[i] = kor1;
		}
	}

	static void printScores(int[] kor) {
		// ----------���� ��� �κ�-----------------------------------
		System.out.println("-----------------------------"); // print() = wtite() + flush()
		System.out.println("|             \\ 성적입력      |");
		System.out.println("----------------------------");
		
		for(int i = 0; i < 3;i++) {
			System.out.printf("\t국어%d점수 : %d\n", i, kor[i]);
		}
		int total = kor[0] +kor[1] + kor[2];
		float avg = total/3.0f;
		System.out.printf("총점 : %3d\n", total);
		System.out.printf("평균 : %.2f\n", avg);
	}
	
} //class