package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.SunGlassesDTO;

public interface SunGlassesService {
	
	public SunGlassesDTO saveSunGlasses(SunGlassesDTO sunglassesDTO);
	public SunGlassesDTO updateSunGlasses(SunGlassesDTO sunglassesDTO);
	public boolean deleteSunGlasses(SunGlassesDTO sunglassesDTO);
	public SunGlassesDTO getById(int id);
	public List<SunGlassesDTO>  findALL();
	

}
