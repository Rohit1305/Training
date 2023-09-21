package com.aurionpro.model;

public class WheelAlign extends CarServiceDecorator implements ICarService{

	public WheelAlign(ICarService carObj) {
		super(carObj);
	}

	@Override
	public double getCost() {
		return 400+super.getCost();
	}
}
