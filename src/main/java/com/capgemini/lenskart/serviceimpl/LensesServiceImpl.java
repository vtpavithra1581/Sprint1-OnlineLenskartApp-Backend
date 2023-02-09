package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.LensesDTO;
import com.capgemini.lenskart.entity.Frame;
import com.capgemini.lenskart.entity.Lenses;
import com.capgemini.lenskart.exception.LensesNotFoundException;
import com.capgemini.lenskart.repository.LensesRepository;
import com.capgemini.lenskart.service.LensesService;


@Service
public class LensesServiceImpl implements LensesService{

	@Autowired
	private LensesRepository repository;

	@Override
	public LensesDTO saveLenses(LensesDTO lensesDTO) {
		//Convert the DTO in the Entity object
		Lenses lense=new Lenses(); //Empty Entity Object
		BeanUtils.copyProperties(lensesDTO, lense);
		Lenses lensesave=repository.save(lense);
		lensesDTO.setPid(lensesave.getPid());
		return lensesDTO;
	}

	@Override
	public LensesDTO updateLenses(LensesDTO lensesDTO) {
		//Convert the DTO in the Entity object
		Lenses lense=new Lenses(); //Empty Entity Object
		lense.setPid(lensesDTO.getPid());
		BeanUtils.copyProperties(lensesDTO, lense);
		repository.save(lense);
		return lensesDTO;
	}

	@Override
	public boolean deleteLenses(LensesDTO lensesDTO) {
		//Convert the DTO in the Entity object
		Lenses lense=new Lenses(); //Empty Entity Object
		BeanUtils.copyProperties(lensesDTO, lense);
		repository.delete(lense);
		return true;
	}

	@Override
	public LensesDTO getById(int id) {
		Optional<Lenses> lense=repository.findById(id);
		if(lense.isPresent()) {
			//Convert the entity to DTO
			LensesDTO dto=new LensesDTO();
			BeanUtils.copyProperties(lense.get(), dto);
			return dto;
		}
		throw new LensesNotFoundException ("The user with id "+id+" does not exists");
	}

	@Override
	public List<LensesDTO> findALL() {
		Iterable<Lenses> list = repository.findAll();
		List<LensesDTO> dtos=new ArrayList<>();
		for(Lenses lense:list) {
			LensesDTO dto=new LensesDTO();
			BeanUtils.copyProperties(lense, dto);
			dtos.add(dto);
		}
		return dtos;
	}


}
