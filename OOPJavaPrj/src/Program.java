import part3.ex3.UIcodeSeperated.Exam;

public class Program {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		NewLecExam lecExam = new NewLecExam(1,1,1,1);	//composition has A 상속
		
		System.out.println(lecExam.getTotal());
		System.out.println(lecExam.getAvg());
		
		Exam exam = new NewLecExam(1,1,1,1);
		
		System.out.println(exam.getTotal());
		System.out.println(((NewLecExam)exam).getCom());
		
		
	}
	
}