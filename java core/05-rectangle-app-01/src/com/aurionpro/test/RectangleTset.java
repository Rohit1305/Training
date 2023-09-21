package com.aurionpro.test;
import java.util.Scanner;
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
    	 double height= sc.nextDouble();
    	 rectangle.height=height;
    	 System.out.println("enter width");
    	 double width = sc.nextDouble();
    	 rectangle.width=width;	 
     }
     public static void printboth(Rectangle rectangle) {
    	 System.out.println(rectangle.calculateArea());
         System.out.println(rectangle.calculatePerimeter());
     }	

}
