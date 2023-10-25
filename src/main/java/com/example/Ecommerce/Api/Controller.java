package com.example.Ecommerce.Api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.Api.Model.LoginResponse;
import com.example.Ecommerce.Api.Model.LoginUser;
import com.example.Ecommerce.Api.Model.RegisterUser;
import com.example.Ecommerce.Exceptions.UserAlreadyExists;
import com.example.Ecommerce.Model.LocalUser;
import com.example.Ecommerce.Service.LoginService;
import com.example.Ecommerce.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class Controller {
	 @Autowired
     UserService userservice;
	 @Autowired
	 LoginService loginservice;
     
	@PostMapping("/register")
	public ResponseEntity<?> saveuser(@Valid @RequestBody RegisterUser Ru ){
		try {
			userservice.saveuser(Ru);
			return ResponseEntity.ok().build();
			
		}catch(UserAlreadyExists ex){
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		}	
		
	}
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginUser lu){
		
		String jwt=loginservice.loginuser(lu);
		if(jwt==null) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}else {
			LoginResponse response = new LoginResponse();
		      response.setJwt(jwt);
		      return ResponseEntity.ok(response);
		}
		
	}
	
	
	 @GetMapping("/me")
	  public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user) {
	    return user;
	  }
}
