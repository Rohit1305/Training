package com.aurionpro.model;

import java.util.Date;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String password;
    private Date dob;
    private Gender gender; 
    private String designation;
	public Employee(int id, String name, String email, String password, Date dob, Gender gender, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.designation = designation;
	}
	public Employee() {
		super();
	}
	public Employee(String name, String email, String password, Date dob, Gender gender, String designation) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ ", gender=" + gender + ", designation=" + designation + "]";
	}
    
    
}
