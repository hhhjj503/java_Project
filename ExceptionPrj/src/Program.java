
public class Program {

	public static void main(String[] args) throws under1000 {
		// TODO Auto-generated method stub
		//Calculator calc = new Calculator(3,4);
		//calc.add();
		
		int result = 0;
		//main 이 throws 하면 JRE 가 예외를 전달받고, 받은직후 프로그램의 실행을 끝냄으로서 예외를 처리해 버린다
		//그러니까.. 처리가..진정한 의미의 처리가 아니라 그냥 무조건 종료시켜버리는거
		
		
		//switch case 랑 비스한 느낌?!
		result = Calculator.add(3,10000); // RuntimeException
		System.out.printf("add : %d\n", result);
		
		try { 
		result = Calculator.sub(3,4); //static 함수
		System.out.printf("sub : %d\n", result);
		} catch(under1000 e) { //Exception
			System.out.println("음수처리");
		} finally {
			System.out.println("마지막예외이며 기본실행!");
		}
		
		result = Calculator.multi(3,4); //static 함수
		System.out.printf("multi : %d\n", result);
		
		result = Calculator.divide(3,0); //static 함수
		System.out.printf("divide : %d\n", result);
	}
}
