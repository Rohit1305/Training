package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Instructor;

public interface InstructorService {
	List <Instructor> findAll();

	Instructor save(Instructor instructor);

	void deleleById(int id);

	void updateInstructorDetails(int id, int detailId);


}
