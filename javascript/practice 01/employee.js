class Office {
    constructor(address, city, emailId, country) {
      this.country = country;
      this.city = city;
      this.emailId = emailId;
      this.address = address;
    }
  }
  
  class Personal {
    constructor(address, city, emailId, country) {
      this.country = country;
      this.city = city;
      this.emailId = emailId;
      this.address = address;
    }
  }
  
  class Employee {
    #age
    constructor(
      firstName,
      lastName,
      fullName,
      monthlySalary,
      annualSalary,
      dateOfJoining,
      employeeId,
      designation,
      contactNumber,
      personal,
      office,
      age,
      dateOfBirth
    ) {
      this.employeeId = employeeId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.fullName = fullName;
      this.monthlySalary = monthlySalary;
      this.annualSalary = annualSalary;
      this.dateOfJoining = dateOfJoining;
      this.designation = designation;
      this.reportingOfficer = null; // Initially, no reporting officer assigned
      this.#age = age;
      this.dateOfBirth = dateOfBirth;
      this.contactNumber = contactNumber;
      this.personalInfo = personal;
      this.workInfo = office;
      this.subordinates = [];
    }
  
    static newEmployee(
      employeeId,
      firstName,
      lastName,
      monthlySalary,
      designation,
      contactNumber,
      dateOfJoining,
      personalEmail,
      companyEmail,
      dateOfBirth,
      personalAddress,
      personalCity,
      personalCountry,
      companyAddress,
      companyCity,
      companyCountry
    ) {
      if (typeof firstName !== "string") {
        return "Invalid firstName";
      }
      if (typeof lastName !== "string") {
        return "Invalid lastName";
      }
  
      if (typeof designation !== "string") {
        return "Invalid designation";
      }
      if (typeof personalEmail !== "string") {
        return "Invalid personalEmail";
      }
      if (typeof personalCity !== "string") {
        return "Invalid personalCity";
      }
      if (typeof personalCountry !== "string") {
        return "Invalid personalCountry";
      }
  
      if (typeof companyEmail !== "string") {
        return "Invalid companyEmail";
      }
      if (typeof companyAddress !== "string") {
        return "Invalid companyAddress";
      }
      if (typeof companyCity !== "string") {
        return "Invalid companyCity";
      }
      if (typeof companyCountry !== "string") {
        return "Invalid companyCountry";
      }
      if (typeof monthlySalary !== "number") {
        return "Invalid monthlySalary";
      }
      if (typeof contactNumber !== "number") {
        return "Invalid contactNumber";
      }
  
      const fullName = firstName + " " + lastName;
      const annualSalary = monthlySalary * 12;
      const age = Employee.calculateDate(dateOfBirth);
  
      const personal = new Personal(
        personalAddress,
        personalCity,
        personalEmail,
        personalCountry
      );
      const office = new Office(companyAddress, companyCity, companyEmail, companyCountry);
  
      return new Employee(
        firstName,
        lastName,
        fullName,
        monthlySalary,
        annualSalary,
        dateOfJoining,
        employeeId,
        designation,
        contactNumber,
        personal,
        office,
        age,
        dateOfBirth
      );
    }
  
    static calculateDate(date) {
      const today = new Date();
      const birthDate = new Date(date);
  
      let age = today.getFullYear() - birthDate.getFullYear();
      const monthDiff = today.getMonth() - birthDate.getMonth();

      if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
        age--;
      }
  
      return age;
    }
  
    addReportingOfficer(reportingOfficer) {
      if (!(reportingOfficer instanceof Employee)) {
        return "Reporting Officer does not belong to the same organization";
      } else {
        this.reportingOfficer = reportingOfficer.fullName;
        reportingOfficer.addSubordinate(this);
      }
    }
  
    addSubordinate(subordinate) {
        if (subordinate instanceof Employee) {
          this.subordinates.push(subordinate.fullName);
        //   subordinate.reportingOfficer = this.fullName; // Set the reporting officer for the subordinate
        } else {
          console.log("Must be an employee");
        }
      }

    getAge(){
      return this.#age
    }
  
    printSubordinates() {
      if (this.subordinates.length === 0) {
        console.log(`${this.fullName} has no subordinates.`);
      } else {
        console.log(`${this.fullName}'s subordinates:`);
        this.subordinates.forEach((subordinate, index) => {
          console.log(`${index + 1}. ${subordinate}`);
        });
      }
    }
  }
  
  const e1 = Employee.newEmployee(
    101,
    "Rohit",
    "Sabat",
    30000,
    "Trainee Engineer",
    9000000000,
    "2022-1-2",
    "rohitsabat@gmail.com",
    "rohitsabat@aurionpro.com",
    "2001-12-22",
    "hariyali village",
    "vikhroli",
    "india",
    "rabale",
    "navi mumbai",
    "india"
  );
  
  const e2 = Employee.newEmployee(
    102,
    "John",
    "Doe",
    40000,
    "Manager",
    8000000000,
    "2021-10-15",
    "johndoe@gmail.com",
    "johndoe@aurionpro.com",
    "1985-05-10",
    "Green Street",
    "New York",
    "USA",
    "Aurion Avenue",
    "Silicon Valley",
    "USA"
  );
  
  const e3 = Employee.newEmployee(
    103,
    "Jane",
    "Smith",
    25000,
    "Assistant",
    7000000000,
    "2023-03-20",
    "janesmith@gmail.com",
    "janesmith@aurionpro.com",
    "1990-08-28",
    "Sunnydale",
    "Los Angeles",
    "USA",
    "Tech Park",
    "Chicago",
    "USA"
  );
  
  // e1.addReportingOfficer(e2);
  // e1.addSubordinate(e3);
 
  console.log(e1.age);
  // console.log(e1.#age);

  console.log(e1);
  // e1.printSubordinates();

  

  