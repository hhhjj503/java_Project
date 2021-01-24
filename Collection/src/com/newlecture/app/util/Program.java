package com.newlecture.app.util;

public class Program {

	public static void main(String[] args) {
		
		GList<Integer> list = new GList<>();
		list.add(3);
		list.add(5);
		int size = list.size();
		System.out.printf("size : %d\n", size);
		
		list.clear();
		size = list.size();
		System.out.printf("clear size : %d\n", size);
		
		list.add(7);
		int num = (int) list.get(0);
		System.out.printf("가져온 num : %d", num);
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
	}

}
