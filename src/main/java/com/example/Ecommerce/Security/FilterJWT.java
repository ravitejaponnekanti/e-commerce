package com.example.Ecommerce.Security;


import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.Ecommerce.Dao.SaveLocalUser;
import com.example.Ecommerce.Model.LocalUser;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterJWT extends OncePerRequestFilter{
	
	@Autowired
	GenerateJWT jwt;
	@Autowired
	SaveLocalUser slu;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tokenHeader = request.getHeader("Authorization");
	    if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
	      String token = tokenHeader.substring(7);
	      try {
	        String username = jwt.getUsername(token);
	        Optional<LocalUser> opUser = slu.findByUsernameIgnoreCase(username);
	        if (opUser.isPresent()) {
	          LocalUser user = opUser.get();
	          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList());
	          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	          SecurityContextHolder.getContext().setAuthentication(authentication);
	        }
	      } catch (JWTDecodeException ex) {
	      }
	    }
	    filterChain.doFilter(request, response);
	  }

		
}

