package exception.ex.practice;

public class Phone {

	private int num;
	
	public static void add(String i) throws isNot11 {
		// TODO Auto-generated method stub
		if(i.length() < 11 || i.length() > 11)
			throw new isNot11();
		else
		System.out.printf("핸드폰 번호는 : %s 입니다", i);
	}
	
	public int add() {
		return num;
	}

}
