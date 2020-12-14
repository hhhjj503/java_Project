package part3.ex3.UIcodeSeperated;

public class Exam {

	
	private int korr;
	private int eng;
	private int math;
	
	
	public Exam() { 
		// TODO Auto-generated constructor stub
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math) {
		// TODO Auto-generated constructor stub
		this.korr = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getKorr() {
		return korr;
	}
	public void setKorr(int korr) {
		this.korr = korr;
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
	public int getTotal() {
		return korr + eng + math;
	}
	public float getAvg() {
		return (getTotal()/3.0f);
	}

}
