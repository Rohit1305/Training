package com.aurionpro.model;

public class Rectangle extends Shape {
	
	private double length;
	private double bredth;

	public Rectangle(ColorType color, BorderType border, double length, double bredth) {
		super(color, border);
		this.length= length;
		this.bredth= bredth;
	}

	@Override
	public double calculateArea() {
		return this.length*this.bredth;
	}
	
	
	
}
