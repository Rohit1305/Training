package com.aurionpro.model;

public class Child extends Parent {
	private int value;
	
	@Override
	public String toString() {
		return "Child [value=" + value + "]";
	}

	public Child(int value){
		super(20);
		this.value=value;
		System.out.println("inside child");
	}

}
