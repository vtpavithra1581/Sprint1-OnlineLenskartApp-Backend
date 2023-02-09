package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.FrameDTO;

public interface FrameService {
	
	public FrameDTO saveFrame(FrameDTO frameDTO);
	public FrameDTO updateFrame(FrameDTO frameDTO);
	public boolean deleteFrame(FrameDTO frameDTO);
	public FrameDTO getById(int id);
	public List<FrameDTO>  findALL();


}
