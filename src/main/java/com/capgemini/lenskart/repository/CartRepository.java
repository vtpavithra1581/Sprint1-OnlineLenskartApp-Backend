package com.capgemini.lenskart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Cart;



@Repository
public interface CartRepository extends CrudRepository<Cart,Integer> {

	
}
