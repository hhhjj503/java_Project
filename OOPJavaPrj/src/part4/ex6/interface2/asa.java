package part4.ex6.interface2;

public class asa implements X{

	int i;
	int y;
	
	public asa() {
		i = 3;
		y =6;
	}
	
	@Override
	public int plus() {
		return i+y;
	}

}
