package com.ships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.CompanyRepository;
import com.ships.repositories.ShipRepository;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository companyRepository;
	public Iterable<ShippingCompany> FindAll() {

		return companyRepository.findAll();
	}
public ShippingCompany saveCompany(ShippingCompany s) {
		
		return companyRepository.save(s);
	}



}
