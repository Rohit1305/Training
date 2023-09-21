package com.aurionpro.model;

public class Developer extends Employee {
	private double pa;
	private double ota;
	
	public Developer(double id, String name, double basic) {
		super(id, name, basic);
		this.pa=pa=getBasic()*0.3;
		this.ota=ota=getBasic()*0.2;
	}
	
	@Override
	public double calculateMonthlySalary() {
		// TODO Auto-generated method stub
		return super.getBasic()+pa+ota;
	}
	@Override
	public double calculateAnnualCTC() {
		// TODO Auto-generated method stub
		return super.getBasic()*12;
	}

	@Override
	public String toString() {
		return "Developer [pa=" + pa + ", ota=" + ota + ", calculateMonthlySalary()=" + calculateMonthlySalary()
				+ ", calculateAnnualCTC()=" + calculateAnnualCTC() + "]";
	}
	
	
	

}
