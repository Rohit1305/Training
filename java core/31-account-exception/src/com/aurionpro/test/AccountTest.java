package com.aurionpro.test;

import com.aurionpro.model.Account;
import com.aurionpro.model.InsufficientFundsException;

public class AccountTest {

	public static void main(String[] args) {

		Account account = new Account(1, "Rohit", 4000);
		account.Deposit(1000);
		System.out.println("amount Deposited");
		try {
			account.Withdraw(4500);
			System.out.println("withdraw successful");
		} catch (InsufficientFundsException e) {
			System.out.println(e);
		}
	}

}
