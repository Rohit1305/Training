package com.aurionpro.test;

import com.aurionpro.model.Employee;
import com.aurionpro.model.PrinterUtil;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee=new Employee(101, "Rohit", 100000);
		new PrinterUtil().printSalarySlip(employee);
	}

}
