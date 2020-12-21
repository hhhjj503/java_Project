import java.util.Random;

public class ArrayRandom {

	public static void main(String[] args) {
		
		//컴퓨터는 random 이라는 개념이 존재하지 않는다 
		//일정한 규칙에 의해 무작위처럼 보이게 만들어 주는것
		
		Random rand = new Random();
		
		int[] lotto = new int[6];
		
		for(int i = 0 ; i<6;i++) {
			lotto[i] = rand.nextInt(100)+1;
			System.out.println(lotto[i]);
		}
	}
}
