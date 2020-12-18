import java.util.Scanner;

public class over1000 extends Exception {
	
	@Override
	public String getMessage() {
		Scanner scan = new Scanner(System.in);
		boolean chk = true;
		int x,y,result;
		do {
		System.out.println("입력값의 합이 1000을 넘었습니다");
		System.out.println("올바른 값을 다시 입력해주세요");
		System.out.print("x 값을 입력해주세요 : ");
		x = scan.nextInt();
		System.out.print("y 값을 입력해주세요 : ");
		y = scan.nextInt(); 
		result = x+ y;
		} while((x + y) > 1000);
		System.out.printf("add : %d",result);
		return "";
	}
}
