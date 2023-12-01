package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Teacher;

public interface TeacherService {

	List<Teacher> findAll();

	Teacher save(Teacher teacher);

	void deleleById(int id);

}
