package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.PaymentDTO;




public interface PaymentService {
	

	public PaymentDTO addPayment(PaymentDTO paymentDTO);

	public PaymentDTO getById(int id);

	public List<PaymentDTO> findAll();
}
