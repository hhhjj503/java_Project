package part3.ex3.UIcodeSeperated;

public class ExamList {

	private Exam[] exams; //aggregation has A
	private int current;
	
	//객체 + ()함수
	public ExamList() { 
		this(3);
	}
	
	public ExamList(int size)  {
		this.exams = new Exam[size];
		this.current = 0;
	}
		
	public void add(Exam exam) {
		// TODO Auto-generated method stub
		int capacity = exams.length;
		Exam[] origin = exams;
		
		if(capacity == current) {
			
			int amount = 5;
			Exam[] temp = new Exam[amount+capacity];
			
			for(int i = 0; i < capacity;i++) {
				temp[i] = origin[i];
			}
			exams = temp;
		}
		
		exams[this.current] = exam;
		current++;
	}

	public Exam getExam(int i) {
		// TODO Auto-generated method stub
		return this.exams[i];
	}
	
	
	public int getSize() {
		// TODO Auto-generated method stub
		return current;
	}
	
}
