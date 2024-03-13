package com.project.placementagency.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Job {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;	
	private String jobCat;
	private String jobDescp;
	private String jobLocation;
	private double jobSalary;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid",referencedColumnName = "userId")
	private User user;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "eid",referencedColumnName = "companyId")
	private Employer employer;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private User users;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "jobs")
//	private List<User> users; 
	
//	@OneToMany(mappedBy = "jobs",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Job_User> jobUser;
}
