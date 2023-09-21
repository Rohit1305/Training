package com.aurionpro.model;

public class Account {

	private int ID;
	private String name;
	private Gender gender;
	private int balance;
	
	public Account(int iD, String name, Gender gender, int balance) {
		super();
		ID = iD;
		this.name = name;
		this.gender = gender;
		this.balance = balance;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [ID=" + ID + ", name=" + name + ", gender=" + gender + ", balance=" + balance + "]";
	}

	

}
