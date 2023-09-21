package com.aurionpro.model;

public class HatAdapter implements IItems {

	private Hat hat;

	public HatAdapter(Hat hat) {
		super();
		this.hat = hat;
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return hat.getShortName() +" "+ hat.getLongName();
	}

	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		return hat.getBasicPrice() + (hat.getBasicPrice() * hat.getTax() / 100);
	}

}