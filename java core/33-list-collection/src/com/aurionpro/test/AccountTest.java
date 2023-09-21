package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.aurionpro.model.Account;

public class AccountTest {

	public static void main(String[] args) {

		List<Account> accounts = new ArrayList<>();

		accounts.add(new Account(1, "Rohit", 10000));
		accounts.add(new Account(2, "Akash", 20000));
		accounts.add(new Account(3, "Yash", 30000));
		accounts.add(new Account(4, "Nitesh", 40000));

		System.out.println(accounts);

		for (Account account : accounts) {
			System.out.println(account.getName());
		}
//		accounts.forEach(System.out::println);
		System.out.println("==========================");

		Account test = new Account(1, "Rohit", 10000);
		System.out.println(accounts.contains(test));
		System.out.println("==========================");
		
		List<Account> highest = new ArrayList<>();
		
		for(Account x:accounts) {
			if(x.getBalance()>=35000) {
				highest.add(x);
			}
		}
		System.out.println(highest);
		System.out.println("==========================");
		

		Collections.sort(accounts,Collections.reverseOrder());
		System.out.println(accounts);
		System.out.println("==========================");
	}

}
