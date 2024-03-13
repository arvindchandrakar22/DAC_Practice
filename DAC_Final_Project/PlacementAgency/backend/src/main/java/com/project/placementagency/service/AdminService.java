package com.project.placementagency.service;

import com.project.placementagency.model.Admin;
import com.project.placementagency.model.AdminStatus;

public interface AdminService {

	AdminStatus addAdmin(Admin adminDetails);

	AdminStatus getAdmin(Admin adminDetails);
	
}
