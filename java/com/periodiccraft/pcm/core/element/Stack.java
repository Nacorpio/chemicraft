package com.periodiccraft.pcm.core.element;

public class Stack<T> {

	private T type;
	private int count; 
	
	public Stack(T par1, int par2) {
		this.type = par1;
		this.count = par2;
	}
	
	public final T getType() {
		return this.type;
	}
	
	public final void setCount(int par1) {
		this.count = par1;
	}
	
	public final int getCount() {
		return this.count;
	}
	
}
