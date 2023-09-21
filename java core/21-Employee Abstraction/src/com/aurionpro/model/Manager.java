package com.aurionpro.model;

public class Manager extends Employee {
	
	private double hra;
	private double da;
	private double ta;

	public Manager(double id, String name, double basic) {
		super(id, name, basic);
		this.hra=hra=getBasic()*0.25;
		this.da=da=getBasic()*0.15;
		this.ta=ta=getBasic()*0.1;
		
	}

	@Override
	public double calculateMonthlySalary() {
		return getBasic()+hra+da+ta;
	}

	@Override
	public double calculateAnnualCTC() {
		return getBasic()*12;
	}

	@Override
	public String toString() {
		return "Manager [hra=" + hra + ", da=" + da + ", ta=" + ta + ", calculateMonthlySalary()="
				+ calculateMonthlySalary() + ", calculateAnnualCTC()=" + calculateAnnualCTC() + "]";
	}
	

	
}
