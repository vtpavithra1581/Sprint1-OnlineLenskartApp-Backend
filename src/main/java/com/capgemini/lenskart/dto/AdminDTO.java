package com.capgemini.lenskart.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdminDTO {
	
	private int id;
	private String name;
	private int userId;
	@NotBlank(message="The email could not be blank or null or empty")
	@Email(message="Please enter the valid email id",regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9.]{2,5}")
	private String email;
	@NotNull(message="The password should not be blank")
	@Size(min=3,max=15)
	private String password;
	private String UserName;
	private Long contactNumber;
	private String address;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
	
	
}
