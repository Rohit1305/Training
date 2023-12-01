package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
