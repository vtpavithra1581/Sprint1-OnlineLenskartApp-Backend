package com.capgemini.lenskart.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Frame;

@Repository
public interface FrameRepository extends CrudRepository<Frame,Integer> {

	
	

}
