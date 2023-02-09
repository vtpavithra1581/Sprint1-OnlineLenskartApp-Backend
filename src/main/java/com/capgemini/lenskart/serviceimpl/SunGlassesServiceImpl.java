package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.SunGlassesDTO;
import com.capgemini.lenskart.entity.Frame;
import com.capgemini.lenskart.entity.Lenses;
import com.capgemini.lenskart.entity.SunGlasses;
import com.capgemini.lenskart.exception.SunGlassesNotFoundException;
import com.capgemini.lenskart.repository.SunGlassesRepository;
import com.capgemini.lenskart.service.SunGlassesService;

@Service
public class SunGlassesServiceImpl implements SunGlassesService{

	@Autowired
	private SunGlassesRepository repository;

	@Override
	public SunGlassesDTO saveSunGlasses(SunGlassesDTO sunglassesDTO) {
		//Convert the DTO in the Entity object
		SunGlasses sunglass=new SunGlasses(); //Empty Entity Object
		BeanUtils.copyProperties(sunglassesDTO, sunglass);
		SunGlasses sunglasssave=repository.save(sunglass);
		sunglassesDTO.setPid(sunglasssave.getPid());
		return sunglassesDTO;
		
	}

	@Override
	public SunGlassesDTO updateSunGlasses(SunGlassesDTO sunglassesDTO) {
		//Convert the DTO in the Entity object
		SunGlasses sunglass=new SunGlasses(); //Empty Entity Object
		sunglass.setPid(sunglassesDTO.getPid());
		BeanUtils.copyProperties(sunglassesDTO, sunglass);
		repository.save(sunglass);
		return sunglassesDTO;
		}

	@Override
	public boolean deleteSunGlasses(SunGlassesDTO sunglassesDTO) {
		//Convert the DTO in the Entity object
		SunGlasses sunglass=new SunGlasses(); //Empty Entity Object
		BeanUtils.copyProperties(sunglassesDTO, sunglass);
		repository.delete(sunglass);
		return true;
	}

	@Override
	public SunGlassesDTO getById(int id) {
		Optional<SunGlasses> sunglass=repository.findById(id);
		if(sunglass.isPresent()) {
			//Convert the entity to DTO
			SunGlassesDTO dto=new SunGlassesDTO();
			BeanUtils.copyProperties(sunglass.get(), dto);
			return dto;
		}
		throw new SunGlassesNotFoundException ("The user with id "+id+" does not exists");
	}

	@Override
	public List<SunGlassesDTO> findALL() {
		Iterable<SunGlasses> list = repository.findAll();
		List<SunGlassesDTO> dtos=new ArrayList<>();
		for(SunGlasses sunglass:list) {
			SunGlassesDTO dto=new SunGlassesDTO();
			BeanUtils.copyProperties(sunglass, dto);
			dtos.add(dto);
		}
		return dtos;
		}

}
