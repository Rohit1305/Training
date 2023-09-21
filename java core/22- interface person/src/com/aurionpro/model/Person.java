package com.aurionpro.model;

import java.time.LocalDate;

public class Person {
	private double id;
	private String address;
	private LocalDate dateOfBirth;
	
	public Person(double id, String address, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", address=" + address + ", dateOfBirth=" + dateOfBirth + "]";
	}

	

	

}
