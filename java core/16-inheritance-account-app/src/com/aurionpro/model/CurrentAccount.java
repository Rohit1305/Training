package com.aurionpro.model;

public class CurrentAccount extends Account {
	private static final double OVER_DRAFT= 25000;
	
	public CurrentAccount(int id, String name, double balance) {
		super(id, name, balance);
	}


	@Override
	public boolean withdraw (double value) {
		if (super.getBalance() - value > -OVER_DRAFT) {
			super.setBalance(super.getBalance() - value);
			return true;
		}
		return false;
		
	}
	

	
	

}
