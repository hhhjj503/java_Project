/*
 * ���۱� ���� :
 * �ۼ���: ..
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
		{ // ----------���� �Է� �κ�-----------------------------------
			System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
			System.out.println("��              \\  ���� �Է�       ��");
			System.out.println("����������������������������������������������������������������");
			
			do {
			System.out.println("����1 ���� : ");
			kor = scan.nextInt();
				if(kor < 0 || kor > 100) 
					System.out.println("0~100 ������ �Է��ϼ���!");
			}while (kor < 0 || kor > 100);
			
			do {
				System.out.println("����2 ���� : ");
				j = scan.nextInt();
					if(j < 0 || j > 100) 
						System.out.println("0~100 ������ �Է��ϼ���!");
			}while (j < 0 || j > 100);
				
			do {
				System.out.println("����3 ���� : ");
				t = scan.nextInt();
					if(t < 0 || t > 100) 
						System.out.println("0~100 ������ �Է��ϼ���!");
			}while (t < 0 || t > 100);
			total = kor + j + t;
			
			// ----------���� ��� �κ�-----------------------------------
			System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
			System.out.println("��              \\  ���� ���       ��");
			System.out.println("����������������������������������������������������������������");
	
			// % n$ +(right),-(left) width precision(.00..) conversion(d,f,x,..)
			System.out.printf("%1$d %1$d %1$d\n", 1);
			
			int i = 0;
			while(i < 2) {
				System.out.printf("����1 : %3d\n", kor);
				i++;
			}
			i = 0;
			
			
			System.out.printf("���� : %3d\n", total);
			System.out.printf("��� : %.2f\n", avg);
	
			/*
			 * System.out.printf("%d\n", 80); System.out.printf("%d\n", 20);
			 * 
			 * System.out.printf("%d-%d-%d-%s\n", 2013, 12, 22, "a");
			 * System.out.printf("%1$5.2f", 2.222);
			 */
		}
	}

}