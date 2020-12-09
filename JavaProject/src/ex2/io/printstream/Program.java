/*
 * 저작권 정보 :
 * 작성일: ..
 * */

package ex2.io.printstream;
public class Program {

	public static void main(String[] args) {
		int e = 90;
		int j = 70;
		int i = 80;

		int total = e + j + i;
		float avg = total/3;
		
		//----------성적 출력 부분-----------------------------------
		System.out.print("┌──────────────────────────────┐"); //print() =  wtite() + flush()
		System.out.print("│             성적 출력           │");
		System.out.print("└──────────────────────────────┘");
		
		System.out.print("국어1 : 0");
		System.out.print("국어2 : 0");
		System.out.print("국어3 : 0");
		System.out.print("총점 : 0");
		System.out.print("평균 : 0.00");
		
	}

}