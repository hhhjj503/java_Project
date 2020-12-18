
public class Calculator {

	private int x;
	private int y;
		
	public Calculator() {
		x = 0;
		y= 0;
	}

	public Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int add() {
		return x + y;
	}

	public static int add(int x, int y) throws over1000, under1000 { //throws 동사
		int result = x +y;
		if(result > 1000)
			throw new over1000();
		if(result < 0)
			throw new under1000(); //throw 명령어
		
		return x + y;
	}

	public static int sub(int x, int y) {
		return x -y;
	}

	public static int multi(int x, int y) {
		return x*y;
	}

	public static int divide(int x, int y) {
		return x/y;
	}

}
