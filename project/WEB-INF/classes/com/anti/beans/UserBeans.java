package com.anti.beans;

import java.io.Serializable;

public class UserBeans  implements Serializable{

	//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time
	
	int id, user_time;
	
	String user_name, user_email, user_password, user_contact, user_group, user_otp,user_Message,user_status,user_token,user_new_password,user_new_group;

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getUser_new_group() {
		return user_new_group;
	}

	public void setUser_new_group(String user_new_group) {
		this.user_new_group = user_new_group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_new_password() {
		return user_new_password;
	}

	public void setUser_new_password(String user_new_password) {
		this.user_new_password = user_new_password;
	}

	public int getUser_time() {
		return user_time;
	}

	public void setUser_time(int user_time) {
		this.user_time = user_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_Message() {
		return user_Message;
	}

	public void setUser_Message(String user_Message) {
		this.user_Message = user_Message;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}

	public String getUser_group() {
		return user_group;
	}

	public void setUser_group(String user_group) {
		this.user_group = user_group;
	}

	public String getUser_otp() {
		return user_otp;
	}

	public void setUser_otp(String user_otp) {
		this.user_otp = user_otp;
	}
	
	
	
}
