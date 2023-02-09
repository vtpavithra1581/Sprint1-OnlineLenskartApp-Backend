package com.capgemini.lenskart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Integer> {
	
	
}
