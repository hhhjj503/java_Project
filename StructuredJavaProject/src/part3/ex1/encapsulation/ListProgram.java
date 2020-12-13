package part3.ex1.encapsulation;

import java.util.Scanner;

public class ListProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ExamList list = new ExamList();
		ExamList.init(list);
		Boolean loop = true;
		
		quit :
			while(loop) {
			int menu = menu();
			
				switch(menu) {
				case 1 :
				list.insertList(list, list.current); //insertScores 에 kors 의 참조매핑주소값을 넘겨줌
				break;
				case 2 :
				list.printList(list);
				break;
				case 3 : 
					//강제종료 System.exit(0);
					System.out.println("Bye~~Bye~~");
					break quit;
				default : 
					System.out.println("1~3 사이의 숫자만 입력하세요!");
			}//switch
		} //while
	} //main
	

	static int menu() {
		// ----------���� �Է� �κ�-----------------------------------
					System.out.println("-----------------------------"); // print() = wtite() + flush()
					System.out.println("|             \\메인메뉴      |");
					System.out.println("----------------------------");
					
					System.out.println("\t1.성적입력");
					System.out.println("\t2.성적출력");
					System.out.println("\t3.종료");
					System.out.println("\t메뉴선택>");
					Scanner scan = new Scanner(System.in);
					int menu = scan.nextInt();
					scan.close();
					return menu;
	}

}
