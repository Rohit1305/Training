package com.aurionpro.model;

import java.time.LocalDate;

public class Bike extends Vehicle implements IMovable {

	public Bike(String brand, LocalDate dom) {
		super(brand, dom);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move() {
		System.out.println("bike is moving");
	}

	@Override
	public void showTopSpeed() {
		System.out.println("speed of bike");
	}
}
