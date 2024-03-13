package com.user.userlocation.service.serviceimplementation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userlocation.model.User_location;
import com.user.userlocation.repository.UserRepository;
import com.user.userlocation.service.Userservice;

@Service
public class ServiceImplementation implements Userservice
{

	@Autowired
	private UserRepository userRepository;
	private User_location user;
	
	@Override
	public User_location adduser(User_location ul) {
		
		User_location localUser = this.userRepository.findByName(ul.getName());
		
		if(localUser != null) {
			System.out.println("User Already Present.");
		}
		User_location newuser = this.userRepository.save(ul);
		return newuser;
	}

	@Override
	public User_location updateuser(User_location ul, String name) {
		
		System.out.println(ul.getName());
		if(this.userRepository.existsByName(name))
		{
			System.out.println("Coming here....");
			System.out.println(ul.getName());
			ul.setId(userRepository.findByName(name).getId());
			this.userRepository.save(ul);
		}
		else
			System.out.println(ul.getName());
			System.out.println("User is already present !");
		return ul;
	}

	@Override
	public List<User_location> getuser(int n) {
		
		List<User_location> allUsers = this.userRepository.findAll();
		Collections.sort(allUsers, new Comparator<User_location>() {

			@Override
			public int compare(User_location o1, User_location o2) {
				// TODO Auto-generated method stub
				
				Integer d1 = (int) Math.sqrt(o1.getLatitude()*o1.getLatitude() + o1.getLongitude()*o1.getLongitude());
				Integer d2 = (int) Math.sqrt(o2.getLatitude()*o2.getLatitude() + o2.getLongitude()*o2.getLongitude());
				
				return d1.compareTo(d2);
			}
		});
		
		if(n<allUsers.size())
			return allUsers.subList(0,n);
		else
			return allUsers.subList(0,allUsers.size());
		
	}

	@Override
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		
		boolean bl = false;
	    User_location user = this.userRepository.findByName(name);
		if(user!=null)	
		{
			this.userRepository.deleteById(user.getId());
			bl=true;
		}
		else {
			System.out.println("User not found !!");
		}
		return bl;
		
	}
	

}
