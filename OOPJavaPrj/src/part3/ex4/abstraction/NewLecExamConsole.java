package part3.ex4.abstraction;

import java.util.Scanner;

public class NewLecExamConsole extends ExamConsole {

	
	@Override
	protected Exam makeEaxm() {		
		return new NewLecExam();
	}

	@Override
	protected void onInput(Exam exam) {
		NewLecExam newLecExam = (NewLecExam)exam;
		Scanner scan = new Scanner(System.in);
		int com;
		do {
			System.out.printf("컴퓨터 성적 : ");
			com = scan.nextInt();
		}while(com < 0 || com > 100);
		newLecExam.setCom(com);
	}
	
	@Override
	protected void onPrint(Exam exam) {
		// TODO Auto-generated method stub
		NewLecExam newLecExam = (NewLecExam)exam;
		int com = newLecExam.getCom();
		System.out.printf("\t컴퓨터점수 : %d\n", com);
	}
	
}
