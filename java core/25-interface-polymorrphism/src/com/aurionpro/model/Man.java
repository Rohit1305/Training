package com.aurionpro.model;

public class Man implements IMannerable {

	@Override
	public void welcomeGreet() {

	System.out.println("welcome");}

	@Override
	public void departGreet() {

		System.out.println("greet");
	}
}
