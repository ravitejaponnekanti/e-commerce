package com.example.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Api.UserOrdersController;
import com.example.Ecommerce.Dao.UserOrderDao;
import com.example.Ecommerce.Model.LocalUser;
import com.example.Ecommerce.Model.WebOrders;

@Service
public class OrderService {
	
	@Autowired
	UserOrderDao uod;
	
	public List<WebOrders> getorders(LocalUser lu){
		return uod.findByUser(lu);
	}

}
