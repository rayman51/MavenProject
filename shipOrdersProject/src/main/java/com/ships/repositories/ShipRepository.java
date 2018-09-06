package com.ships.repositories;




import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.Ship;


@Repository
public interface ShipRepository extends CrudRepository<Ship,Integer>{

	

	public ArrayList<Ship> findByshippingCompanyIsNull();
	

}
