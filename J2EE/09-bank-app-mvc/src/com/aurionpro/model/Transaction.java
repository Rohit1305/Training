package com.aurionpro.model;

import java.util.Date;

public class Transaction {
    private int transId;
    private int accountNo;
    private int transactionTypeId;
    private Date transactionTime;
	public Transaction(int transId, int accountNo, int transactionTypeId, Date transactionTime) {
		super();
		this.transId = transId;
		this.accountNo = accountNo;
		this.transactionTypeId = transactionTypeId;
		this.transactionTime = transactionTime;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", accountNo=" + accountNo + ", transactionTypeId="
				+ transactionTypeId + ", transactionTime=" + transactionTime + "]";
	}
    
    

}
