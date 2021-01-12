package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entitiy.Exam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* /Exam exam = new NewlecExam();
		//ExamConsole console = new InlineExamConsole(exam); 생성자방법
		console.setExam(exam); */ //setter 방법
		
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("spring/di/setting.xml"); //참조할 지시서의 위치 src 를 기준으로 시작
		
		
		
		//ExamConsole console = (ExamConsole) context.getBean("console"); //id 로 꺼내기
		ExamConsole console = context.getBean(ExamConsole.class); //class 명으로 꺼내기
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		console.print(); 
	
	}

}
