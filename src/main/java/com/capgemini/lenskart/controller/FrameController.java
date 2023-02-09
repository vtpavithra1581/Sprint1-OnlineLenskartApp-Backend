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

import com.capgemini.lenskart.dto.FrameDTO;
import com.capgemini.lenskart.exception.FrameNotFoundException;
import com.capgemini.lenskart.service.FrameService;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/frame")
public class FrameController {
	
	@Autowired
	private FrameService frameService;
	
	
	//http://localhost:1581/api/frame
	@PostMapping("/addframe")
	public FrameDTO saveFrame(@RequestBody FrameDTO frameDTO){
		frameService.saveFrame(frameDTO);
		return frameDTO;
		}
		
	
	//http://localhost:1581/api/frame
	@GetMapping("/{id}")
	public ResponseEntity<FrameDTO>getFrameById(@PathVariable Integer id){
		FrameDTO frameDTO=frameService.getById(id);
		return new ResponseEntity<FrameDTO>(frameDTO,HttpStatus.FOUND);
	}

	//http://localhost:1581/api/frame
	@PutMapping("/updateframe")
	public ResponseEntity<FrameDTO> updateFrame(@RequestBody FrameDTO dto){
			return new ResponseEntity<FrameDTO>(frameService.updateFrame(dto),HttpStatus.ACCEPTED);
		}
		
	
	
	//http://localhost:1581/api/frame/1/deleteframe
	@DeleteMapping("/deleteframe/{id}")
	public ResponseEntity<Boolean>deleteFrameById(@PathVariable Integer id){
		FrameDTO frameDTO=frameService.getById(id);
		if(frameDTO !=null) {
			frameService.deleteFrame(frameDTO);
			return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
		}
		throw new FrameNotFoundException("frame with id " +id+"does not exists");
	}
	
	//http://localhost:1581/api/frame
	@GetMapping("/allframes")
	public ResponseEntity<List<FrameDTO>> getAllFrames(){
		List<FrameDTO> list=frameService.findALL();
		return ResponseEntity.ok(list);
	}

}
