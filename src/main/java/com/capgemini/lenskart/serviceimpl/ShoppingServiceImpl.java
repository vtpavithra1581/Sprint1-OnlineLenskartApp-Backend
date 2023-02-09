package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.lenskart.dto.CartDTO;
import com.capgemini.lenskart.dto.PaymentDTO;
import com.capgemini.lenskart.dto.ProductDTO;
import com.capgemini.lenskart.entity.Admin;
import com.capgemini.lenskart.entity.Cart;
import com.capgemini.lenskart.entity.Customer;
import com.capgemini.lenskart.entity.Payment;
import com.capgemini.lenskart.entity.Product;
import com.capgemini.lenskart.repository.CartRepository;
import com.capgemini.lenskart.repository.CustomerRepository;
import com.capgemini.lenskart.repository.PaymentRepository;
import com.capgemini.lenskart.repository.ProductRepository;
import com.capgemini.lenskart.service.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;

	
	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		//Convert the DTO in the Entity object
		Product product=new Product(); //Empty Entity Object

		Product savePid=productRepository.save(product);
		productDTO.setPid(savePid.getPid());
		
		return productDTO;
	}
	
	@Override
	public CartDTO addItemsInCart(CartDTO cartDTO) {
		int cid=cartDTO.getCid();
		int pid=cartDTO.getPid();
		
	 Customer c=customerRepository.findById(cid).get();
	 Product p= productRepository.findById(pid).get();
	 
	 Cart cart=new Cart();
	 cart.setCustomer(c);
	 cart.setProduct(p);
	cart.setQuantity(cartDTO.getQuantity());
	
	cart= cartRepository.save(cart);
	if(cart.getId()!=0) 
		cartDTO.setCartid(cart.getId());
	
	else 
		cartDTO.setCartid(0);
	
		return cartDTO;
	}
	
	@Override
	public List<ProductDTO> findAll() {
		Iterable<Product> list = productRepository.findAll();
		List<ProductDTO> dtos=new ArrayList<>();
		for(Product product:list) {
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(product, dto);
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public boolean deleteProduct(ProductDTO productDTO) {
		//Convert the DTO in the Entity object
		Product product=new Product(); //Empty Entity Object
		BeanUtils.copyProperties(productDTO, product);
		productRepository.delete(product);
		return true;
	}
	
	@Override
	public List<Product> getProductsFromCart(int cid) {
		return productRepository.findAllProductInCart(cid);
		
	}

	@Override
	public ProductDTO getById(int id) {
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent()) {
			//Convert the entity to DTO
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(product.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		//Convert the DTO in the Entity object
		Product product=new Product(); //Empty Entity Object
		product.setPid(productDTO.getPid());
		BeanUtils.copyProperties(productDTO, product);
		productRepository.save(product);
		return productDTO;
	}

	
	
	

}
