package com.aurionpro.model;

import java.io.Serializable;

public abstract class Employee implements  Serializable{
	private double id;
	private String name;
	private double basic;
	
	public Employee(double id, String name, double basic) {
		super();
		this.id = id;
		this.name = name;
		this.basic = basic;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", basic=" + basic + ", calculateMonthlySalary()="
				+ calculateMonthlySalary() + ", calculateAnnualCTC()=" + calculateAnnualCTC() + "]";
	}
	
	public abstract double calculateMonthlySalary();
	
	public abstract double calculateAnnualCTC();
	


}
