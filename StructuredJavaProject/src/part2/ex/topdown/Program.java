package part2.ex.topdown;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {	
	
		int[][] lottos = null;
		int menu = 0;
		boolean running = true;
		
		while(running) {			
			menu = inputMenu();
				switch(menu) {
				case 1 :
					createLottosAuto(); //로또 번호만 생성
					break;
				case 2 :
					mkLottosManual();
					break;
				case 3 :
					printLottos(lottos);
					break;
				case 4 :
					running = false;
					break exit;
				}//switch
		}//while
	} //main

	private static void printLottos(int[][] lottos) {
		// TODO Auto-generated method stub
		
	}

	private static void mkLottosManual() {
		// TODO Auto-generated method stub
		
	}

	private static void createLottosAuto() {
		// TODO Auto-generated method stub
		
	}

	private static int inputMenu(int inputMenu) {
		System.out.println("----------------------------------");
		return inputMenu;
	}
	
} //class