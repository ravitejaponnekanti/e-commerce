package com.example.Ecommerce.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class Encrypt {
	 @Value("${encryption.salt.rounds}")
	  private int saltRounds;
	 private String salt;
	 
	 @PostConstruct
	  public void postConstruct() {
	    salt = BCrypt.gensalt(saltRounds);
	  }
	 
	 public String encryptpassword(String Password) {
		 return BCrypt.hashpw(Password, salt);	 
	 }
	 public boolean cmppws(String Password,String hash) {
		 return BCrypt.checkpw(Password, hash);
	 }

}
