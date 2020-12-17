package part3.ex5.interfaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("src/part3/ex5/interfaces/Settings.txt");
		Scanner scan = new Scanner(fis);
		String className = scan.nextLine();
		scan.close();
		fis.close();
	
		A a = new A();
		Class clazz = Class.forName(className);
		// X.class.newInstance();
		X x = (X) clazz.newInstance();
		a.setX(x);
		a.print();
	}

}
