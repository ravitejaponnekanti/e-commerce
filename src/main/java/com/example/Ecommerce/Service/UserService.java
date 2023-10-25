package com.example.Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Api.Model.RegisterUser;
import com.example.Ecommerce.Dao.SaveLocalUser;
import com.example.Ecommerce.Model.LocalUser;
import com.example.Ecommerce.Exceptions.*;

@Service
public class UserService {
	
	@Autowired
	SaveLocalUser slu;
	@Autowired
	Encrypt en;
	

	public LocalUser saveuser(RegisterUser registrationBody) throws UserAlreadyExists {
		if(slu.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()||slu.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()) {
			throw new UserAlreadyExists();
		}
		LocalUser user= new LocalUser();
		   user.setEmail(registrationBody.getEmail());
		    user.setUsername(registrationBody.getUsername());
		    user.setFirstname(registrationBody.getFirstname());
		    user.setLastname(registrationBody.getLastname());
		    user.setPassword(en.encryptpassword(registrationBody.getPassword()));
		    return slu.save(user);
		
	}

}
