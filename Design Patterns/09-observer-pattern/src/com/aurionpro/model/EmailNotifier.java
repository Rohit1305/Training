package com.aurionpro.model;

public class EmailNotifier implements INotifier{

	@Override
	public void notifyUser(Account account, double amount, String string) {

		System.out.println("Email Notification Account no  " + account.getAccountNumber());
		System.out.println("current balance is "+ account.getBalance());
		System.out.println();
	}

}
