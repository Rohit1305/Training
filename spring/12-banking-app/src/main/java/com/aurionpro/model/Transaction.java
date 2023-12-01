package com.aurionpro.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Data
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Enumerated(EnumType.STRING)
	@Column(name = "trans_type")
	private TransactionType transType;
	@Column(name = "trans_date")
	private Date transDate;
	@Column(name = "amount")
	private double amount;
	@Column(name = "receiver_account_no")
	private double receiverAccount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_no")
	private Account account;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getTransType() {
		return transType;
	}

	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(double receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
