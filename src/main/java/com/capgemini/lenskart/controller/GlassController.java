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


import com.capgemini.lenskart.dto.GlassDTO;
import com.capgemini.lenskart.exception.GlassNotFoundException;
import com.capgemini.lenskart.service.GlassService;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/glass")
public class GlassController {
	
	@Autowired
	private GlassService glassService;
	
	//http://localhost:1581/api/glass
	@PostMapping("/addglasses")
	public GlassDTO saveGlass(@RequestBody GlassDTO glassDTO){
		glassService.saveGlass(glassDTO);
		return glassDTO;
		}
	
	//http://localhost:1581/api/glass
	@GetMapping("/{id}")
	public ResponseEntity<GlassDTO>getGlassById(@PathVariable Integer id){
		GlassDTO glassDTO=glassService.getById(id);
		return new ResponseEntity<GlassDTO>(glassDTO,HttpStatus.FOUND);
	}

	//http://localhost:1581/api/glass
	@PutMapping("/updateglass")
	public ResponseEntity<GlassDTO> updateGlass(@RequestBody GlassDTO dto){
		return new ResponseEntity<GlassDTO>(glassService.updateGlass(dto),HttpStatus.ACCEPTED);

		
	}
	
	//http://localhost:1581/api/glass/1
	@DeleteMapping("/deleteglass/{id}")
	public ResponseEntity<Boolean>deleteGlassById(@PathVariable Integer id){
		GlassDTO glassDTO=glassService.getById(id);
		if(glassDTO !=null) {
			glassService.deleteGlass(glassDTO);
			return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
		}
		throw new GlassNotFoundException("Glass with id " +id+"does not exists");
	}
	
	//http://localhost:1581/api/glass
	@GetMapping("/allglass")
	public ResponseEntity<List<GlassDTO>> getAllGlass(){
		List<GlassDTO> list=glassService.findALL();
		return ResponseEntity.ok(list);
	}
	
}
