package com.aurionpro.model;

import java.io.Serializable;

public class Account implements Serializable {
	
	private double id;
	private String name;
	private double balance;
	
	public Account(double id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	

	
}
