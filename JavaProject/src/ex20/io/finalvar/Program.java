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
			
			switch(menu) {
			
			case MENU_INPUT :
				 // ----------���� �Է� �κ�-----------------------------------
					System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
					System.out.println("��              \\  ���� �Է�       ��");
					System.out.println("����������������������������������������������������������������");
					
					for(int i =0;i<SIZE;i++)
					do {
						System.out.printf("����%d ���� : \n", i);
						kors[i] = scan.nextInt();
							if(kors[i] < 0 || kors[i] > 100) 
								System.out.println("0~100 ������ �Է��ϼ���!");
					}while (t < 0 || t > 100);
					
			case MENU_PRINT :
					// ----------���� ��� �κ�-----------------------------------
					System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
					System.out.println("��              \\  ���� ���       ��");
					System.out.println("����������������������������������������������������������������");
			
					for(int i = 0; i < SIZE;i++) {
						System.out.printf("\t�����%d : %d\n", i, kors[i]);
					}
					break;
			case EXIT : 
				//���α׷� �������� System.exit(0);
				System.out.println("Bye~~Bye~~");
				break quit;
			default : 
				System.out.println("�Է¿���!! 1~3 ������ �Է����ּ���!");
			}//switch
		} //while
	} //main
} //class