package com.aurionpro.test;

public class AccountTest {
	static int count =0;

	public static void main(String[] args) {
		Account acc1 =new Account();
		
		Account acc2 = new Account(10);
		Account acc3= new Account(11,"Rohit",1000);
		System.out.println("no of objects :" + Account.getCount());
		

	}
	

}
