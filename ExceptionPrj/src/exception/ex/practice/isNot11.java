package exception.ex.practice;

public class isNot11 extends Exception {

	@Override
	public String getMessage() {
		return "핸드폰 번호는 11자리여야 합니다 \n 다시입력해주세요";
	}
}
