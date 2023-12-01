package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorTechDetail;

public interface InstructorDetailService {

	List<InstructorTechDetail> findAll();

	void deleleById(int id);

	InstructorTechDetail save(InstructorTechDetail detail);

	InstructorTechDetail findById(int detailsId);

	Instructor getInstructor(int id);
	


}
