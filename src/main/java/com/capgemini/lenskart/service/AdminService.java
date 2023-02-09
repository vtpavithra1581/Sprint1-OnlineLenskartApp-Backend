package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.AdminDTO;
import com.capgemini.lenskart.dto.ProductDTO;


public interface AdminService {
	
	public AdminDTO saveAdmin(AdminDTO adminDTO);
	public AdminDTO updateAdmin(AdminDTO adminDTO);
	public boolean deleteAdmin(AdminDTO adminDTO);
	public AdminDTO getAdminById(int id);
	public List<AdminDTO>  findALL();
	public ProductDTO getById(int id);
	public ProductDTO updateProduct(ProductDTO productDTO);
	public boolean deleteProduct(ProductDTO productDTO);
	public ProductDTO addProduct(ProductDTO productDTO);
	public List<ProductDTO> findAll(); 
}
