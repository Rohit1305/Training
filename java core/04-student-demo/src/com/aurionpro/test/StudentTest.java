package com.aurionpro.test;

import com.aurionpro.model.Student;

public class StudentTest {

	public static void main(String[] args) {
     Student student = new Student();
     student.id =10;
     student.name ="Rohit";
     student.email="rohit@aurionpro.com";
     System.out.println("id is "+student.id);
     System.out.println("name is "+student.name);
     System.out.println("email is "+student.email);
     
     
	}

}
