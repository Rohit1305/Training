package com.aurionpro.payload;

import java.util.List;

import com.aurionpro.entity.Student;

import lombok.Data;

@Data
public class StudentPageDto {
	private List<Student> content;
	private int pageNumber;
	private int numberOfElements;
	private long totalElements;
	private int totalPages;
	private boolean hasNext;
	private boolean hasPrevious;
	private boolean isFirst;
	private boolean isLast;

}
