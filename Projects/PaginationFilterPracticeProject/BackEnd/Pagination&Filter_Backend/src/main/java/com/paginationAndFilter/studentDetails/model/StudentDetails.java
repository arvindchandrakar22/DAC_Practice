package com.paginationAndFilter.studentDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	@Column(columnDefinition = "CHAR CHECK(gender IN ('m','f'))")
	private String gender;
	private String branch;
	private int passOutYear;
	private String city;
	private String state;
	@Column(columnDefinition = "INTEGER DEFAULT 0")
	private int experience;
	
	
	
	public StudentDetails() {
		
	}

	public StudentDetails(int id, String name, int age, String gender, String branch, int passOutYear, String city,
			String state, int experience) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.branch = branch;
		this.passOutYear = passOutYear;
		this.city = city;
		this.state = state;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(int passOutYear) {
		this.passOutYear = passOutYear;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
