package com.capgemini.lenskart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Integer> {
	
	
}
