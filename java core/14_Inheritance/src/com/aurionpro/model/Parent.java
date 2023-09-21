package com.aurionpro.model;

public class Parent {
	private int num;
	@Override
	public String toString() {
		return "Parent [num=" + num + "]";
	}
	public Parent(int num){
		this.num=num;
		System.out.println("inside parent"+num);
	}

}
