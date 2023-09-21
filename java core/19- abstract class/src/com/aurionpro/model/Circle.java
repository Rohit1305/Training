package com.aurionpro.model;

public class Circle extends Shape{
	private double radius;

	public Circle(ColorType color, BorderType border, double radius) {
		super(color, border);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI*radius*radius;
	}
	
	
	
	

}
