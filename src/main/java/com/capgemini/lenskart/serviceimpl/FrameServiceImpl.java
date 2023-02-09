package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.FrameDTO;
import com.capgemini.lenskart.entity.Frame;
import com.capgemini.lenskart.exception.FrameNotFoundException;
import com.capgemini.lenskart.repository.FrameRepository;
import com.capgemini.lenskart.service.FrameService;

@Service
public class FrameServiceImpl implements FrameService{

	@Autowired
	private FrameRepository repository;
	@Override
	public FrameDTO saveFrame(FrameDTO frameDTO) {
		//Convert the DTO in the Entity object
		Frame frame=new Frame(); //Empty Entity Object
		BeanUtils.copyProperties(frameDTO, frame);
		Frame framesave=repository.save(frame);
		frameDTO.setPid(framesave.getPid());
		return frameDTO;
	}

	@Override
	public FrameDTO updateFrame(FrameDTO frameDTO) {
		//Convert the DTO in the Entity object
				Frame frame=new Frame(); //Empty Entity Object
				BeanUtils.copyProperties(frameDTO, frame);
				repository.save(frame);
				return frameDTO;
	}

	@Override
	public boolean deleteFrame(FrameDTO frameDTO) {
		//Convert the DTO in the Entity object
				Frame frame=new Frame(); //Empty Entity Object
				BeanUtils.copyProperties(frameDTO, frame);
				repository.delete(frame);
				return true;
	}

	@Override
	public FrameDTO getById(int id) {
		Optional<Frame> frame=repository.findById(id);
		if(frame.isPresent()) {
			//Convert the entity to DTO
			FrameDTO dto=new FrameDTO();
			BeanUtils.copyProperties(frame.get(), dto);
			return dto;
		}
		throw new FrameNotFoundException ("The user with id "+id+" does not exists");
	}

	@Override
	public List<FrameDTO> findALL() {
		Iterable<Frame> list = repository.findAll();
		List<FrameDTO> dtos=new ArrayList<>();
		for(Frame fram:list) {
			FrameDTO dto=new FrameDTO();
			BeanUtils.copyProperties(fram, dto);
			dtos.add(dto);
		}
		return dtos;		
	}


}
