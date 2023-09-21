package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.aurionpro.model.Student;

public class StudentTest {

	public static void main(String[] args) {

		List<Student> stu = new ArrayList<>();

		stu.add(new Student(1, "Rohit", 90));
		stu.add(new Student(2, "Akash", 20));
		stu.add(new Student(3, "Yash", 30));
		stu.add(new Student(4, "Nitesh", 40));
		stu.add(new Student(4, "Joy", 60));

		List<Student> highest = new ArrayList<>();

		for (Student x : stu) {
			if (x.getPercentage() >= 35) {
				highest.add(x);
			}
		}
		System.out.println(highest);
		System.out.println("==========================");
		
		Student studentWithLeastPercentage = Collections.min(stu, Comparator.comparingDouble(Student::getPercentage));

        System.out.println("Student with least percentage: " + studentWithLeastPercentage);
        
        
        
        
        System.out.println("==========================");
        Collections.sort(stu, Comparator.comparingDouble(Student::getPercentage));

        System.out.println("Students sorted by percentage in ascending order:");
        for (Student student : stu) {
            System.out.println(student);
        }
        
        System.out.println("==========================");
        Collections.sort(stu, Comparator.comparing(Student::getName));

        System.out.println("Students sorted by Nmae in ascending order:");
        for (Student student : stu) {
            System.out.println(student.getName()+""+student.getPercentage());
        }

	}

}
