package com.aurionpro.model;

public class StudentUtility {
	
	public int findFactorial(int num) {
		int fact=1;
		int number;
		for(int i=1;i>0;i--){
		fact=fact*i;
		}
		return num;
	}
	
	public boolean isPrime(int num) {
		if(num<=1) 
			return false;
		
		for (int i=2;i<num/2;i++) {
			if(num%i==0) {
				return false;
			}
		}
}
}
