package com.project.placementagency.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.placementagency.dao.AdminRepository;
import com.project.placementagency.dao.UserRepository;
import com.project.placementagency.model.Admin;
import com.project.placementagency.model.AppliedJobs;
import com.project.placementagency.model.Employer;
import com.project.placementagency.model.Job;
import com.project.placementagency.model.User;
import com.project.placementagency.model.UserStatus;


@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository repo;
	
	public UserStatus addUser(User userDetails) {
		// TODO Auto-generated method stub
		UserStatus userStatus =new UserStatus(0,new User(),"User not added");
		if(!repo.existsByEmail(userDetails.getEmail()))
		{
		System.out.println(userDetails.getUserId());
		repo.save(userDetails);
		System.out.println(userDetails.getUserId());
		userStatus.setUser(userDetails);
		userStatus.setStatuscode(1);
		userStatus.setStatusmessage("added user details");
		}
		return userStatus;
	}

	@Override
	public UserStatus getUser(String email,String password) {
		
		UserStatus userStatus =new UserStatus(0,new User(),"User not found");
		Optional<User> x = repo.findOneByEmailIgnoreCaseAndPassword(email,password);
		if(x.isPresent())
		{
		userStatus.setUser(x.get());
		userStatus.setStatuscode(1);
		userStatus.setStatusmessage("User details found");
		}
		return userStatus;
	}

//	@Override
//	public UserStatus addUserJob(int uid, int jid) {
//		
//		UserStatus userStatus =new UserStatus(0,new User(),"Error");
//		Optional<User> x = repo.findById(uid);
//		
//		if(x.isPresent())
//		{
//		repo.insertUser_Jobs(uid, jid);
//		User user = repo.findById(uid).get();
//		userStatus.setUser(user);
//		userStatus.setStatuscode(1);
//		userStatus.setStatusmessage("Job details added");
//		}
//		return userStatus;
//	}

	@Override
	public UserStatus updateUser(User userDetails) {
		
		UserStatus userStatus = new UserStatus(0,new User(),"User details not updated");
		int id = userDetails.getUserId();
		if(repo.findById(id).isPresent())
		{
		repo.save(userDetails);
		userStatus.setUser(userDetails);
		userStatus.setStatuscode(1);
		userStatus.setStatusmessage("User details updated");
		}
		return userStatus;
	}

	@Override
	public List<AppliedJobs> getAppliedJobs(int uid) {
		
		List<AppliedJobs> x = repo.getAppliedJobs(uid);
		if(x.isEmpty())
			x=null;
		
		return x;
	}
	
	@Override
	public List<AppliedJobs> getAllJobs() {
		
		List<AppliedJobs> x = repo.getAllJobs();
		if(x.isEmpty())
			x=null;
		
		return x;
	}

}
