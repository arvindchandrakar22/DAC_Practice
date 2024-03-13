package com.paginationAndFilter.studentDetails.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paginationAndFilter.studentDetails.model.StudentDetails;
import com.paginationAndFilter.studentDetails.repository.StudentDetailsRepository;
import com.paginationAndFilter.studentDetails.service.StudentDetailsService;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository; 
	
	@Override
	public List<StudentDetails> getAllDetails(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository.findAll(p);
		
		List<StudentDetails> contentPost = pagePost.getContent();
		
		return contentPost;
	}

	@Override
	public List<StudentDetails> getDetailsByAge(Integer pageNumber, Integer pageSize, int age) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository.findByAge(age, p);
		
		List<StudentDetails> contentPost = pagePost.getContent();
		
		return contentPost;
	}

	@Override
	public List<StudentDetails> getDetailsByGender(Integer pageNumber, Integer pageSize, String gender) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository.findByGender(gender,p);
		
		List<StudentDetails> pageContent = pagePost.getContent();
		
		return pageContent;
	}

	@Override
	public List<StudentDetails> getDetailsByBranch(Integer pageNumber, Integer pageSize, String branch) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository .findByBranch(branch,p);
		
		List<StudentDetails> pageContent = pagePost.getContent();
		
		return pageContent;
	}

	@Override
	public List<StudentDetails> getDetailsByPassOutYear(Integer pageNumber, Integer pageSize, int passOutYear) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository .findByPassOutYear(passOutYear,p);
		
		List<StudentDetails> pageContent = pagePost.getContent();
		
		return pageContent;
	}

	@Override
	public List<StudentDetails> getDetailsByCity(Integer pageNumber, Integer pageSize, String city) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository .findByCity(city,p);
		
		List<StudentDetails> pageContent = pagePost.getContent();
		
		return pageContent;
	}

	@Override
	public List<StudentDetails> getDetailsByState(Integer pageNumber, Integer pageSize, String state) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository .findByState(state,p);
		
		List<StudentDetails> pageContent = pagePost.getContent();
		
		return pageContent;
	}

	@Override
	public List<StudentDetails> getDetailsByYear_Of_Experience(Integer pageNumber, Integer pageSize,
			int year_Of_Experience) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<StudentDetails> pagePost = this.studentDetailsRepository .findByExperience(year_Of_Experience,p);
		
		List<StudentDetails> pageContent = pagePost.getContent();
		
		return pageContent;
	}

}
