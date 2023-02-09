package com.capgemini.lenskart.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.Lenses;




@Repository
public interface LensesRepository extends CrudRepository<Lenses,Integer>{

	

}
