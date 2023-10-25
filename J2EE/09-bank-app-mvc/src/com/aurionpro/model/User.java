package com.aurionpro.model;

public class User {

	private int acc_no;
	private String user_name;
	private String email;
	private String pass;
	private String mob;
	private double balance;

	public User(int acc_no, String user_name, String email, String pass, String mob, double balance) {
		super();
		this.acc_no = acc_no;
		this.user_name = user_name;
		this.email = email;
		this.pass = pass;
		this.mob = mob;
		this.balance = balance;
	}

	public User(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public User(int acc_no, String user_name, String email, String pass, String mob) {
		this.acc_no = acc_no;
		this.user_name = user_name;
		this.email = email;
		this.pass = pass;
		this.mob = mob;
		
	}

	public User(int acc_no, String email, String pass, double balance) {
		this.acc_no = acc_no;
		this.email = email;
		this.pass = pass;
		this.balance = balance;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public String getMob() {
		return mob;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "User [acc_no=" + acc_no + ", user_name=" + user_name + ", email=" + email + ", pass=" + pass + ", mob="
				+ mob + ", balance=" + balance + "]";
	}
}