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
					for(int j = 0; j<3;j++)
					for(int i =0;i<3;i++)
					do {
						System.out.printf("%d�г� ����%d ���� : \n", j+1, j+1);
						kors[j][i] = scan.nextInt();
							if(kors[j][i] < 0 || kors[j][i] > 100) 
								System.out.println("0~100 ������ �Է��ϼ���!");
					}while (kors[j][i] < 0 || kors[j][i] > 100);
					
			case 2 :
					// ----------���� ��� �κ�-----------------------------------
					System.out.println("����������������������������������������������������������������"); // print() = wtite() + flush()
					System.out.println("��              \\  ���� ���       ��");
					System.out.println("����������������������������������������������������������������");
					
					int total = 0;
					float avg = 0;
					
					for(int j = 0; j <3;j++) {
						System.out.printf("-------\t%d�г�---------\n", j+1);
					for(int i = 0; i < 3;i++) {
						System.out.printf("���� %d �г� %d���� : %d\n", j+1,i+1, kors[j][i]); 		
					}
					
					for(int i = 0; i <3 ; i++)
						total += kors[j][i];
					avg = (float)(total/3.0);
					System.out.printf("\t���� : %d\n", total);
					System.out.printf("\t��� :%5.2f\n", avg);
					System.out.printf("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n\n");
					total = 0;
					avg = 0;
					}
					
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