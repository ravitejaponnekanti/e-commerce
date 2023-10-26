package com.example.Ecommerce.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Service.GetProducts;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	GetProducts gp;
	
	@GetMapping
	public List<Product> getproduct(){
		return gp.getproduct();
	}

}
