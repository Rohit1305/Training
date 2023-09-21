package com.aurionpro.model;

public class SMSNotifier implements INotifier{

	@Override
	public void notifyUser(Account account, double amount, String string) {

		System.out.println("SMS Notification Account no  " + account.getAccountNumber());
		System.out.println("current balance is "+ account.getBalance());
	}

}
