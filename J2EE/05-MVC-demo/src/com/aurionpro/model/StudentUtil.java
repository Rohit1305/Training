package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class StudentUtil {

	private List<Student> allStudents;

	public StudentUtil() {
		allStudents = new ArrayList<>();
		allStudents.add(new Student(1, "rohit", "rohit@gamil.com", 70));
		allStudents.add(new Student(2, "virat", "virat@gamil.com", 80));
		allStudents.add(new Student(3, "sachin", "sachin@gamil.com", 90));
	}
//	public void addStudent(Student student) {
//		allStudents.add(student);
//	}
	
	public List<Student> getAllStudents() {
		return allStudents;
	}
}
