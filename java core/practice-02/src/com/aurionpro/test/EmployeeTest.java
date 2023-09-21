package com.aurionpro.test;

import com.aurionpro.model.Employee;
import com.aurionpro.model.EmployeeController;

import java.io.*;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeController controller = new EmployeeController();

        // Deserialize employees from file
        controller.deserializeEmployeesFromFile();

        // Run the menu
        controller.runMenu();

        // Serialize employees to file
        controller.serializeEmployeesToFile();
    }

    public static void findAllEmployeesInDepartment(EmployeeController controller, int departmentNo) {
        System.out.println("Employees in Department " + departmentNo + ":");
        for (Employee emp : controller.getEmployees()) {
            if (emp.getDepartmentNo() == departmentNo) {
                System.out.println(emp.toString());
            }
        }
    }
}
