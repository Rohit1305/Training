package com.aurionpro.test;

public class Account {
	private int id;
	private String name;
	private double balance;
	private static int count;
	


	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Account.count = count;
	}

	public Account() {
		super();
		count++;
	}
	
	public Account(int id) {
		
		this.id = id;
		count++;
	}
	public Account(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		count++;
	}

		

}
