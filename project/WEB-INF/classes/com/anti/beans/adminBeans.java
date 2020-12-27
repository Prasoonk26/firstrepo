package com.anti.beans;

import java.io.Serializable;

public class adminBeans implements Serializable {

	int id;
	
	String admin_name;
	
	String admin_Password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public
	
	void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_Password() {
		return admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}
	
	
	
}
