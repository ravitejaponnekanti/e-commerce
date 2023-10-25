package com.example.Ecommerce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Api.Model.LoginUser;
import com.example.Ecommerce.Dao.SaveLocalUser;
import com.example.Ecommerce.Model.LocalUser;
import com.example.Ecommerce.Security.GenerateJWT;

import jakarta.validation.Valid;

@Service
public class LoginService {
	@Autowired
	GenerateJWT jwt;
	@Autowired
	SaveLocalUser slu;
	@Autowired
	Encrypt en;

	public String loginuser(@Valid LoginUser lu) {
		// TODO Auto-generated method stub
		Optional<LocalUser> opUser = slu.findByUsernameIgnoreCase(lu.getUsername());
		if(opUser.isPresent()) 
		{
			LocalUser user = opUser.get();
			if(en.cmppws(lu.getPassword(), user.getPassword())) {
				return jwt.getjwt(lu);
			}
			
		}
		return null;
			
	}
	
	

}
