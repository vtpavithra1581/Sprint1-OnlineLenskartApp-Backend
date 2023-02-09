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

import com.capgemini.lenskart.dto.SunGlassesDTO;
import com.capgemini.lenskart.exception.SunGlassesNotFoundException;
import com.capgemini.lenskart.service.SunGlassesService;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/sunglasses")
public class SunGlassesController {
	
	@Autowired
	private SunGlassesService sunglassesService;
	
	//http://localhost:1581/api/sunglasses
	@PostMapping("/addsunglass")
	public SunGlassesDTO saveSunGlass(@RequestBody SunGlassesDTO sunglassDTO){
		sunglassesService.saveSunGlasses(sunglassDTO);
		return sunglassDTO;
		
	}
	
	//http://localhost:1581/api/sunglasses
	@GetMapping("/{id}")
	public ResponseEntity<SunGlassesDTO>getSunGlassById(@PathVariable Integer id){
		SunGlassesDTO sunglassDTO=sunglassesService.getById(id);
		return new ResponseEntity<SunGlassesDTO>(sunglassDTO,HttpStatus.FOUND);
	}

	//http://localhost:1581/api/sunglasses
	@PutMapping("/updatesunglass")
	public ResponseEntity<SunGlassesDTO> updateSunGlass(@RequestBody SunGlassesDTO dto){
		return new ResponseEntity<SunGlassesDTO>(sunglassesService.updateSunGlasses(dto),HttpStatus.ACCEPTED);
		
	}
	
	//http://localhost:1581/api/sunglasses/1
	@DeleteMapping("/deletesunglass/{id}")
	public ResponseEntity<Boolean>deleteGlassById(@PathVariable Integer id){
		SunGlassesDTO sunglassDTO=sunglassesService.getById(id);
		if(sunglassDTO !=null) {
			sunglassesService.deleteSunGlasses(sunglassDTO);
			return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
		}
		throw new SunGlassesNotFoundException("sunglass with id " +id+"does not exists");
	}
	
	//http://localhost:1581/api/sunglasses
	@GetMapping("/allsunglasses")
	public ResponseEntity<List<SunGlassesDTO>> getAllSunglasses(){
		List<SunGlassesDTO> list=sunglassesService.findALL();
		return ResponseEntity.ok(list);
	}
	
}