package com.aurionpro.model;

public class MathUtil {
	public double addNumber(int num1, int num2) {
		return num1+num2;
	}

	public int factorial(int num) {
		int fact=1;
		for (int i=1;i<=num;i++) {
			fact*=i;
		}
		return fact;
	}
	public int divideNumber(int num1, int num2) {
		return num1/num2;
	}
	public int[] adddNumberToArray(int[] num) {
		for(int i=0;i<num.length;i++) {
			num[i]+=10;
		}
		return num;
	}
}
