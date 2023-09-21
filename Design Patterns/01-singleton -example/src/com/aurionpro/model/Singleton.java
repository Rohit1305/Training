package com.aurionpro.model;

public class Singleton {
	private static Singleton single;
	
	private Singleton() {
		
	}
	public static Singleton getSingleInstance() {
		if (single==null) {
			single= new Singleton();
		}
		return single;
	}
	
//	public void PrintGreetings() {
//		System.out.println(this.hashCode()+" Welcome");
//	}

}
