package com.aurionpro.test;
import java.util.Scanner;

import com.aurionpro.model.ColorType;
import com.aurionpro.model.Rectangle;

public class RectangleTset {
	public static void main(String[] args) {	
	   Rectangle rectangle = new Rectangle();  
	   getinput(rectangle);
	   printboth(rectangle);
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
