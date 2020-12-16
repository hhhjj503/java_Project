import part3.ex3.UIcodeSeperated.Exam;

public class NewLecExam extends Exam {
	
	//private Exam exam = new Exam();
	//자식클래스 extends 부모클래스
	
	private int com;
	
	public NewLecExam() {
		// TODO Auto-generated constructor stub
		this(0,0,0,0);
	}
	
	public NewLecExam(int kor, int eng, int math, int com) {
		super(kor, eng, math);
		this.com = com;
	}

	
	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
	
	@Override
	public int getTotal() {
		return super.getTotal() + com; //com = this.com
	}
	
	@Override
	public float getAvg() {
		// TODO Auto-generated method stub
		return getTotal()/4.0f;
	}
	
}
