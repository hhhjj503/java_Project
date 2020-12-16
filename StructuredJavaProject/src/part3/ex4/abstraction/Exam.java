package part3.ex4.abstraction;

public abstract class Exam {

	
	private int kor;
	private int eng;
	private int math;
	
	public Exam() { 
		// TODO Auto-generated constructor stub
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math) {
		// TODO Auto-generated constructor stub
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getKorr() {
		return kor;
	}
	public void setKorr(int korr) {
		this.kor = korr;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public abstract int getTotal();
	
	protected int onTotal() {
		return kor + eng + math;
	};
	
	public abstract float getAvg();
	

}
