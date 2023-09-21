package com.aurionpro.util;

public class AgeUtil {
	public static  String validateAge(int age) {
		if (age >= 18) {
			return "Eligible for voting";
		} 
		else {
			throw new RuntimeException("Invalid age");
		}
	}

}
