package com.capgemini.lenskart.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.capgemini.lenskart.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	@Query(value = "select p from Product  p where p.pid IN(select p1.product from Cart p1 where p1.customer.cid = :custId)")
	List<Product> findAllProductInCart(@Param("custId") int cid);


}
