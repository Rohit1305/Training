package com.aurionpro.model;

public class TestGreeting {
	
	public TestGreeting() {
		System.out.println("inside constructor TestGreeting");
	}
	
	public void demoGreeting() {
		System.out.println("inside non static demoGreeting");
	}
	
	public static void someGreeting() {
		System.out.println("inside static someGreeting");
	}

}
