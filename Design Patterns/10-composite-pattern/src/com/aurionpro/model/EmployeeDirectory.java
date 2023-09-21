package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory implements IEmployee {
	List<IEmployee> employees;

	public EmployeeDirectory() {
		super();
		this.employees = new ArrayList<IEmployee>();
	}

	public void addEmployee(IEmployee employee) {
		employees.add(employee);
	}

	public void removeEmployee(IEmployee employee) {
		employees.remove(employee);
		}


	@Override
	public void showEmployeeDetails() {
	 for (IEmployee employee : employees) {
		        employee.showEmployeeDetails();
	   }

	}

}
