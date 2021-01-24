package com.newlecture.app.util;

public class GList<T> {

	private Object[] data;
	private int current;
	private int capacity;
	private int amount;
	
	
	public GList() {
		capacity = 3;
		amount = 5;
		data = new Object[capacity];
		current = 0;
	}
	
	public void add(T num) {
		
		if( current == (capacity-1)) {
			Object[] temp = new Object[current + amount];
			for(int i = 0 ; i < data.length; i++) temp[i] = data[i];
			data = temp;
			capacity += amount;
		}
		
		data[current] = num;
		current ++;
	}

	public void clear() {
		//data = new int[3];
		current = 0;
	}

	public int size() {
		return current;
	}

	public T get(int index) {
		if(index >= current) throw new IndexOutOfBoundsException();
		return (T) data[index];
	}
	
}
