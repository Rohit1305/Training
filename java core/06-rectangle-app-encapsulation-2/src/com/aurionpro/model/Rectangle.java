package com.aurionpro.model;

public class Rectangle {
	private double height;
	private double width;
	
	public void setheight(double height) {
		this.height=height;	
	}
	public void setwidth(double width) {
		this.width=width;	
	}
	public double getheight(){
		return height;
	}
	public double getwidth() {
		return width;
	}
	
	public double calculateArea() {
		return(height*width);
	}
	
	public double calculatePerimeter() {
		return 2*(height+width);
	}

}
