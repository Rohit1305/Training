package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.repository.InstructorDetailsRepository;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {
	private InstructorDetailsRepository repository;

	public InstructorDetailServiceImpl(InstructorDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<InstructorTechDetail> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleleById(int id) {

		repository.deleteById(id);
	}

	@Override
	public InstructorTechDetail save(InstructorTechDetail detail) {
		return repository.save(detail);
	}

	@Override
	public InstructorTechDetail findById(int detailsId) {
		return repository.findById(detailsId).get();
	}

	@Override
	public Instructor getInstructor(int id) {
		InstructorTechDetail instructorDetails = repository.findById(id).get();
		return instructorDetails.getInstruct();
	}

}
