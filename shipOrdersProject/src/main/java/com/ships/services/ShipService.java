package com.ships.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	@Autowired
	ShipRepository shipRepository;
	public Iterable<Ship> FindAll() {

		return shipRepository.findAll();
	}
	public Ship saveShip(Ship s) {
			
			return shipRepository.save(s);
		}
	
	public ArrayList<Ship> findByShippingCompanyIsNull() {
		// TODO Auto-generated method stub
		return shipRepository.findByshippingCompanyIsNull();

	}
	
	


}
