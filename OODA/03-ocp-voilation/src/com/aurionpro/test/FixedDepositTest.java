package com.aurionpro.test;

import com.aurionpro.model.FestivalType;
import com.aurionpro.model.FixedDeposit;

public class FixedDepositTest {
	public static void main(String[] args) {
		FixedDeposit fixed = new FixedDeposit(101, "ROHIT", 10000, 5, FestivalType.DIWALI);
		System.out.println(fixed);
	}

}
