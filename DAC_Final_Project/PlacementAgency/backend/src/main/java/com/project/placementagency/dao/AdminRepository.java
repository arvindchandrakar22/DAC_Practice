package com.project.placementagency.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.placementagency.model.Admin;
import com.project.placementagency.model.User;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Optional<Admin> findOneByNameIgnoreCaseAndEmailIgnoreCaseAndPassword(String name, String email, String password);

	Admin findOneByIdAndPassword(int id,String password);
}
