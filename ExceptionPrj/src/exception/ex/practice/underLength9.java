package exception.ex.practice;

public class underLength11 extends Exception {

	@Override
	public String getMessage() {
		System.out.println("핸드폰 번호는 11자리여야 합니다");
		return super.getMessage();
	}
}
