package com.aurionpro.com;

public class PassbyValue {

	public static void main(String[] args) {
    int num=20;
    System.out.println("Before print"+num);
     num=IncrementbyOne(num);
    System.out.println("after Print"+ num); 
	}
	public static int IncrementbyOne(int y){
		++y;
		return y;
	}
 }

