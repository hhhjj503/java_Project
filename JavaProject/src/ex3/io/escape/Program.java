/*
 * 저작권 정보 :
 * 작성일: ..
 * */

package ex3.io.escape;
public class Program {

	public static void main(String[] args) {
		int e = 90;
		int j = 70;
		int i = 80;

		int total = e + j + i;
		float avg = total/3;
		
		//----------성적 출력 부분-----------------------------------
		System.out.println("┌──────────────────────────────┐"); //print() =  wtite() + flush()
		System.out.println("│                성적 출력        │");
		System.out.println("└──────────────────────────────┘");
		
		System.out.println("\t국어1 : 0");
		System.out.println("\t국어2 : 0");
		System.out.println("\t국어3 : 0");
		System.out.println("\t총점 : 0");
		System.out.println("\t평균 : 0.00");
		
	}

}