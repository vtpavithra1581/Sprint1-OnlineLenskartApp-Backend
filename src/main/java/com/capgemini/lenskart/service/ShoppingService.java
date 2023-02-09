package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.CartDTO;
import com.capgemini.lenskart.dto.PaymentDTO;
import com.capgemini.lenskart.dto.ProductDTO;
import com.capgemini.lenskart.entity.Product;


public interface ShoppingService {
	
	
	public ProductDTO addProduct(ProductDTO productDTO);
	public CartDTO addItemsInCart(CartDTO cartDTO);
	public List<ProductDTO> findAll();
	public boolean deleteProduct(ProductDTO productDTO);
	public List<Product> getProductsFromCart(int cid);
	public ProductDTO getById(int id);
	public ProductDTO updateProduct(ProductDTO productDTO);
//	public PaymentDTO addPayment(PaymentDTO paymentDTO);

}
