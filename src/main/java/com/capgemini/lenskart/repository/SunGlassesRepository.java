package com.capgemini.lenskart.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lenskart.entity.SunGlasses;




@Repository
public interface SunGlassesRepository extends CrudRepository<SunGlasses,Integer>{



}
