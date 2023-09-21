package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InvalidAgeException;
import com.aurionpro.util.AgeUtil;

public class AgeTest {

	public static void main(String[] args) {

		System.out.println("Enter you age: ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
        try {
			String validate = AgeUtil.validateAge(age);
			System.out.println(validate);
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}
	}

}
