package com.capgemini.lenskart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Admin;
import com.capgemini.lenskart.entity.Product;


@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer>{

	

}
