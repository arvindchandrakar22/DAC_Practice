package com.paginationAndFilter.studentDetails.service;

import java.util.List;

import com.paginationAndFilter.studentDetails.model.StudentDetails;

public interface StudentDetailsService {

	List<StudentDetails> getAllDetails(Integer pageNumber, Integer pageSize);
	
	List<StudentDetails> getDetailsByAge(Integer pageNumber, Integer pageSize, int age);
	
	List<StudentDetails> getDetailsByGender(Integer pageNumber, Integer pageSize, String gender);
	
	List<StudentDetails> getDetailsByBranch(Integer pageNumber, Integer pageSize, String branch);
	
	List<StudentDetails> getDetailsByPassOutYear(Integer pageNumber, Integer pageSize, int passOutYear);
	
	List<StudentDetails> getDetailsByCity(Integer pageNumber, Integer pageSize, String city);
	
	List<StudentDetails> getDetailsByState(Integer pageNumber, Integer pageSize, String state);
	
	List<StudentDetails> getDetailsByYear_Of_Experience(Integer pageNumber, Integer pageSize, int year_Of_Experience);
}


