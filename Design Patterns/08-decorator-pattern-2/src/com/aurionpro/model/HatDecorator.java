package com.aurionpro.model;

public abstract class HatDecorator implements IHat {
	IHat hat;

	public HatDecorator(IHat hat) {
		super();
		this.hat = hat;
	}

	@Override
	public String getName() {
		return hat.getName();
	}

	@Override
	public double getPrice() {
		return hat.getPrice();
	}

}
