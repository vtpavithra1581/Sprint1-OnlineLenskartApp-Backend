package com.capgemini.lenskart.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.capgemini.lenskart.entity.Glass;


@Repository
public interface GlassRepository extends CrudRepository<Glass,Integer>{

	

}
