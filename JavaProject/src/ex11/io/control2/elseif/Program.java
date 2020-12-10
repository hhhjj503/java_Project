package ex11.io.control2.elseif;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int kor = 0;
		int j = 0;
		int t = 00;
		int total = kor + j + t;
		float avg = total/3.0f;

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
			
			if(menu == 1) {
				 // ----------성적 입력 부분-----------------------------------
					System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
					System.out.println("│              \\  성적 입력       │");
					System.out.println("└──────────────────────────────┘");
					do {
					System.out.println("국어1 성적 : ");
					kor = scan.nextInt();
						if(kor < 0 || kor > 100) 
							System.out.println("0~100 범위만 입력하세요!");
					}while (kor < 0 || kor > 100);
					
					do {
						System.out.println("국어2 성적 : ");
						j = scan.nextInt();
							if(j < 0 || j > 100) 
								System.out.println("0~100 범위만 입력하세요!");
					}while (j < 0 || j > 100);
						
					do {
						System.out.println("국어3 성적 : ");
						t = scan.nextInt();
							if(t < 0 || t > 100) 
								System.out.println("0~100 범위만 입력하세요!");
					}while (t < 0 || t > 100);
					
					total = kor + j + t;
					avg = total/3.0f;		
			} else if(menu==2) {
					// ----------성적 출력 부분-----------------------------------
					System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
					System.out.println("│              \\  성적 출력       │");
					System.out.println("└──────────────────────────────┘");
			
					for(int i = 0; i < 3;i++) {
						System.out.printf("\t국어성적%d : %d\n", i, kor);
					}
					System.out.printf("총점 : %3d\n", total);
					System.out.printf("평균 : %.2f\n", avg);
			} else if(menu==3) {
				//프로그램 강제종료 System.exit(0);
				System.out.println("Bye~~Bye~~");
				break;
			} else {
				System.out.println("입력오류!! 1~3 까지만 입력해주세요!");
			}
		} //while
	} //main
} //class