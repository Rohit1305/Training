package com.aurionpro.model;

public class Passbook {
	
	private int sr_no;
	private int acc_no;
	private String trans_date;
	private String trans_type;
	private double amount;
	private double balance;
	
	public Passbook(int sr_no, int acc_no, String trans_date, String trans_type, double amount, double balance) {
		super();
		this.sr_no = sr_no;
		this.acc_no = acc_no;
		this.trans_date = trans_date;
		this.trans_type = trans_type;
		this.amount = amount;
		this.balance = balance;
	}
	
	public Passbook(int acc_no, String trans_date, String trans_type, double amount, double balance) {
		this.acc_no = acc_no;
		this.trans_date = trans_date;
		this.trans_type = trans_type;
		this.amount = amount;
		this.balance = balance;
	}

	public int getSr_no() {
		return sr_no;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Passbook [sr_no=" + sr_no + ", acc_no=" + acc_no + ", trans_date=" + trans_date + ", trans_type="
				+ trans_type + ", amount=" + amount + ", balance=" + balance + "]";
	}
	
	
}