package part4.ex6.interface2;

public class A {

	X x;
	
	public A () {}
	
	public void setX(X x) {
		this.x = x;
	}
	
	public void plus() {
		System.out.println(x.plus());
	}
}
