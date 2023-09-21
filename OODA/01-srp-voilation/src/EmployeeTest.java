
public class EmployeeTest {

	public static void main(String[] args) {

	    Employee employee = new Employee(1, "Rohit", 100000);

//        System.out.println("Employee Details:");
//        System.out.println(employee);
//        System.out.println("Total Salary: " + employee.calculateTotalSalary());
//        System.out.println("Tax Amount: " + employee.calculateTax());
//        
//        System.out.println("\nSalary Slip:");
        employee.generateSalarySlip();
	}

}

