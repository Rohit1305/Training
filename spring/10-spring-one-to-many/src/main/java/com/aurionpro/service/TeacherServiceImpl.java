package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Teacher;
import com.aurionpro.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	private TeacherRepository repository;

	public TeacherServiceImpl(TeacherRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Teacher> findAll() {
		return repository.findAll();
	}

	@Override
	public Teacher save(Teacher teacher) {
		return repository.save(teacher);
	}

	@Override
	public void deleleById(int id) {

		repository.deleteById(id);
	}
	

}
