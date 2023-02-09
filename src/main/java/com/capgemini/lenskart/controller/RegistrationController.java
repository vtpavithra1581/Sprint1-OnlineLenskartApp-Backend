package com.capgemini.lenskart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.entity.User;
import com.capgemini.lenskart.service.RegistrationService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class RegistrationController {
	@Autowired
    private RegistrationService userService;
	
	//http://localhost:1581/api/users
    @PostMapping("/login")
    public User loginCustomer(@RequestBody User user) throws Exception{
    	String tempUserName=user.getUserName();
    	String tempPass=user.getPassword();
    	String tempRole=user.getRole();
    	User userObj=null;
    	
    	if(tempUserName != null && tempPass != null && tempRole!=null) {
    		userObj=userService.findByUserNameAndPasswordAndRole(tempUserName,tempPass,tempRole);
    	}
    	if(userObj==null) {
    		throw new Exception("Bad credentials");
    	}
    	return userObj;
    	
    
	
}
}
