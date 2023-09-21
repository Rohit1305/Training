package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Circle;
import com.aurionpro.model.ColorType;

public class RecctangleTest {

	public static void main(String[] args) {
		 Rectangle obj= new Rectangle();
		  printAreaAndPerimeter(obj);
		  Rectangle obj1= new Rectangle(10,20);
		  printAreaAndPerimeter(obj1);

		  Rectangle obj2= new Rectangle(19,20,ColorType.valueOf("BLUE"));
		  printAreaAndPerimeter(obj2); 
		 }


private static void printAreaAndPerimeter(Rectangle obj) {
	   System.out.println("Radius of rectangle:"+obj.getHeight());
	  System.out.println("border of rectangle:"+obj.getWidth());
	  System.out.println("Colour of rectangle:"+obj.getColour());
	   
	   System.out.println("area of circle :"+obj.calculateArea());
	   System.out.println("perimeter:"+obj.calculatePerimeter());
	
}
}