package com.project.placementagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.placementagency.model.Admin;
import com.project.placementagency.model.AdminStatus;
import com.project.placementagency.model.AppliedJobs;
import com.project.placementagency.model.Employer;
import com.project.placementagency.model.Job;
import com.project.placementagency.model.User;
import com.project.placementagency.model.UserStatus;

@Service
public interface UserService {

	UserStatus addUser(User userDetails);

	UserStatus getUser(String email,String password);

	UserStatus updateUser(User userDetails);

	List<AppliedJobs> getAppliedJobs(int uid);

	List<AppliedJobs> getAllJobs();
	
//	UserStatus addUserJob(int uid, int jid);
		
}
