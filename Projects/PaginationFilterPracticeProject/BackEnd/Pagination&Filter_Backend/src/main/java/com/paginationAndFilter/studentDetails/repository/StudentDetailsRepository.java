package com.paginationAndFilter.studentDetails.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paginationAndFilter.studentDetails.model.StudentDetails;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer>{

	Page<StudentDetails> findByAge(int age, Pageable p);

	Page<StudentDetails> findByGender(String gender, Pageable p);

	Page<StudentDetails> findByBranch(String branch, Pageable p);

	Page<StudentDetails> findByPassOutYear(int passOutYear, Pageable p);

	Page<StudentDetails> findByCity(String city, Pageable p);

	Page<StudentDetails> findByState(String state, Pageable p);

	Page<StudentDetails> findByExperience(int year_Of_Experience, Pageable p);

}
