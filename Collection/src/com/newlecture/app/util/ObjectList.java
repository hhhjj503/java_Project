package com.newlecture.app.util;

public class ObjectList {

	private Object[] nums;
	private int current;
	
	public ObjectList() {
		nums = new Object[3];
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

	public Object get(int index) {
		if(index >= current) throw new IndexOutOfBoundsException();
		return nums[index];
	}
	
}
