package com.aurionpro.model;

import java.time.LocalDate;

public class Student extends Person{
	
	private String branch;


	public Student(double id, String address, LocalDate date, String branch) {
		super(id, address, date);
		this.branch = branch;
	}

	public String getBranch() {
		return branch;
	}

	@Override
	public String toString() {
		return "Student "+super.toString()+"\nbranch=" + branch + "";
	}
	
	
	

}
