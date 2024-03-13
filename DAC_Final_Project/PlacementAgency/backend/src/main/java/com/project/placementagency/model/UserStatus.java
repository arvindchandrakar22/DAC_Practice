package com.project.placementagency.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserStatus {

	private int statuscode;
	private User user;
	private String statusmessage;
	
	public UserStatus(int statuscode, User user, String statusmessage) {
	
		this.statuscode = statuscode;
		this.user = user;
		this.statusmessage = statusmessage;
	}
//	
//	public int getStatuscode() {
//		return statuscode;
//	}
//	public void setStatuscode(int statuscode) {
//		this.statuscode = statuscode;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public String getStatusmessage() {
//		return statusmessage;
//	}
//	public void setStatusmessage(String statusmessage) {
//		this.statusmessage = statusmessage;
//	}

	
}
