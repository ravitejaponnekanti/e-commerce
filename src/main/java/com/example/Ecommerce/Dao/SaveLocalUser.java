package com.example.Ecommerce.Dao;

import java.util.Optional;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Model.LocalUser;

@Repository
public interface SaveLocalUser extends ListCrudRepository<LocalUser, Long> {
	 Optional<LocalUser> findByUsernameIgnoreCase(String username);

	  Optional<LocalUser> findByEmailIgnoreCase(String email);
}
