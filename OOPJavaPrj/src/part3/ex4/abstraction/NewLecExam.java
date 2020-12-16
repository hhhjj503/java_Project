package part3.ex4.abstraction;

public class NewLecExam extends Exam {
	
	//private Exam nExam = new NewLecExam();
	private int com;
	
	public NewLecExam() {
		this(0,0,0,0);
	}
	
	public NewLecExam(int kor,int eng, int math, int com) {
		super(kor, eng, math);
		this.com = com;
	}
	
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		int total = onTotal() + com;
		return total;
	}

	@Override
	public float getAvg() {
		// TODO Auto-generated method stub
		return getTotal()/4.0f;
	}
	
	public int getCom() {
		return com;
	}
	
	public void setCom(int com) {
		this.com = com;
	}
	
}
