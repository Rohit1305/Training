package com.aurionpro.controller;

import com.aurionpro.model.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private List<Employee> employees;
    private static final String filePath = "D:\\java22\\practice-02\\src\\emp.txt";

    public EmployeeController() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added: " + emp.getEmployeeName());
    }

    public void deleteEmployee(Employee emp) {
        employees.remove(emp);
        System.out.println("Employee deleted: " + emp.getEmployeeName());
    }

    public void displayEmployees() {
        System.out.println("List of Employees:");
        for (Employee emp : employees) {
            System.out.println(emp.toString());
        }
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int employeeID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Employee Name: ");
                    String employeeName = scanner.nextLine();
                    System.out.print("Enter Employee Job: ");
                    String job = scanner.nextLine();
                    System.out.print("Enter Manager ID: ");
                    int managerId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Joining Date (yyyy-MM-dd): ");
                    String joiningDateString = scanner.nextLine();
                    Date joiningDate = null;
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        joiningDate = dateFormat.parse(joiningDateString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter Commission: ");
                    double commission = scanner.nextDouble();
                    System.out.print("Enter Department Number: ");
                    int departmentNo = scanner.nextInt();
                    Employee newEmployee = new Employee(employeeID, employeeName, job, managerId, joiningDate, salary, commission, departmentNo);
                    addEmployee(newEmployee);
                    break;
                case 2:
                    // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    int employeeIDToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Employee employeeToDelete = null;
                    for (Employee emp : employees) {
                        if (emp.getEmployeeID() == employeeIDToDelete) {
                            employeeToDelete = emp;
                            break;
                        }
                    }
                    if (employeeToDelete != null) {
                        deleteEmployee(employeeToDelete);
                    } else {
                        System.out.println("Employee with ID " + employeeIDToDelete + " not found.");
                    }
                    break;
                case 3:
                    // Display Employees
                    displayEmployees();
                    break;
                case 4:
                    // Exit
                    scanner.close();
                    serializeEmployeesToFile();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void serializeEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized and saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeEmployeesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
