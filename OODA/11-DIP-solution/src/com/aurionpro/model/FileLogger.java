package com.aurionpro.model;

public class FileLogger implements ILogger {

	@Override
	public void log(String err) {
		System.out.println("Logged to File: " + err);
	}

}