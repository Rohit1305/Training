package com.aurionpro.model;

public class RibonelHat extends HatDecorator{

	public RibonelHat(IHat hat) {
		super(hat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Ribonel Hat "+hat.getName();
	}

	@Override
	public double getPrice() {
		return 1000+hat.getPrice();
	}
}
