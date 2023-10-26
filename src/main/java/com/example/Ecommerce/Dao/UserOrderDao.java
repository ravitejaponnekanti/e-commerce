package com.example.Ecommerce.Dao;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Model.LocalUser;
import com.example.Ecommerce.Model.WebOrders;

@Repository
public interface UserOrderDao extends ListCrudRepository<WebOrders,Long> {
	 List<WebOrders> findByUser(LocalUser user);

}
