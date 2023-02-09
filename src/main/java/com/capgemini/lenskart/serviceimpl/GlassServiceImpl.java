package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.GlassDTO;
import com.capgemini.lenskart.entity.Frame;
import com.capgemini.lenskart.entity.Glass;
import com.capgemini.lenskart.exception.GlassNotFoundException;
import com.capgemini.lenskart.repository.GlassRepository;
import com.capgemini.lenskart.service.GlassService;


@Service
public class GlassServiceImpl implements GlassService{

	@Autowired
	private GlassRepository repository;

	@Override
	public GlassDTO saveGlass(GlassDTO glassDTO) {
		//Convert the DTO in the Entity object
		Glass glass=new Glass(); //Empty Entity Object
		BeanUtils.copyProperties(glassDTO, glass);
		Glass glasssave=repository.save(glass);
		glassDTO.setPid(glasssave.getPid());
		return glassDTO;
		}

	@Override
	public GlassDTO updateGlass(GlassDTO glassDTO) {
		//Convert the DTO in the Entity object
				Glass glass=new Glass(); //Empty Entity Object
				glass.setPid(glassDTO.getPid());
				BeanUtils.copyProperties(glassDTO, glass);
				repository.save(glass);
				return glassDTO;
	}

	@Override
	public boolean deleteGlass(GlassDTO glassDTO) {
		//Convert the DTO in the Entity object
				Glass glass=new Glass(); //Empty Entity Object
				BeanUtils.copyProperties(glassDTO, glass);
				repository.delete(glass);
				return true;
	}

	@Override
	public GlassDTO getById(int id) {
		Optional<Glass> glass=repository.findById(id);
		if(glass.isPresent()) {
			//Convert the entity to DTO
			GlassDTO dto=new GlassDTO();
			BeanUtils.copyProperties(glass.get(), dto);
			return dto;
		}
		throw new GlassNotFoundException ("The glass with id "+id+" does not exists");
	}

	@Override
	public List<GlassDTO> findALL() {
		Iterable<Glass> list = repository.findAll();
		List<GlassDTO> dtos=new ArrayList<>();
		for(Glass glas:list) {
			GlassDTO dto=new GlassDTO();
			BeanUtils.copyProperties(glas, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	
}
