package com.aurionpro.test;

import com.aurionpro.model.Consultant;
import com.aurionpro.model.Employee;
import com.aurionpro.model.SeniorConsultant;
import com.aurionpro.model.TechLead;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee employee=new Employee(101,"ROHIT",new Consultant());
		System.out.print(employee.getGetDescription()+"\n");
		System.out.println(employee.getResponsibility());
		
		System.out.println();
		employee.changeRole(new SeniorConsultant());
		System.out.print(employee.getGetDescription()+"\n");
		System.out.println(employee.getResponsibility());
		
		System.out.println();
		employee.changeRole(new TechLead());
		System.out.println(employee);
		System.out.print(employee.getGetDescription()+"\n");
		System.out.println(employee.getResponsibility());
	}

}
