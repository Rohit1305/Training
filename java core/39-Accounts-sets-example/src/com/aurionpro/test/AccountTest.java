package com.aurionpro.test;

import java.util.HashSet;
import java.util.Set;

import com.aurionpro.model.Account;

public class AccountTest {

	public static void main(String[] args) {
		Set<Account> accounts = new HashSet<>();

		Account acc1 = new Account(1, "Sahil", "Savings");
		Account acc2 = new Account(2, "Sarvesh", "Current");
		Account acc3 = acc1;
		Account acc4 = new Account(1, "Sahil", "Savings");

		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		accounts.add(acc4);

		for (Account account : accounts) {
			System.out.println(account);
			System.out.println("\n");
		}

	}

}
