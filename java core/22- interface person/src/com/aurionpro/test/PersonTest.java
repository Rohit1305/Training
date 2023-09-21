package com.aurionpro.test;

import java.time.LocalDate;

import com.aurionpro.model.Person;
import com.aurionpro.model.Professor;
import com.aurionpro.model.Student;

public class PersonTest {

	public static void main(String[] args) {

		Person person =new Person(10,"mumbai",LocalDate.of(2023, 6, 18));
		
	    System.out.println(person);
		
		Person student = new Student(10, "Mumbai", LocalDate.of(2000, 6, 17),"CS");
		System.out.println(student);
		
		System.out.println("=========================");
		
		Person professor = new Professor(101, "Navi Mumbai", LocalDate.of(1985, 6, 28),20000);
		System.out.println(professor);
	}

}
