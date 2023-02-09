package com.capgemini.lenskart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
	//Customer findByEmail(String email);
	
}
