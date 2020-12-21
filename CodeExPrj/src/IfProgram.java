
public class IfProgram {

	public static void main(String[] args) {
		
		//if 문은 우선순위를 통해 적용하기 떄문에 제일좁은 범위부터 점점 넓어지는 범위로 작성
		// 제일 한정된 범위를 가장 우선적으로 비교 -> 점점 넓어지는 범위를 비교하고 가장 범용적인 범위는 else 로
		for(int i = 0;i<5;i++) 
			if(i==4)
				System.out.printf("%c", 'A'+i);
			else if(i%2 == 0)
				System.out.printf("%c", ' ');
			else  //default
				System.out.printf("%c,", 'A'+i);
			
		System.out.println();
		
		for(int i = 0; i <3;i++) { // 0,1,2
			for(int n = 1;n <= 4;n++) {
				 // 1,2,3
			if(n%4 == 0)
				System.out.printf("%d", (i*4)+n);
			else
				System.out.printf("%d,", (i*4)+n );
			}
		System.out.printf("\n\n");
		}
		
	}

}
