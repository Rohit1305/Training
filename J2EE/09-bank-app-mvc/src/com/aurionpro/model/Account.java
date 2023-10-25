package com.aurionpro.model;

public class Account {
	private int accountNo;
	private String accountType;
	private int userId;
	public Account(int accountNo, String accountType, int userId) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.userId = userId;
	}
	public Account() {
		super();
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", userId=" + userId + "]";
	}

	
}
