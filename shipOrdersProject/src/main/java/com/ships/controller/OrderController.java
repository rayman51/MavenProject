package com.ships.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;
import com.ships.services.OrderService;
import com.ships.services.ShipService;


@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;// makes use of orderService
	@Autowired
	private ShipService shipService;// makes use of shipService
	@Autowired
	private CompanyService companyService;// makes use of companyService
	
	private String errorMessage;
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String listOrders(Model model, HttpServletRequest h) {
		ArrayList<OrderInfo> s = (ArrayList<OrderInfo>) orderService.FindAll();

		model.addAttribute("orders", s);
	
		return "showOrders";
	}// listOrders lists orders to jsp
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String createOrder(@ModelAttribute("order") OrderInfo order, HttpServletRequest h, Model model) {
		//System.out.println("HTTP Request = " + h.getMethod());
		
		ArrayList<Ship> shp = (ArrayList<Ship>) shipService.findByShippingCompanyIsNull();
		ArrayList<ShippingCompany> comp = (ArrayList<ShippingCompany>) companyService.FindAll();	
		
		Map<Integer,String> shipsList = new HashMap<Integer,String>();// links id to ship name
		Map<Integer,String> companiesList = new HashMap<Integer,String>();// links id to company name
		
		for(Ship ship : shp)
		{
			shipsList.put((Integer)ship.getSid(),ship.getName()+" Cost = "+ship.getCost()) ;
			// put name and cost in drop down
		}// ship name
		
		for(ShippingCompany company : comp)
		{
			companiesList.put((Integer)company.getScid(),company.getName()+" Balance = "+company.getBalance());
			// put name and cost in dropdown
		}// company name 
		
		model.addAttribute("ships", shipsList);
		model.addAttribute("companies", companiesList);
		
		
		return "createOrder";
	}// createOrder sends info to createOrder page
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addOrderdb(@Valid @ModelAttribute("order") OrderInfo order, BindingResult result) {
		if(result.hasErrors())
		{
			return "redirect:errorPage";
		}// if
		
		OrderInfo s = new OrderInfo();
		
		ShippingCompany company = order.getShippingCompany();
		
		s.setShippingCompany(company);
		Ship ship = order.getShip();
		s.setShip(ship);
		String date = order.getDate();
		date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		s.setDate(date);
		
		if(company.getBalance().compareTo(ship.getCost())<=0)
		{
			this.errorMessage = "Insufficient credit to order this ship";
			return "redirect:errorPage";
		}
		else if(ship == null || company == null)
		{
			this.errorMessage = "Must select a company and a ship";
			return "redirect:errorPage";
		}
		else
		{
		orderService.saveOrder(s);
		
		BigDecimal balance = company.getBalance().subtract(ship.getCost());// take cost of ship from balance allowed
		company.setBalance(balance);// sets new balance for company
		companyService.saveCompany(company);
		
		
		return "redirect:showOrders";
		}
	}// addOrderdb
	@RequestMapping(value = "/errorPage", method = RequestMethod.GET)
	public String addOrder()
	{
		return "errorPage";
	}
	
	
	
}// main
