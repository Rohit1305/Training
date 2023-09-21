package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	private List<INotifier> notifiers ;
	
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.notifiers = new ArrayList<INotifier>();
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<INotifier> getNotifiers() {
		return notifiers;
	}
	public void setNotifiers(List<INotifier> notifiers) {
		this.notifiers = notifiers;
	}
	
	public void withdraw(double amount) throws Exception {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
            for (INotifier n : notifiers) {
                n.notifyUser(this, amount, "withdrawn");
            }
        } else {
            throw new Exception("Insufficient funds");
        }
    }

    public void deposit(double amount) throws Exception {
        if (amount > 0) {
            balance += amount;
            for (INotifier n : notifiers) {
                n.notifyUser(this, amount, "deposited");
            }
        } else {
            throw new Exception("Invalid deposit amount");
        }
    }

	public void registerNotifier(INotifier notifier) {
		notifiers.add(notifier);
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", notifiers="
				+ notifiers + "]";
	}
	

}
