package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.CustomerDTO;



public interface CustomerService {
	
	public CustomerDTO saveCustomer(CustomerDTO customerDTO);
	public CustomerDTO updateCustomer(CustomerDTO customerDTO);
	public boolean deleteCustomer(CustomerDTO customerDTO);
	public CustomerDTO getById(int id);
	public List<CustomerDTO>  findALL();
	
}
