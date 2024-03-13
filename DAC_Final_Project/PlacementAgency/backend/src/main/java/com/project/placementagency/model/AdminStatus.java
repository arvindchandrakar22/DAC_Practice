package com.project.placementagency.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminStatus {

	private int statuscode;
	private Admin admin;
	private String statusmessage;

	
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getStatusmessage() {
		return statusmessage;
	}
	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

	
}
