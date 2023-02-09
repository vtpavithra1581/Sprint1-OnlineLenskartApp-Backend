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

import com.capgemini.lenskart.dto.LensesDTO;
import com.capgemini.lenskart.exception.LensesNotFoundException;
import com.capgemini.lenskart.service.LensesService;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/lenses")
public class LensesController {
	
	@Autowired
	private LensesService lensesService;
	
	//http://localhost:1581/api/lenses
	@PostMapping("/addlenses")
	public LensesDTO saveLense(@RequestBody LensesDTO lenseDTO){
		lensesService.saveLenses(lenseDTO);
		return lenseDTO;
	}
	
	//http://localhost:1581/api/lenses
	@GetMapping("/{id}")
	public ResponseEntity<LensesDTO>getFrameById(@PathVariable Integer id){
		LensesDTO lenseDTO=lensesService.getById(id);
		return new ResponseEntity<LensesDTO>(lenseDTO,HttpStatus.FOUND);
	}

	@PutMapping("/updateglass")
	public ResponseEntity<LensesDTO> updateLense(@RequestBody LensesDTO dto){
		return new ResponseEntity<LensesDTO>(lensesService.updateLenses(dto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteglass/{id}")
	public ResponseEntity<Boolean>deleteLenseById(@PathVariable Integer id){
		LensesDTO lenseDTO=lensesService.getById(id);
		if(lenseDTO !=null) {
			lensesService.deleteLenses(lenseDTO);
			return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
		}
		throw new LensesNotFoundException("lense with id " +id+"does not exists");
	}
	
	
	@GetMapping("/allglass")
	public ResponseEntity<List<LensesDTO>> getAllLenses(){
		List<LensesDTO> list=lensesService.findALL();
		return ResponseEntity.ok(list);
	}


}
