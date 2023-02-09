package com.capgemini.lenskart.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.entity.User;
import com.capgemini.lenskart.repository.RegistrationRepository;
import com.capgemini.lenskart.service.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Autowired
    private RegistrationRepository repository;

	@Override
	public User findByUserNameAndPasswordAndRole(String userName, String password, String role) {
		// TODO Auto-generated method stub
		return repository.findByUserNameAndPasswordAndRole(userName,password,role);
	}


	
	

}
