package ex16.io.marray2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//int kor = 0;
		int[][] kors = new int[3][3];
		for(int j = 3; j <3;j++)
		for(int i = 0 ; i <3;i++) {
			kors[j][i] = 0;
		}
		
		//int total = kor + j + t;

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
			
			case 1 :
				 // ----------성적 입력 부분-----------------------------------
					System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
					System.out.println("│              \\  성적 입력       │");
					System.out.println("└──────────────────────────────┘");
					for(int j = 0; j<3;j++)
					for(int i =0;i<3;i++)
					do {
						System.out.printf("%d학년 국어%d 성적 : \n", j+1, j+1);
						kors[j][i] = scan.nextInt();
							if(kors[j][i] < 0 || kors[j][i] > 100) 
								System.out.println("0~100 범위만 입력하세요!");
					}while (kors[j][i] < 0 || kors[j][i] > 100);
					
			case 2 :
					// ----------성적 출력 부분-----------------------------------
					System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
					System.out.println("│              \\  성적 출력       │");
					System.out.println("└──────────────────────────────┘");
					
					int total = 0;
					float avg = 0;
					
					for(int j = 0; j <3;j++) {
						System.out.printf("-------\t%d학년---------\n", j+1);
					for(int i = 0; i < 3;i++) {
						System.out.printf("국어 %d 학년 %d번쨰 : %d\n", j+1,i+1, kors[j][i]); 		
					}
					
					for(int i = 0; i <3 ; i++)
						total += kors[j][i];
					avg = (float)(total/3.0);
					System.out.printf("\t총합 : %d\n", total);
					System.out.printf("\t평균 :%5.2f\n", avg);
					System.out.printf("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n");
					total = 0;
					avg = 0;
					}
					
					break;
			case 3 : 
				//프로그램 강제종료 System.exit(0);
				System.out.println("Bye~~Bye~~");
				break quit;
			default : 
				System.out.println("입력오류!! 1~3 까지만 입력해주세요!");
			}//switch
		} //while
	} //main
} //class