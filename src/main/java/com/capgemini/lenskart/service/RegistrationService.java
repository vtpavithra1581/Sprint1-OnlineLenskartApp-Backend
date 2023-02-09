package com.capgemini.lenskart.service;

import com.capgemini.lenskart.entity.User;

public interface RegistrationService {
	public User findByUserNameAndPasswordAndRole(String userName,String password,String role);

}
