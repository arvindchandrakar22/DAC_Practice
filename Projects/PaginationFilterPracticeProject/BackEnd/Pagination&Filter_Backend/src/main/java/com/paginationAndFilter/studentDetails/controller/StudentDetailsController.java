package com.paginationAndFilter.studentDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paginationAndFilter.studentDetails.model.StudentDetails;
import com.paginationAndFilter.studentDetails.service.StudentDetailsService;

@RestController
@RequestMapping("api")
public class StudentDetailsController {

	@Autowired
	private StudentDetailsService studentDetailsService;
	
	@GetMapping("/details")
	public ResponseEntity<List<StudentDetails>> getAllDetails(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize
			)
	{
		
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getAllDetails(pageNumber, pageSize);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
		
	}
	
	@GetMapping("/Age/{age}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSameAge(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable("age") int age
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByAge(pageNumber, pageSize, age);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
	
	@GetMapping("/Gender/{gender}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSameGender(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable(value = "gender") String gender
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByGender(pageNumber, pageSize, gender);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
	
	@GetMapping("/Branch/{branch}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSameBranch(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable(value = "branch") String branch
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByBranch(pageNumber, pageSize, branch);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
	
	@GetMapping("/PassOutYear/{passOutYear}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSamePassOutYear(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable(value = "passOutYear") int passOutYear
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByPassOutYear(pageNumber, pageSize, passOutYear);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
	
	@GetMapping("/City/{city}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSameCity(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable(value = "city") String city
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByCity(pageNumber, pageSize, city);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
	
	@GetMapping("/State/{state}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSameState(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable(value = "state") String state
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByState(pageNumber, pageSize, state);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
	
	@GetMapping("/Experience/{experience}")
	public ResponseEntity<List<StudentDetails>> getDetailsOfSameYearOfExperience(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageSize,
			@PathVariable(value = "experience") int year_Of_Experience
			)
	{
		ResponseEntity<List<StudentDetails>> re = null;
		
		List<StudentDetails> detailedList = this.studentDetailsService.getDetailsByYear_Of_Experience(pageNumber, pageSize, year_Of_Experience);
		
		if(detailedList.isEmpty())
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.NOT_FOUND);
		}
		else
		{
			re=new ResponseEntity<List<StudentDetails>>(detailedList,HttpStatus.OK);
		}
		
		return re;
	}
}
