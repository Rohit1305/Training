package com.aurionpro.test;

import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAccount;

public class AccountTest {

	public static void main(String[] args) {

		SavingAccount savingobj= new SavingAccount(1,"Rohit",30000);
		System.out.println(savingobj);
		savingobj.deposit(2000);
		System.out.println(savingobj);
		savingobj.withdraw(2000);
		System.out.println(savingobj);
		
		System.out.println("-----------------------");
		
		CurrentAccount currentobj= new CurrentAccount(2,"Sabat",3000);
		System.out.println(currentobj);
		savingobj.withdraw(20000);
		System.out.println(currentobj);
	}


}
