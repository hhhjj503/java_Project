/*
 * ���۱� ���� :
 * �ۼ���: ..
 * */

package ex4.io.printf;
public class Program {

	public static void main(String[] args) {
		int kor = 50;
		int j = 60;
		int i = 80;

		int total = kor + j + i;
		float avg = total/3.0f;
		
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
	}

}