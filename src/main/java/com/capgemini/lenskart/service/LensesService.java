package com.capgemini.lenskart.service;

import java.util.List;

import com.capgemini.lenskart.dto.LensesDTO;

public interface LensesService {
	
	public LensesDTO saveLenses(LensesDTO lensesDTO);
	public LensesDTO updateLenses(LensesDTO lensesDTO);
	public boolean deleteLenses(LensesDTO lensesDTO);
	public LensesDTO getById(int id);
	public List<LensesDTO>  findALL();


}
