package com.aurionpro.test;
import com.aurionpro.model.Employee;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeTest {

    private static final String filepath = "D:\\java22\\test-02\\src\\emp.txt";

    private List<Employee> employees = new ArrayList<>();

    public void saveEmployeesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            outputStream.writeObject(employees);
            System.out.println("Employees saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving employees to file: " + e.getMessage());
        }
    }

    public void loadEmployeesFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filepath))) {
            employees = (List<Employee>) inputStream.readObject();
            System.out.println("Employees loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading employees from file: " + e.getMessage());
        }
    }
    
    private void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployeesToFile();
    }

    private void deleteEmployee(Employee employee) {
        employees.remove(employee);
        saveEmployeesToFile();
    }

    public List<Employee> findEmployeesInDepartment(int departmentNo) {
        List<Employee> employeesInDepartment = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartmentNo() == departmentNo) {
                employeesInDepartment.add(employee);
            }
        }
        return employeesInDepartment;
    }

    public Map<Integer, Integer> countEmployeesPerDepartment() {
        Map<Integer, Integer> departmentEmployeeCount = new HashMap<>();
        for (Employee employee : employees) {
            int departmentNo = employee.getDepartmentNo();
            departmentEmployeeCount.put(departmentNo, departmentEmployeeCount.getOrDefault(departmentNo, 0) + 1);
        }
        return departmentEmployeeCount;
    }

    public Employee findImmediateManager(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                int managerID = employee.getManagerId();
                for (Employee manager : employees) {
                    if (manager.getEmployeeID() == managerID) {
                        return manager;
                    }
                }
                break;
            }
        }
        return null; 
    }

    public Map<Integer, Employee> findHighestPaidInEachDepartment() {
        Map<Integer, Employee> highestPaidPerDepartment = new HashMap<>();
        for (Employee employee : employees) {
            int departmentNo = employee.getDepartmentNo();
            if (!highestPaidPerDepartment.containsKey(departmentNo) ||
                employee.getSalary() > highestPaidPerDepartment.get(departmentNo).getSalary()) {
                highestPaidPerDepartment.put(departmentNo, employee);
            }
        }
        return highestPaidPerDepartment;
    }

    public Map<String, Employee> findHighestPaidInEachRole() {
        Map<String, Employee> highestPaidPerRole = new HashMap<>();
        for (Employee employee : employees) {
            String job = employee.getJob();
            if (!highestPaidPerRole.containsKey(job) ||
                employee.getSalary() > highestPaidPerRole.get(job).getSalary()) {
                highestPaidPerRole.put(job, employee);
            }
        }
        return highestPaidPerRole;
    }

    public List<Employee> findEmployeesJoinedBetweenDates(Date startDate, Date endDate) {
        List<Employee> employeesJoinedBetweenDates = new ArrayList<>();
        for (Employee employee : employees) {
            Date joiningDate = employee.getJoiningDate();
            if (joiningDate.after(startDate) && joiningDate.before(endDate)) {
                employeesJoinedBetweenDates.add(employee);
            }
        }
        return employeesJoinedBetweenDates;
    }

    public Employee findSalesmanWithHighestCommission() {
        Employee highestCommissionSalesman = null;
        for (Employee employee : employees) {
            if ("SALESMAN".equals(employee.getJob())) {
                if (highestCommissionSalesman == null ||
                    employee.getCommision() > highestCommissionSalesman.getCommision()) {
                    highestCommissionSalesman = employee;
                }
            }
        }
        return highestCommissionSalesman;
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public static void main(String[] args) throws ParseException {
        EmployeeTest employeeTest = new EmployeeTest();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        employeeTest.addEmployee(new Employee(1, "Rohit", "MANAGER", 0, dateFormat.parse("01-JAN-80"), 5000, 0, 10));
        employeeTest.addEmployee(new Employee(2, "Ujjwal", "SALESMAN", 1, dateFormat.parse("15-FEB-81"), 3000, 500, 20));
        employeeTest.addEmployee(new Employee(3, "Akash", "ANALYST", 2, dateFormat.parse("15-MAR-82"), 4000, 400, 30));
        employeeTest.addEmployee(new Employee(4, "Yash", "CLERK", 3, dateFormat.parse("15-APR-83"), 3000, 300, 40));

        employeeTest.saveEmployeesToFile();

        employeeTest.loadEmployeesFromFile();

        List<Employee> employeesInDept = employeeTest.findEmployeesInDepartment(10);
        System.out.println("Employees in department 10: " + employeesInDept);
        
        // Find immediate manager
        Employee manager = employeeTest.findImmediateManager(2);
        System.out.println("Immediate manager of employee 2: " + manager);

     // Count of employees in each department
        Map<Integer, Integer> deptEmployeeCount = employeeTest.countEmployeesPerDepartment();
        System.out.println("Employees count per department: " + deptEmployeeCount);

        // Find highest paid in each department
        Map<Integer, Employee> highestPaidPerDept = employeeTest.findHighestPaidInEachDepartment();
        System.out.println("Highest paid per department: " + highestPaidPerDept);

        // Find highest paid in each role
        Map<String, Employee> highestPaidPerRole = employeeTest.findHighestPaidInEachRole();
        System.out.println("Highest paid per role: " + highestPaidPerRole);

        // Find employees joined between dates
        Date startDate = dateFormat.parse("01-JAN-80");
        Date endDate = dateFormat.parse("31-DEC-81");
        List<Employee> employeesJoinedBetweenDates = employeeTest.findEmployeesJoinedBetweenDates(startDate, endDate);
        System.out.println("Employees joined between " + startDate + " and " + endDate + ": " + employeesJoinedBetweenDates);

        // Find salesman with highest commission
        Employee highestCommissionSalesman = employeeTest.findSalesmanWithHighestCommission();
        System.out.println("Salesman with highest commission: " + highestCommissionSalesman);

        // Calculate total salary of all employees
        double totalSalary = employeeTest.calculateTotalSalary();
        System.out.println("Total salary of all employees: " + totalSalary);
    
        
    }
}
