/*
 * 저작권 정보 :
 * 작성일: ..
 * */


package ex8.io.control2.dowhile;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int kor = 0;
		int j = 0;
		int t = 00;
		
		Scanner scan = new Scanner(System.in);
		
		int total = 0;
		float avg = total/3.0f;

	while(true)
		{ // ----------성적 입력 부분-----------------------------------
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
			
			// ----------성적 출력 부분-----------------------------------
			System.out.println("┌──────────────────────────────┐"); // print() = wtite() + flush()
			System.out.println("│              \\  성적 출력       │");
			System.out.println("└──────────────────────────────┘");
	
			// % n$ +(right),-(left) width precision(.00..) conversion(d,f,x,..)
			System.out.printf("%1$d %1$d %1$d\n", 1);
			
			int i = 0;
			while(i < 2) {
				System.out.printf("국어1 : %3d\n", kor);
				i++;
			}
			i = 0;
			
			
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %.2f\n", avg);
	
			/*
			 * System.out.printf("%d\n", 80); System.out.printf("%d\n", 20);
			 * 
			 * System.out.printf("%d-%d-%d-%s\n", 2013, 12, 22, "a");
			 * System.out.printf("%1$5.2f", 2.222);
			 */
		}
	}

}