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
		 // ----------���� �Է� �κ�-----------------------------------
			System.out.println("�����Դϴ�!");
			System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
			System.out.println("��              \\  ���� �޴�       ��");
			System.out.println("����������������������������������������������������������������");
			
			System.out.println("\t1.�����Է�");
			System.out.println("\t2.�������");
			System.out.println("\t3.����");
			System.out.println("\t��ȣ�Է�>");
			int menu = scan.nextInt();
			
			if(menu == 1) {
				 // ----------���� �Է� �κ�-----------------------------------
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
					avg = total/3.0f;		
			} else if(menu==2) {
					// ----------���� ��� �κ�-----------------------------------
					System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
					System.out.println("��              \\  ���� ���       ��");
					System.out.println("����������������������������������������������������������������");
			
					for(int i = 0; i < 3;i++) {
						System.out.printf("\t�����%d : %d\n", i, kor);
					}
					System.out.printf("���� : %3d\n", total);
					System.out.printf("��� : %.2f\n", avg);
			} else if(menu==3) {
				//���α׷� �������� System.exit(0);
				System.out.println("Bye~~Bye~~");
				break;
			} else {
				System.out.println("�Է¿���!! 1~3 ������ �Է����ּ���!");
			}
		} //while
	} //main
} //class