package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.dto.PaymentDTO;
import com.capgemini.lenskart.entity.Cart;
import com.capgemini.lenskart.entity.Customer;
import com.capgemini.lenskart.entity.Payment;
import com.capgemini.lenskart.exception.PaymentDeclineException;
import com.capgemini.lenskart.repository.CartRepository;
import com.capgemini.lenskart.repository.PaymentRepository;
import com.capgemini.lenskart.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository repository;
	@Autowired 
	private CartRepository cartRepository;
	
	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
		
		Payment payment=new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		Cart cart=cartRepository.findById(paymentDTO.getCartId()).orElseThrow(()-> new PaymentDeclineException("payment not found"));
		payment.setCart(cart);
		repository.save(payment);
		return paymentDTO;
	}

	@Override
	public PaymentDTO getById(int id) {
		 Optional<Payment> payment=repository.findById(id);
	        if(payment.isPresent()) {
	            //Convert the entity to DTO
	            PaymentDTO dto=new PaymentDTO();
	            BeanUtils.copyProperties(payment.get(), dto);
	            return dto;
	        }
	        return null;
	}

	@Override
	public List<PaymentDTO> findAll() {
		  Iterable<Payment> list = repository.findAll();
		  List<PaymentDTO> dtos=new ArrayList<>();
		  for(Payment cust:list) {
			  PaymentDTO dto=new PaymentDTO();
			  BeanUtils.copyProperties(cust, dto);
			  dtos.add(dto);
		  }
		  return dtos;
	}
	
	

}
