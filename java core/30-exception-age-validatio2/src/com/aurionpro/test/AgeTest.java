package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InvalidAgeException;
import com.aurionpro.util.AgeUtil;

public class AgeTest {

	public static void main(String[] args) throws InvalidAgeException {

		System.out.println("Enter you age: ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		String validate = AgeUtil.validateAge(age);
		System.out.println(validate);
//        try {
//			String validate = AgeUtil.validateAge(age);
//			System.out.println(validate);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
        System.out.println("end of code");
	}

}
