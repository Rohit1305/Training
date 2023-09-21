package com.aurionpro.model;

public class GoldenHat extends HatDecorator{

	public GoldenHat(IHat hat) {
		super(hat);
	}
	
	@Override
	public String getName() {
		return "Golden Hat "+hat.getName();
	}

	@Override
	public double getPrice() {
		return 500+hat.getPrice();
	}

}
