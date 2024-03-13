package com.project.placementagency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.placementagency.model.Admin;
import com.project.placementagency.model.AdminStatus;
import com.project.placementagency.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/add")
	public ResponseEntity<AdminStatus> addAdmin(@RequestBody Admin adminDetails) 
	{
		System.out.println("update controller function got input as " + adminDetails);
		
		ResponseEntity<AdminStatus> re=null;
		AdminStatus x = service.addAdmin(adminDetails);
		if(x.getStatuscode() == 0)
			re = new ResponseEntity<AdminStatus>(x,HttpStatus.NOT_FOUND);
		else
			re = new ResponseEntity<AdminStatus>(x,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/get")
	public ResponseEntity<AdminStatus> getAdmin(@RequestBody Admin adminDetails) 
	{
		System.out.println("controller function got input as " + adminDetails);
		
		ResponseEntity<AdminStatus> re=null;
		AdminStatus x = service.getAdmin(adminDetails);
		if(x.getStatuscode() == 0)
			re = new ResponseEntity<AdminStatus>(x,HttpStatus.NOT_FOUND);
		else
			re = new ResponseEntity<AdminStatus>(x,HttpStatus.OK);
		return re;
	}
}
