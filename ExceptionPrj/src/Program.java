
public class Program {

	public static void main(String[] args) throws under1000 {
		// TODO Auto-generated method stub
		//Calculator calc = new Calculator(3,4);
		//calc.add();
		
		int result = 0;
		//main 이 throws 하면 JRE 가 예외를 전달받고, 받은직후 프로그램의 실행을 끝냄으로서 예외를 처리해 버린다
		//그러니까.. 처리가..진정한 의미의 처리가 아니라 그냥 무조건 종료시켜버리는거
		
		try {
		result = Calculator.add(3,1000); //static 함수
		System.out.printf("add : %d\n", result);
		}catch(over1000 e) {
			System.out.println(e.getMessage());
		}
		
		result = Calculator.sub(3,4); //static 함수
		System.out.printf("sub : %d\n", result);
		result = Calculator.multi(3,4); //static 함수
		System.out.printf("multi : %d\n", result);
		result = Calculator.divide(3,4); //static 함수
		System.out.printf("divide : %d\n", result);
	}
	
}
