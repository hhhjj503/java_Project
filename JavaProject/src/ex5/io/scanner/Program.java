/*
 * ���۱� ���� :
 * �ۼ���: ..
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

		
		//----------���� �Է� �κ�-----------------------------------
		System.out.println("����������������������������������������������������������������"); //print() =  wtite() + flush()
		System.out.println("��              \\  ���� �Է�       ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����1 ���� : ");
		kor = scan.nextInt();
		System.out.println("����2 ���� : ");
		j = scan.nextInt();
		System.out.println("����3 ���� : ");
		i = scan.nextInt();
		total = kor + j + i;
		//----------���� ��� �κ�-----------------------------------
		System.out.println("����������������������������������������������������������������"); //print() =  wtite() + flush()
		System.out.println("��              \\  ���� ���       ��");
		System.out.println("����������������������������������������������������������������");
	
		System.out.printf("%1$d %1$d %1$d\n",1);
		
		System.out.printf("\t����1 : %3d\n", kor);
		System.out.printf("\t����2 : %3d\n", j);
		System.out.printf("\t����3 : %3d\n", i);
		System.out.printf("\t���� : %3d\n", total);
		System.out.printf("\t��� : %.2f\n", avg);
	
		System.out.println(80);
		
		System.out.printf("%d-%d-%d-%s",2013,12,22,"a");
		//System.out.write(80);
		//System.out.flush(); % 1$ +,- width precision conversion
		
		int result = 0;
		result = result++; // result++ = result
	}

}