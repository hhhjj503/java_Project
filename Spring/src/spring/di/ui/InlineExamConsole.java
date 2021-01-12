package spring.di.ui;

import spring.di.entitiy.Exam;

public class InlineExamConsole implements ExamConsole {

	
	private Exam exam;
	
	public InlineExamConsole() {}
	
	public InlineExamConsole(Exam exam) { this.exam = exam; }

	@Override
	public void print() {
		System.out.printf("total is %d and avg is %f", exam.total() , exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
