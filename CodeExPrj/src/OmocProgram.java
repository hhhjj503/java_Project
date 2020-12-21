
public class OmocProgram {

	public static void main(String[] args) {
		for(int i = 1;i<=10;i++) {
			for(int j =1;j <=10;j++)
			if(j == 1 &&  i==1)
				System.out.printf("%c", '┌');
			else if(j == 10 && i==1)
				System.out.printf("%c", '┐');
			else if(j >= 1 && j <=10 && i==1)
				System.out.printf("%c",'─');
			else if(i >= 2 && i <=9 && j==1)
				System.out.printf("%c",'│');
			else if(i >= 2 && i <=9 && j==10)
				System.out.printf("%c",'│');
			else if(j == 1 && i==10)
				System.out.printf("%c", '└');
			else if(j == 10 && i==10)
				System.out.printf("%c", '┘');
			else if(j >= 1 && j <=10 && i==10)
				System.out.printf("%c",'─');
			
			else if(i==2 && j==2)
			System.out.printf("%c", '●');
			else if(i==4 && j==5)
			System.out.printf("%c", '○');
			else //default
			System.out.printf("%c", '┼');
		System.out.println();
		}
	}

}
