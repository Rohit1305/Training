package com.aurionpro.model;

public class Robot implements IWorkable {

	@Override
	public void start() {
		System.out.println("Robot is starting.");
	}

	@Override
	public void stop() {
		System.out.println("Robot stopped.");

	}
}