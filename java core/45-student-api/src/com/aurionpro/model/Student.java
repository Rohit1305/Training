package com.aurionpro.model;

import java.util.List;

public class Student {
	private int id;
	private String fullname;
	private double percentage;
	private List<String> hobbies;
	
	public Student(int id, String fullname, double percentage, List<String> hobbies) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.percentage = percentage;
		this.hobbies = hobbies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullname=" + fullname + ", percentage=" + percentage + ", hobbies=" + hobbies
				+ "]";
	}
	
	
	

}
