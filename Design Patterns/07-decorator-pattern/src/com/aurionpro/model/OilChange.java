package com.aurionpro.model;

public class OilChange extends CarServiceDecorator implements ICarService {
	public OilChange(ICarService carObj) {
		super(carObj);
	}

	@Override
	public double getCost() {
		return 500+super.getCost();
	}

}
