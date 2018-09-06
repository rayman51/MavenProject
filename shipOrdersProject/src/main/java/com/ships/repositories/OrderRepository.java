package com.ships.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;


@Repository
public interface OrderRepository extends CrudRepository<OrderInfo,Integer>{

		

}
