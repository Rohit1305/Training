package com.aurionpro.com;

public class SecondLargest {

	public static void main(String[] args) {
     
	int largest = Integer.parseInt(args[0]);
	int second= Integer.MIN_VALUE;
	   for (int i =1 ; i<args.length; i++)
	   {
	      if (largest<Integer.parseInt(args[i])){
	         second = largest;
	         largest = Integer.parseInt(args[i]);
	      }
	      else if (second <Integer.parseInt(args[i])) {
	    	  second =Integer.parseInt(args[i]);
	      }
	   }
	   System.out.println(second);
	   
		
	}
}
