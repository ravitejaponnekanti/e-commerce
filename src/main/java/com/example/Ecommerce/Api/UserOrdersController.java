package com.example.Ecommerce.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.Model.LocalUser;
import com.example.Ecommerce.Model.WebOrders;
import com.example.Ecommerce.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class UserOrdersController {
	
	@Autowired
	OrderService orders;
	
	@GetMapping
	public List<WebOrders> getuserorder(@AuthenticationPrincipal LocalUser user ){
		return orders.getorders(user);
	}

}
