package com.aurionpro.test;

import com.aurionpro.model.FixedDeposit;
import com.aurionpro.model.HoliInterest;

public class FixedDepositTest {
	public static void main(String[] args) {
		FixedDeposit fixed = new FixedDeposit(101, "ROHIT", 1000, 2, new HoliInterest());
		System.out.println(fixed);
	}
}