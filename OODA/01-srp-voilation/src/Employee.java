public class Employee {

    private int id;
    private String name;
    private double basic;
    private double hra;
    private double da;
    private double ta;

    public Employee(int id, String name, double basic) {
        this.id = id;
        this.name = name;
        this.basic = basic;
        this.hra = basic * 0.20;
        this.da = basic * 0.15;
        this.ta = basic * 0.10;
    }

    public double calculateTotalSalary() {
        double totalSalary = basic + hra + da + ta;
        return totalSalary;
    }

    public double calculateTax() {
    	double totalSalary = calculateTotalSalary(); 
        if (totalSalary <= 500000) { 
            return 0.0; 
        } else if (totalSalary <= 800000) { 
            return 0.1 * (totalSalary - 500000); 
        } else if (totalSalary <= 1000000) { 
            return 30000 + 0.2 * (totalSalary - 800000); 
        } else { 
            return 110000 + 0.3 * (totalSalary - 1000000); 
        } 
    }

    public void generateSalarySlip() {
        double totalSalary = calculateTotalSalary();
        double taxAmount = calculateTax();
        double netSalary = totalSalary - taxAmount;

        System.out.println("Salary Slip for Employee: " + name);
        System.out.println("--------------------------------");
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("TA: " + ta);
        System.out.println("--------------------------------");
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Tax Amount: " + taxAmount);
        System.out.println("--------------------------------");
        System.out.println("Net Salary: " + netSalary);
        System.out.println("--------------------------------");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
        this.hra=0.2 *basic;
        this.da=0.15 *basic;
        this.ta=0.10 *basic;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getTa() {
        return ta;
    }

    public void setTa(double ta) {
        this.ta = ta;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", basic=" + basic + ", hra=" + hra + ", da=" + da + ", ta="
                + ta + "]";
    }
}
