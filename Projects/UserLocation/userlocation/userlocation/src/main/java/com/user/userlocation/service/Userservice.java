package com.user.userlocation.service;

import java.util.List;

import com.user.userlocation.model.User_location;

public interface Userservice {
	
	public User_location adduser(User_location ul);
	public User_location updateuser(User_location ul,String name);
	public List<User_location> getuser(int n);
	public boolean deleteUser(String name);
	

}
