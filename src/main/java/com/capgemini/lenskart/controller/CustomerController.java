package com.capgemini.lenskart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.exception.CustomerNotFoundException;
import com.capgemini.lenskart.service.CustomerService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
    private CustomerService customerService;

    //http://localhost:1581/api/customers
    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return customerDTO;
        }

        //http://localhost:1581/api/customers/1
        @GetMapping("/{id}")
        public ResponseEntity<?> getCustomerById(@PathVariable int id) {
            CustomerDTO dto=customerService.getById(id);
            if(dto != null) {
                return new ResponseEntity<CustomerDTO>(dto,HttpStatus.FOUND);
            }
            throw new CustomerNotFoundException("Customer with id "+ id +"does not exist");

        }

        //http://localhost:1581/api/customers
        @GetMapping("/customers")
        public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
            List<CustomerDTO> list=customerService.findALL();
            return new ResponseEntity<List<CustomerDTO>>(list,HttpStatus.OK);

        }

        //http://localhost:1581/api/customers
        @DeleteMapping("/deletecustomers/{id}")
        public ResponseEntity<?> deleteCustomerById(@PathVariable int id) {
            CustomerDTO dto=customerService.getById(id);
            if(dto != null) {
                return new ResponseEntity<Boolean>(customerService.deleteCustomer(dto),HttpStatus.OK);
            }
            return new ResponseEntity<String>("The Customer id"+ id +"does not exists",HttpStatus.NOT_FOUND);

        }

        //http://localhost:1581/api/customers
        @PutMapping("/updatecustomers")
        public ResponseEntity<CustomerDTO>  updateCustomer(@RequestBody CustomerDTO dto) {
            return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(dto),HttpStatus.OK);
        }

}
