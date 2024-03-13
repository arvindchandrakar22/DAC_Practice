package com.user.userlocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.userlocation.model.User_location;

public interface UserRepository extends JpaRepository<User_location, Long>
{

	User_location findByName(String name);

	boolean existsByName(String name);

	int deleteByName(String name);
	
	

}
