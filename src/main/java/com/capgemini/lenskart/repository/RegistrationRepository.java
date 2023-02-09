package com.capgemini.lenskart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.User;
@Repository
public interface RegistrationRepository extends CrudRepository<User,Integer>{
	public User findByUserNameAndPasswordAndRole(String userName,String password,String role);

}
