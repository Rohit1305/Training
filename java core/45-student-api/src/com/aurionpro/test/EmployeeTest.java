package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.aurionpro.model.Employee;
import com.aurionpro.model.Student;

public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(
	            new Employee(101, "Rohit ", 50000.0, "IT"),
	            new Employee(102, "Akash", 60000.0, "HR"),
	            new Employee(103, "Siddhi", 75000.0, "IT"),
	            new Employee(104, "Rahul", 30000.0, "HR"),
	            new Employee(105, "Ujjwal", 40000.0, "HR")
	        );
		
//        employees.stream()
//        .forEach(employee -> 
//        System.out.println("Name: " + employee.getName() + ", Category: " + employee.getSalary() + ", Department: " + employee.getDepartment()));

        Map<String, List<Employee>> empl = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        System.out.println(empl);
        
        System.out.println("============================================");
//        empl.forEach((department, empList) -> {
//            System.out.println("Department: " + department);
//            empList.forEach(System.out::println);
//        });
        empl.forEach((key, value) -> {
        	System.out.println(key +":" +value);
        });
        
        System.out.println("==================Total==========================");
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Total Salary: " + totalSalary);
        
        System.out.println("===================Highest=========================");
        
        double highestSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);

            employees.stream()
                .filter(employee -> employee.getSalary() == highestSalary)
                .forEach(employee -> System.out.println("Employee with the highest salary: " + employee.getName()));
        
        
        System.out.println("============================================");
        
	}

}
