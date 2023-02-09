package com.capgemini.lenskart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.lenskart.dto.CustomerDTO;
import com.capgemini.lenskart.dto.FrameDTO;
import com.capgemini.lenskart.dto.GlassDTO;
import com.capgemini.lenskart.dto.LensesDTO;
import com.capgemini.lenskart.dto.ProductDTO;
import com.capgemini.lenskart.dto.SunGlassesDTO;
import com.capgemini.lenskart.service.CustomerService;
import com.capgemini.lenskart.service.FrameService;
import com.capgemini.lenskart.service.GlassService;
import com.capgemini.lenskart.service.LensesService;
import com.capgemini.lenskart.service.ShoppingService;
import com.capgemini.lenskart.service.SunGlassesService;

@SpringBootTest
class LenskartAppRestApplicationTests {
	@Autowired
	private CustomerService customerService;
	//@Test
	void contextLoads() {
	}
	
	@Test
	void testGetCustomerById() {
		CustomerDTO c=customerService.getById(17);
		assertEquals("Bangalore", c.getAddress());
//	assertEquals("priya@123",c.getPassword());
	}
	
	@Test
	void testAllCustomer() {
		List<CustomerDTO> clist=customerService.findALL();
		assertEquals(13,clist.size());
	}
	
	@Autowired
	private FrameService frameService;
	
	@Test
	void testGetFrameById() {
		FrameDTO f=frameService.getById(13);
		assertEquals("round",f.getShape());
		assertEquals("blue",f.getColor());
	}
	
	@Test
	void testAllFrames() {
		List<FrameDTO> flist=frameService.findALL();
		assertEquals(6,flist.size());
	}
	
	@Autowired
	private LensesService lensesService;
	
	@Test
	void testGetLensesById() {
		LensesDTO l=lensesService.getById(26);
		assertEquals("oval",l.getShape());
		assertEquals("white",l.getColor());
		assertEquals(15,l.getQuantity());
	}
	
	@Test
	void testAllLenses() {
		List<LensesDTO> list=lensesService.findALL();
		assertEquals(1,list.size());
	}
	
	@Autowired
	private SunGlassesService sunglassesService;
	
	@Test
	void testGetSunGlassesById() {
		SunGlassesDTO s=sunglassesService.getById(25);
		assertEquals("OJOS",s.getBrand());
		assertEquals("blue",s.getFrameColor());
		assertEquals(1,s.getWeight());
	}
	
	@Test
	void testAllSunGlasses() {
		List<SunGlassesDTO> slist=sunglassesService.findALL();
		assertEquals(1,slist.size());
	}
	
	@Autowired
	private GlassService glassService;
	
	@Test
	void testGetGlassById() {
		GlassDTO g=glassService.getById(11);
		assertEquals("acuvue",g.getBrand());
		assertEquals("plastic",g.getType());
		assertEquals("https://www.lenskart.com/glasses.html",g.getImage());
	}
	
	@Test
	void testAllGlasses() {
		List<GlassDTO> glist=glassService.findALL();
		assertEquals(1,glist.size());
	}
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Test
	void testGetProductById() {
		ProductDTO p=shoppingService.getById(1);
		assertEquals("frame",p.getName());
		assertEquals(10000,p.getPrice());
	}
	
	@Test
	void testAllProducts() {
		List<ProductDTO> plist=shoppingService.findAll();
		assertEquals(14,plist.size());
	}
	
	
	

}
