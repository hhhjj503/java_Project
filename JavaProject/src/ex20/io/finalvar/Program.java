package ex20.io.finalvar;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		final int SIZE =3;
		int[] kors = new int[SIZE];
		final int MENU_INPUT = 1;
		final int MENU_PRINT = 2;
		final int EXIT = 3;
		
		for(int i = 0 ; i <3;i++) {
			kors[i] = 1;
		}
		
		int j = 0;
		int t = 00;
		quit : 
			while(true) {
		 // ----------성적 입력 부분-----------------------------------
			System.out.println("시작입니다!");
			System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
			System.out.println("│              \\  메인 메뉴       │");
			System.out.println("└──────────────────────────────┘");
			
			System.out.println("\t1.성적입력");
			System.out.println("\t2.성적출력");
			System.out.println("\t3.종료");
			System.out.println("\t번호입력>");
			int menu = scan.nextInt();
			
			switch(menu) {
			
			case MENU_INPUT :
				 // ----------성적 입력 부분-----------------------------------
					System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
					System.out.println("│              \\  성적 입력       │");
					System.out.println("└──────────────────────────────┘");
					
					for(int i =0;i<SIZE;i++)
					do {
						System.out.printf("국어%d 성적 : \n", i);
						kors[i] = scan.nextInt();
							if(kors[i] < 0 || kors[i] > 100) 
								System.out.println("0~100 범위만 입력하세요!");
					}while (t < 0 || t > 100);
					
			case MENU_PRINT :
					// ----------성적 출력 부분-----------------------------------
					System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
					System.out.println("│              \\  성적 출력       │");
					System.out.println("└──────────────────────────────┘");
			
					for(int i = 0; i < SIZE;i++) {
						System.out.printf("\t국어성적%d : %d\n", i, kors[i]);
					}
					break;
			case EXIT : 
				//프로그램 강제종료 System.exit(0);
				System.out.println("Bye~~Bye~~");
				break quit;
			default : 
				System.out.println("입력오류!! 1~3 까지만 입력해주세요!");
			}//switch
		} //while
	} //main
} //class