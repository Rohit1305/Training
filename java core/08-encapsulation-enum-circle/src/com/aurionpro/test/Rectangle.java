package com.aurionpro.test;

import com.aurionpro.model.ColorType;

public class Rectangle {
	private double height;
	private double width;
	private ColorType colour;
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public ColorType getColour() {
		return colour;
	}
	public void setColour(ColorType colour) {
		this.colour = colour;
	}
	public Rectangle(double height, double width, ColorType colour) {
		super();
		this.height = height;
		this.width = width;
		this.colour = colour;
	}
	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}
	public Rectangle() {
		height=0;
		width=0;
		colour=ColorType.RED;
	}
	public double calculateArea() {
		return(height*width);
	}
	
	public double calculatePerimeter() {
		return 2*(height+width);
    }
}


