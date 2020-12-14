package part3.ex2.method;

public class ListProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ExamList list = new ExamList();
		Boolean loop = true;
		
		quit :
			while(loop) {
				switch(list.menu()) {
				case 1 :
				list.insertList(); // = ExamList.inserList(list)
				break;
				case 2 :
				list.printList(); //
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
}
