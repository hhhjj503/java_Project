package ex14.io.array;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//int kor = 0;
		int[] kors = new int[3];
		for(int i = 0 ; i <3;i++) {
			kors[i] = 1;
		}
		
		int j = 0;
		int t = 00;
		//int total = kor + j + t;

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
			
			case 1 :
				 // ----------���� �Է� �κ�-----------------------------------
					System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
					System.out.println("��              \\  ���� �Է�       ��");
					System.out.println("����������������������������������������������������������������");
					
					for(int i =0;i<3;i++)
					do {
						System.out.printf("����%d ���� : \n", i);
						kors[i] = scan.nextInt();
							if(kors[i] < 0 || kors[i] > 100) 
								System.out.println("0~100 ������ �Է��ϼ���!");
					}while (t < 0 || t > 100);
					
					//total = kor + j + t;
			case 2 :
					// ----------���� ��� �κ�-----------------------------------
					System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
					System.out.println("��              \\  ���� ���       ��");
					System.out.println("����������������������������������������������������������������");
			
					for(int i = 0; i < 3;i++) {
						System.out.printf("\t�����%d : %d\n", i, kors[i]);
					}
					//System.out.printf("���� : %3d\n", total2);
					//System.out.printf("��� : %.2f\n", avg);
					break;
			case 3 : 
				//���α׷� �������� System.exit(0);
				System.out.println("Bye~~Bye~~");
				break quit;
			default : 
				System.out.println("�Է¿���!! 1~3 ������ �Է����ּ���!");
			}//switch
		} //while
	} //main
} //class