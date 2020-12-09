/*
 * 저작권 정보 :
 * 작성일: ..
 * */


package ex5.io.scanner;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int kor = 0;
		int j = 0;
		int i = 00;
		
		Scanner scan = new Scanner(System.in);
		
		int total = 0;
		float avg = total/3.0f;

		
		//----------성적 입력 부분-----------------------------------
		System.out.println("┌──────────────────────────────┐"); //print() =  wtite() + flush()
		System.out.println("│              \\  성적 입력       │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("국어1 성적 : ");
		kor = scan.nextInt();
		System.out.println("국어2 성적 : ");
		j = scan.nextInt();
		System.out.println("국어3 성적 : ");
		i = scan.nextInt();
		total = kor + j + i;
		//----------성적 출력 부분-----------------------------------
		System.out.println("┌──────────────────────────────┐"); //print() =  wtite() + flush()
		System.out.println("│              \\  성적 출력       │");
		System.out.println("└──────────────────────────────┘");
	
		System.out.printf("%1$d %1$d %1$d\n",1);
		
		System.out.printf("\t국어1 : %3d\n", kor);
		System.out.printf("\t국어2 : %3d\n", j);
		System.out.printf("\t국어3 : %3d\n", i);
		System.out.printf("\t총점 : %3d\n", total);
		System.out.printf("\t평균 : %.2f\n", avg);
	
		System.out.println(80);
		
		System.out.printf("%d-%d-%d-%s",2013,12,22,"a");
		//System.out.write(80);
		//System.out.flush(); % 1$ +,- width precision conversion
		
		int result = 0;
		result = result++; // result++ = result
	}

}