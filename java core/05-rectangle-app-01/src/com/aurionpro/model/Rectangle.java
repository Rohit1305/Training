package com.aurionpro.model;

public class Rectangle {
	public double height;
	public double width;
	
	public double calculateArea() {
		return(height*width);
	}
	
	public double calculatePerimeter() {
		return 2*(height+width);
	}

}
