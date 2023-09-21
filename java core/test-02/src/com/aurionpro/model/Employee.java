package com.aurionpro.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private int employeeID;
	private String employeeName;
	private String job;
	private int managerId;
	private Date joiningDate;
	private double salary;
	private double commision;
	private int departmentNo;

	public Employee(int employeeID, String employeeName, String job, int managerId, Date joiningDate, double salary,
			double commision, int departmentNo) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.job = job;
		this.managerId = managerId;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.commision = commision;
		this.departmentNo = departmentNo;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	@Override
	public String toString() {
		return "\n Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", job=" + job + ", managerId="
				+ managerId + ", joiningDate=" + joiningDate + ", salary=" + salary + ", commision=" + commision
				+ ", departmentNo=" + departmentNo + "]";
	}
}
