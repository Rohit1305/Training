package com.aurionpro.model;

import java.util.Scanner;

public class RectangleTest {
  public static void main (String args[]) {

	Rectangle[] rect = new Rectangle[2];
	for(int i=0;i<rect.length;i++) {
		rect[i]=new Rectangle();
		getinput(rect[i]);
		printboth(rect[i]);
	}
  
}
private static void getinput(Rectangle rectangle) {
	 Scanner sc =new Scanner(System.in); 
	 System.out.println("enter height");
	 rectangle.setheight(sc.nextDouble());
	 
	 System.out.println("enter width");
    rectangle.setwidth(sc.nextDouble());
    
    System.out.println("enter color");
    rectangle.setcolor(ColorType.valueOf(sc.next().toUpperCase()));
	 	 
}
public static void printboth(Rectangle rectangle) {
	 System.out.println("height of :"+rectangle.getheight());
    System.out.println("width of :"+rectangle.getwidth());
    System.out.println("color of :"+rectangle.getcolor());
	 System.out.println(rectangle.calculateArea());
    System.out.println(rectangle.calculatePerimeter());
}
}