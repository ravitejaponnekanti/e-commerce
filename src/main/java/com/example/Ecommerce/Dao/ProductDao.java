package com.example.Ecommerce.Dao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Model.Product;

@Repository
public interface ProductDao extends ListCrudRepository<Product, Long> {

}
