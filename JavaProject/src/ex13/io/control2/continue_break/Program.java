package ex13.io.control2.continue_break;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = 0;
		System.out.println("값을 스페이스로 구분해서 다섯개 이상 입력하세요!");
		
		while(scan.hasNext()) {
			n = scan.nextInt();
			
			if(n <10) 
				continue;
			System.out.println(n);
					   
			if(n > 200)
				break; 
		}
	} //main
} //class