package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Course;
import com.aurionpro.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	private CourseRepository repository;

	public CourseServiceImpl(CourseRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Course> findAll() {
		return repository.findAll();
	}

	@Override
	public Course save(Course course) {
		return repository.save(course);
	}

	@Override
	public void deleleById(int id) {
		repository.deleteById(id);
	}
	
}
