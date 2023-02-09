package com.capgemini.lenskart.controller;

import java.util.List;

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

import com.capgemini.lenskart.dto.CartDTO;
import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.dto.ProductDTO;
import com.capgemini.lenskart.entity.Product;
import com.capgemini.lenskart.service.ShoppingService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ShoppingController {
	
	@Autowired
	private ShoppingService shoppingService;
	
	//http://localhost:1581/api/shopping/saveproducts
		@PostMapping("/products")
		public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
			shoppingService.addProduct(productDTO);
			return productDTO;
		}
		
	//http://localhost:1581/api/shopping
	@GetMapping("/allproducts")
	public ResponseEntity<List<ProductDTO>> getAllProduct(){
		List<ProductDTO> list=shoppingService.findAll();
		return ResponseEntity.ok(list);
		}
	
	//http://localhost:1581/api/shopping/1/deleteproducts
	@DeleteMapping("/products/{id}")
	public boolean deleteProduct(@PathVariable int id) {
		ProductDTO productDTO =shoppingService.getById(id);
		return shoppingService.deleteProduct(productDTO);
	}
	
	//http://localhost:1581/api/shopping
	@PostMapping("/cart")
	public CartDTO addItemInCart(@RequestBody CartDTO cartDTO) {
		shoppingService.addItemsInCart(cartDTO);
		return cartDTO;
	}
	//http://localhost:1581/api/shopping
	@GetMapping("/cart/{cid}")
	public List<Product>getProductsFromCart(@PathVariable ("cid") int cid){
		return shoppingService.getProductsFromCart(cid);
		
	}
	//http://localhost:1581/api/shopping/updateproducts	
	@PutMapping("/updateProducts")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<ProductDTO>(shoppingService.updateProduct(productDTO), HttpStatus.ACCEPTED);
	}
	

}
