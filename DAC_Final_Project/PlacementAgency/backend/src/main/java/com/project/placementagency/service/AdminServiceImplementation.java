package com.project.placementagency.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.placementagency.dao.AdminRepository;
import com.project.placementagency.model.Admin;
import com.project.placementagency.model.AdminStatus;

@Service
public class AdminServiceImplementation implements AdminService {

	
	@Autowired
	private AdminRepository repo;
	
	public AdminStatus addAdmin(Admin adminDetails) {
		// TODO Auto-generated method stub
		AdminStatus adminStatus =new AdminStatus(0,new Admin(),"Admin not added");
		if(!repo.existsById(adminDetails.getId()))
		{
		Admin admin = repo.save(adminDetails);
		adminStatus.setAdmin(adminDetails);
		adminStatus.setStatuscode(1);
		adminStatus.setStatusmessage("added admin details");
		}
		return adminStatus;
	}

	@Override
	public AdminStatus getAdmin(Admin adminDetails) {
		
		AdminStatus adminStatus = new AdminStatus(0,new Admin(),"Admin not found");
		Optional<Admin> x = repo.findOneByNameIgnoreCaseAndEmailIgnoreCaseAndPassword(adminDetails.getName(),adminDetails.getEmail(),adminDetails.getPassword());
		if(x.isPresent())
		{
		adminStatus.setAdmin(x.get());
		adminStatus.setStatuscode(1);
		adminStatus.setStatusmessage("Admin details found");
		}
		return adminStatus;
	}

}
