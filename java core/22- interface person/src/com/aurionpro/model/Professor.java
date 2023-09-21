package com.aurionpro.model;

import java.time.LocalDate;

public class Professor extends Person implements SalariedEmployee{
	private double salary;
	
	public Professor(double id, String address, LocalDate dateOfBirth, double salary) {
		super(id, address, dateOfBirth);
		this.salary = salary;
	}
	public double calculateSalary() {
		
		return salary;	
	}
}
