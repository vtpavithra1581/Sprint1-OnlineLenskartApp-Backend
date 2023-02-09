package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.GlassDTO;


public interface GlassService {
	
	public GlassDTO saveGlass(GlassDTO glassDTO);
	public GlassDTO updateGlass(GlassDTO glassDTO);
	public boolean deleteGlass(GlassDTO glasssDTO);
	public GlassDTO getById(int id);
	public List<GlassDTO>  findALL();
	

}
