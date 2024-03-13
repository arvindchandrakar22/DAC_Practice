package com.project.placementagency.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface AppliedJobs {

	Employer getemployer();
	Job getjob();
	int getuid();
//	private List<Employer> employers;
//	private List<Job> jobs;
//	private String companyName;
//	private String jobDescp;
	
//	public AppliedJobs(Employer employer,Job job)
//	{
//		this.employer = employer;
//		this.job = job;
//	}
}
