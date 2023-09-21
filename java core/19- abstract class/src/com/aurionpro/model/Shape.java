package com.aurionpro.model;

public abstract class Shape {
	private ColorType color;
	private BorderType border;

	public Shape(ColorType color, BorderType border) {
		this.color = color;
		this.border = border;
	}
	public ColorType getColor() {
		return color;
	}
	public void setColor(ColorType color) {
		this.color = color;
	}
	public BorderType getBorder() {
		return border;
	}
	public void setBorder(BorderType border) {
		this.border = border;
	}
	
	public abstract double calculateArea();
}
