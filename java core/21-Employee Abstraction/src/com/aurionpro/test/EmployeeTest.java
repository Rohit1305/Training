package com.aurionpro.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.aurionpro.model.Accountant;
import com.aurionpro.model.Developer;
import com.aurionpro.model.Employee;
import com.aurionpro.model.Manager;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee emp[]= {
				new Manager(1, "Colt", 30000),
				new Developer(2, "Rosa", 40000),
				new Accountant(3, "John", 50000)
		};
		try {
		FileOutputStream file =new FileOutputStream("D:\\java\\serial\\file2.txt");    
		 ObjectOutputStream out=new ObjectOutputStream(file);  
		 out.writeObject(emp); 
		 out.close();    
		 file.close();
		 System.out.println("success");    
		  }catch(Exception e)
	{
		System.out.println(e);
	}
		try {
			 FileInputStream file=new FileInputStream("D:\\java\\serial\\file.txt");
			 ObjectInputStream in= new ObjectInputStream(file);
			 Employee[] emps=(Employee[])in.readObject();
			
					printSalarySlip(emps);
				
				
			 in.close();
			 file.close();
			 }
			 catch(Exception e){
			  e.printStackTrace();
			  
			 }

	}
	public static void printSalarySlip(Employee[] e) {
		for(Employee each :e)
		System.out.println(each);
//        System.out.println("Salary Slip ");        
//        System.out.println("Employee ID: " + e.id);
//        System.out.println("Employee Name: " + e.name);        
//        System.out.println("Basic Salary: $" + e.basic);
//        System.out.println("Monthly Salary: $" + calculateMonthlySalary());        
//        System.out.println("Annual CTC: $" + calculateAnnualCTC());
//        System.out.println("-----------------------------------");       
//     
    }
}















// Manager manager = new Manager(1, "Colt", 30000);
// Developer developer = new Developer(2, "Rosa", 40000);
// Accountant accountant = new Accountant(3, "John", 50000);

// double managerMonthlySalary = manager.calculateMonthlySalary();
// double managerAnnualCTC = manager.calculateAnnualCTC();
//
// double developerMonthlySalary = developer.calculateMonthlySalary();
// double developerAnnualCTC = developer.calculateAnnualCTC();
//
// double accountantMonthlySalary = accountant.calculateMonthlySalary();
// double accountantAnnualCTC = accountant.calculateAnnualCTC();
//
// System.out.println("Manager Monthly Salary: " + managerMonthlySalary);
// System.out.println("Manager Annual CTC: " + managerAnnualCTC);
//
// System.out.println("Developer Monthly Salary: " + developerMonthlySalary);
// System.out.println("Developer Annual CTC: " + developerAnnualCTC);
//
// System.out.println("Accountant Monthly Salary: " + accountantMonthlySalary);
// System.out.println("Accountant Annual CTC: " + accountantAnnualCTC);
