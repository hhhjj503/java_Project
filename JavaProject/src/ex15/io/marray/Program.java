package ex15.io.marray;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//int kor = 0;
		int[] kors = new int[3*3];
		for(int j = 3; j <3;j++)
		for(int i = 0 ; i <3;i++) {
			kors[3*j+i] = 1;
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
						System.out.printf((j+1)+"�г� ����%d ���� : \n", j*3+i);
						kors[j*3+i] = scan.nextInt();
							if(kors[j*3+i] < 0 || kors[j*3+i] > 100) 
								System.out.println("0~100 ������ �Է��ϼ���!");
					}while (kors[j*3+i] < 0 || kors[j*3+i] > 100);
					
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
						System.out.printf("���� %d �г� %d���� : %d\n", j+1,i+1, kors[j*3+i]); 		
					}
					
					for(int i = 0; i <3 ; i++)
						total += kors[j*3+i];
					avg = (float)(total/3.0);
					System.out.printf("\t���� : %d\n", total);
					System.out.printf("\t��� : %5.2f\n", avg);
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