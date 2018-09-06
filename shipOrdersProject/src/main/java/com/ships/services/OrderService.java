package com.ships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	public Iterable<OrderInfo> FindAll() {

		return orderRepository.findAll();
	}
	public OrderInfo saveOrder(OrderInfo s) {
		
		return orderRepository.save(s);
	}


}
