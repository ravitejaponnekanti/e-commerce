package com.example.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Dao.ProductDao;
import com.example.Ecommerce.Model.Product;

@Service
public class GetProducts {
	
	@Autowired
	ProductDao pd;
	
	public List<Product> getproduct(){
		return pd.findAll();
	}

}
