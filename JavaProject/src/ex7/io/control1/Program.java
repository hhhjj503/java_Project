/*
 * ���۱� ���� :
 * �ۼ���: ..
 * */


package ex7.io.control1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int kor = 0;
		int j = 0;
		int i = 00;
		
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
				if(kor < 0 || kor > 100) {
					System.out.println("0~100 ������ �Է��ϼ���!");
				}
			}
			while (kor < 0 || kor > 100);
			
			System.out.println("����2 ���� : ");
			j = scan.nextInt();
			System.out.println("����3 ���� : ");
			i = scan.nextInt();
			total = kor + j + i;
			
			int re = 0 <= kor && kor <= 100 ? 1 : 0;
			System.out.println(re);
			
			// ----------���� ��� �κ�-----------------------------------
			System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
			System.out.println("��              \\  ���� ���       ��");
			System.out.println("����������������������������������������������������������������");
	
			// % n$ +(right),-(left) width precision(.00..) conversion(d,f,x,..)
			System.out.printf("%1$d %1$d %1$d\n", 1);
	
			System.out.printf("����1 : %3d\n", kor);
			System.out.printf("����2 : %3d\n", j);
			System.out.printf("����3 : %3d\n", i);
			System.out.printf("���� : %3d\n", total);
			System.out.printf("��� : %.2f\n", avg);
	
			System.out.printf("%d\n", 80);
			System.out.printf("%d\n", 20);
	
			System.out.printf("%d-%d-%d-%s\n", 2013, 12, 22, "a");
			System.out.printf("%1$5.2f", 2.222);
		}
		//System.out.write(80);
		//System.out.flush(); % 1$ +,- width precision conversion
		
		//�������� : value && value, value || value, !(value || value) 
		//��Ʈ �� ������ :value & value, value | value, value ^ value, value ~ value
	}

}