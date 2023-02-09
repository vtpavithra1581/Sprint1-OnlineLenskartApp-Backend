package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.entity.Admin;
import com.capgemini.lenskart.entity.Customer;
import com.capgemini.lenskart.entity.User;
import com.capgemini.lenskart.repository.CustomerRepository;
import com.capgemini.lenskart.repository.UserRepository;
import com.capgemini.lenskart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    private CustomerRepository repository;
    @Autowired
    private UserRepository userRepository;

 
	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		 



         
         Customer customers = new Customer();
         BeanUtils.copyProperties(customerDTO, customers);

         Customer saveCust=repository.save(customers);
        
         BeanUtils.copyProperties(saveCust,customerDTO);
                 return customerDTO;

		
	}



	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {


        Customer customers = new Customer();
        BeanUtils.copyProperties(customerDTO, customers);
        Customer saveCust=repository.save(customers);
        BeanUtils.copyProperties(saveCust,customerDTO);
        return customerDTO;
		

	
	}



	@Override
	public boolean deleteCustomer(CustomerDTO customerDTO) {
		  //Convert the DTO in the Entity object
        Customer customer=new Customer(); //Empty Entity Object
        BeanUtils.copyProperties(customerDTO, customer);
        repository.delete(customer);
        return true;
	}

	 @Override
	    public CustomerDTO getById(int id) {
	        Optional<Customer> customer=repository.findById(id);
	        if(customer.isPresent()) {
	            //Convert the entity to DTO
	            CustomerDTO dto=new CustomerDTO();
	            BeanUtils.copyProperties(customer.get(), dto);
	            return dto;
	        }
	        return null;
	    }

	 

	    @Override
	    public List<CustomerDTO> findALL() {
	        Iterable<Customer> list = repository.findAll();
	        List<CustomerDTO> dtos=new ArrayList<>();
	        for(Customer cust:list) {
	            CustomerDTO dto=new CustomerDTO();
	            BeanUtils.copyProperties(cust, dto);
	            dtos.add(dto);
	        }
	        return dtos;
	    }

 

    
}
