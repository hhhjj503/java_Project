package com.newlecture.app.util;

public class IntList {

	private int[] nums;
	private int current;
	
	public IntList() {
		nums = new int[3];
		current = 0;
	}

	public void add(int num) {
		nums[current] = num;
		current ++;
	}

	public void clear() {
		//nums = new int[3];
		current = 0;
	}

	public int size() {
		return current;
	}

	public int get(int index) {
		if(index >= current) throw new IndexOutOfBoundsException();
		return nums[index];
	}
	
}
