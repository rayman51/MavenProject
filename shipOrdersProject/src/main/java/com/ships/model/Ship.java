package com.ships.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ship {
	@Id
	@GeneratedValue
	private int sid;
	@NotNull
    @Size(min=1,max=250)
	private String name;
	@Min(value = 0)
	private int passengers;
	@NotNull
	private BigDecimal cost;
	@Min(value = 1)
	private double metres;
	
	@ManyToOne
	@JoinColumn(name="scid")
	private ShippingCompany shippingCompany;
		
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public double getMetres() {
		return metres;
	}
	public void setMetres(double metres) {
		this.metres = metres;
	}
	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ship [sid=" + sid + ", name=" + name + ", passengers=" + passengers + ", cost=" + cost + ", metres="
				+ metres + ", shippingCompany=" + shippingCompany + "]";
	}
	
	
}
