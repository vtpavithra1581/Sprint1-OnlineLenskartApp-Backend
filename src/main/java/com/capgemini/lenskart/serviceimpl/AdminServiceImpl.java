package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.AdminDTO;
import com.capgemini.lenskart.dto.ProductDTO;
import com.capgemini.lenskart.entity.Admin;
import com.capgemini.lenskart.entity.Product;
import com.capgemini.lenskart.entity.User;
import com.capgemini.lenskart.repository.AdminRepository;
import com.capgemini.lenskart.repository.ProductRepository;
import com.capgemini.lenskart.repository.UserRepository;
import com.capgemini.lenskart.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
    private AdminRepository repository;
    @Autowired 
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    
	@Override
	public AdminDTO saveAdmin(AdminDTO adminDTO) {
		 	User user=new User();
	        user.setPassword(adminDTO.getPassword());
	        user.setRole("ADMIN");
	        user.setUserName(adminDTO.getUserName());
	        User userSave=userRepository.save(user);

	 


	        Admin admin = new Admin();
	        admin.setUser(userSave);
	        admin.setEmail(adminDTO.getEmail());
	        admin.setAddress(adminDTO.getAddress());
	       admin.setName(adminDTO.getName());
	        admin.setContactNumber(adminDTO.getContactNumber());
	        Admin saveId=repository.save(admin);
	        adminDTO.setId(saveId.getId());
	        adminDTO.setUserId(userSave.getId());
	                return adminDTO;
	}


	@Override
	public boolean deleteAdmin(AdminDTO adminDTO) {
		  //Convert the DTO in the Entity object
        Admin admin=new Admin(); //Empty Entity Object
        admin.setId(adminDTO.getId());
        //BeanUtils.copyProperties(adminDTO, admin);//
        repository.delete(admin);
        return true;

	}


	@Override
	public List<AdminDTO> findALL() {
		 Iterable<Admin> list = repository.findAll();
         List<AdminDTO> dtos=new ArrayList<>();
         for(Admin adm:list) {
             AdminDTO dto=new AdminDTO();
             BeanUtils.copyProperties(adm, dto);
             dtos.add(dto);
         }
         return dtos;
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
		 Product product=new Product(); //Empty Entity Object
	        product.setPid(productDTO.getPid());
	        BeanUtils.copyProperties(productDTO, product);
	        productRepository.save(product);
	        return productDTO;
	}

	@Override
	public boolean deleteProduct(ProductDTO productDTO) {
		Product product=new Product(); //Empty Entity Object
        BeanUtils.copyProperties(productDTO, product);
        productRepository.delete(product);
        return true;
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product=new Product(); //Empty Entity Object
        Product savePid=productRepository.save(product);
        productDTO.setPid(savePid.getPid());
        
        return productDTO;
	}

	@Override
	public List<ProductDTO> findAll() {
		Iterable<Product> list = productRepository.findAll();
        List<ProductDTO> dtos=new ArrayList<>();
        for(Product prd:list) {
            ProductDTO dto=new ProductDTO();
            BeanUtils.copyProperties(prd, dto);
            dtos.add(dto);
        }
        return dtos;

	}

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDTO) {
		User user=new User();
        user.setId(adminDTO.getUserId());

 

        Admin admin = new Admin();
        admin.setUser(user);
        admin.setEmail(adminDTO.getEmail());
        admin.setId(adminDTO.getId());
        admin.setName(adminDTO.getName());
        admin.setAddress(adminDTO.getAddress());
        admin.setContactNumber(adminDTO.getContactNumber());
        Admin saveId=repository.save(admin);
        adminDTO.setId(saveId.getId());
                return adminDTO;

	}

	@Override
	public AdminDTO getAdminById(int id) {
		Optional<Admin> admin=repository.findById(id);
        if(admin.isPresent()) {
            //Convert the entity to DTO
            AdminDTO dto=new AdminDTO();
            BeanUtils.copyProperties(admin.get(), dto);
            return dto;
        }
    return null;
		
	}

	

}
