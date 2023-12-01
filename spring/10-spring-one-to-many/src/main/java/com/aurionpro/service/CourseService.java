package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Course;

public interface CourseService {

	List<Course> findAll();

	Course save(Course course);

	void deleleById(int id);

}
