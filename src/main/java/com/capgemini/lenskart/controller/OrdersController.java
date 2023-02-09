package com.capgemini.lenskart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.dto.OrdersDTO;
import com.capgemini.lenskart.exception.ProductsNotFoundException;
import com.capgemini.lenskart.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
/*	@Autowired 
	private OrdersService ordersService;

	@PostMapping("/addOrders")
	public ResponseEntity<OrdersDTO> addOrders(@RequestBody OrdersDTO ordersDTO){
		
			OrdersDTO orders = ordersService.addOrders(ordersDTO);
			return ResponseEntity.ok(orders);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdersDTO> getOrderById(@PathVariable int id){
		OrdersDTO ordersDTO=ordersService.getById(id);
		return new ResponseEntity<OrdersDTO>(ordersDTO, HttpStatus.FOUND);
	}
	
	@PutMapping
	public ResponseEntity<OrdersDTO> updateOrders(@RequestBody OrdersDTO ordersDTO){
		return new ResponseEntity<OrdersDTO>(ordersService.updateOrders(ordersDTO), HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteOrderById(@PathVariable int id){
		OrdersDTO ordersDTO=ordersService.getById(id);
		if(ordersDTO!=null) {
			ordersService.deleteOrders(ordersDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new ProductsNotFoundException("orders with id " +id+ "doesnot exists");
	}
	
	@GetMapping
	public ResponseEntity<List<OrdersDTO>> getAllOrders(){
		List<OrdersDTO> list=ordersService.findAll();
		return ResponseEntity.ok(list);
	}*/
}
