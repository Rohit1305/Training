package com.aurionpro.model;

public class Rectangle {
	private double height;
	private double width;
	private String color;

	public void setheight(double height) {
		this.height=validate(height);
	}
	public void setwidth(double width) {
		this.width=validate(width);	
	}
	public void setcolor(String color) {
		this.color=validatecolor(color);	
	}
	
	public double getheight(){
		return height;
	}
	public double getwidth() {
		return width;
	}
	public String getcolor() {
		return color;
	}
	public double calculateArea() {
		return(height*width);
	}
	
	public double calculatePerimeter() {
		return 2*(height+width);
	}
	
	public double validate(double value ) {
		if(value<1) {
			return 1;
		}
		else if (value>100) {
			return 100;
		}
		else {
			return value;
		}
	}

	public String validatecolor(String value ) {
	    if(value.toLowerCase().equals("blue"))
	       {return "Blue" ;
	       }
	     else if(value.toLowerCase().equals("green")) {
	      return "Green";
	     }
	     else 
	      {
	      return "Red";
	      }
	}
}
