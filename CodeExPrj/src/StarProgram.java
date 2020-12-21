
public class StarProgram {

	public static void main(String[] args) {
		
		System.out.printf("%s\n", "☆");
		
		for(int i = 0 ; i < 10;i++) 
			System.out.printf("%s", "☆");
		
		System.out.printf("\n\n");
		for(int i = 0; i <10;i++) {
			for(int j = 0;j < 10;j++)
				System.out.printf("%s","☆");
			System.out.println();
		}//이게 하나의 문장
		System.out.printf("\n");
		for(int i = 0; i < 10;i++) {
			for(int j = 0;j <= i;j++)
				System.out.printf("%s","☆");
		System.out.println();
		}
		System.out.printf("\n");
		
		int num = 10;
		for(int i = 0; i < 10;i++) {
			for(int j = 0; j < num; j++)
				System.out.printf("%s","☆");
			num--;
			System.out.println();
		}
		
		for(int i =0;i<5;i++)
			System.out.printf("%c",'A'+i);
	}		
}
