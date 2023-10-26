package com.example.Ecommerce.Security;

import org.springframework.security.web.access.intercept.AuthorizationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.Filter;




@Configuration
public class Securityconfig {
	
	@Autowired
	FilterJWT jwt;

@Bean	
public SecurityFilterChain filterchain(HttpSecurity http)throws Exception {
	http.csrf().disable().cors().disable();
	http.addFilterBefore(jwt,  AuthorizationFilter.class);
    http.authorizeHttpRequests()
    .requestMatchers("/products", "/auth/register", "/auth/login").permitAll()
    .anyRequest().authenticated();
    return http.build();
	
}


}
