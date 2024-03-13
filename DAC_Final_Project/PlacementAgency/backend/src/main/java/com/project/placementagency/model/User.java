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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(unique = true, length = 50)
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	@Column(length = 10)
	private String gender;
	private String address;
	private String qualification;
//	@Column(unique = true)
	private double contactNo;
	
//	@OneToOne
//	@JoinColumn(name = "jid")
//	private Job job;
//	
	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private List<Job> jobs;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_jobs",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "job_id"))
//	private List<Job> jobs;
	
//	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Job_User> userJob;
	
}
