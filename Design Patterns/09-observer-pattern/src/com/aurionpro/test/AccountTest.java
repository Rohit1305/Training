package com.aurionpro.test;

import com.aurionpro.model.Account;
import com.aurionpro.model.EmailNotifier;
import com.aurionpro.model.SMSNotifier;

public class AccountTest {
	public static void main (String args[]) {
	Account acc = new Account(101, "Rohit", 10000);
    acc.registerNotifier(new EmailNotifier());
    acc.registerNotifier(new SMSNotifier());

    try {
        acc.deposit(5000);
    } catch (Exception e) {
        System.out.println("Deposit failed: " + e.getMessage());
    }

    System.out.println("-------------------------------------------");

    try {
        acc.withdraw(500);
    } catch (Exception e) {
        System.out.println("Withdrawal failed: " + e.getMessage());
    }
}
}
