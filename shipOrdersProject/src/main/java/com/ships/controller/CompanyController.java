package com.ships.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;
import com.ships.services.ShipService;


@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String listCompanies(Model model, HttpServletRequest h) {
		ArrayList<ShippingCompany> s = (ArrayList<ShippingCompany>) companyService.FindAll();

		model.addAttribute("companies", s);

		return "showShippingCompanies";
	}// listCompanies
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String addShippingCompany(@ModelAttribute("company") ShippingCompany company, HttpServletRequest h) {
		System.out.println("HTTP Request = " + h.getMethod());
		return "addShippingCompany";
	}// addShippingCompany
	
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addShippingCompanydb(@Valid @ModelAttribute("company") ShippingCompany company, BindingResult result) {
		if(result.hasErrors())
		{
			return "addShippingCompany";
		}// if
		
		ShippingCompany s = new ShippingCompany();
		
		String name = company.getName();
		String homePort = company.getHomePort();
		BigDecimal balance = company.getBalance();
		s.setName(name);
		s.setHomePort(homePort);
		s.setBalance(balance);
		companyService.saveCompany(s);
		
		return "redirect:showShippingCompanies";
	}// addShippingCompanydb
}// main
