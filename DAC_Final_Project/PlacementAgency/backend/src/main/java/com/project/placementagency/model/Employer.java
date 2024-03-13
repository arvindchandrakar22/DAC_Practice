package com.project.placementagency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employer {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@Column(unique = true, length = 50)
	private String companyemail;
	private String companypassword;
	private String companyName;
//	@Column(unique = true)
	private double contact;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	private List<Job> jobs;
	
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jobs",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "job_id"))
//	private List<Job> jobs;
	
//	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Job_User> userJob;
	
}

