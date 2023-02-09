package com.capgemini.lenskart.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lenskart.dto.OrdersDTO;
import com.capgemini.lenskart.entity.Orders;
import com.capgemini.lenskart.exception.ProductsNotFoundException;
import com.capgemini.lenskart.repository.OrdersRepository;
import com.capgemini.lenskart.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepository repository;
	
	@Override
	public OrdersDTO addOrders(OrdersDTO ordersDTO) {
		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersDTO, orders);
		repository.save(orders);
		return ordersDTO;
	}

	@Override
	public OrdersDTO updateOrders(OrdersDTO ordersDTO) {
		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersDTO, orders);
		repository.save(orders);
		return ordersDTO;
	}

	@Override
	public boolean deleteOrders(OrdersDTO ordersDTO) {
		Orders orders = new Orders();
		BeanUtils.copyProperties(ordersDTO, orders);
		repository.delete(orders);
		return true;
	}

	@Override
	public OrdersDTO getById(int id) {
		Optional<Orders> orders = repository.findById(id);
		if (orders.isPresent()) {
			OrdersDTO dto = new OrdersDTO();
			BeanUtils.copyProperties(orders.get(), dto);
			return dto;
		}
		throw new ProductsNotFoundException("Products not Available at this time");
	}

	@Override
	public List<OrdersDTO> findAll() {
		Iterable<Orders> orders = repository.findAll();
		List<OrdersDTO> dtos = new ArrayList<>();
		for (Orders order : orders) {
			OrdersDTO dto = new OrdersDTO();
			BeanUtils.copyProperties(order, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
