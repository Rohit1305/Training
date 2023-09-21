package com.aurionpro.com;

public class PassValue {

	public static void main(String[] args) {
		int num[] = { 20, 30, 40, 50 };
		increment(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

	private static void increment(int[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i]++;
		}

	}

}
