package com.capgemini.lenskart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.dto.PaymentDTO;
import com.capgemini.lenskart.exception.CustomerNotFoundException;
import com.capgemini.lenskart.exception.PaymentDeclineException;
import com.capgemini.lenskart.service.PaymentService;

@RestController
@RequestMapping("/api/payments")

public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/addPayment")
	public PaymentDTO addPayment(@RequestBody PaymentDTO paymentDTO){
		paymentService.addPayment(paymentDTO);
	     return paymentDTO;
		
	}


	
	
	
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> getAllPayment(){
		List<PaymentDTO> list=paymentService.findAll();
		return ResponseEntity.ok(list);
	}

}
