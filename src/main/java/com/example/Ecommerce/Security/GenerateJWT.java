package com.example.Ecommerce.Security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.Ecommerce.Api.Model.LoginUser;

import jakarta.annotation.PostConstruct;

@Configuration
public class GenerateJWT {
 
	private static final String USERNAME_KEY = "USERNAME";
	 @Value("${jwt.algorithm.key}")
	  private String algorithmKey;
	  /** The issuer the JWT is signed with. */
	  @Value("${jwt.issuer}")
	  private String issuer;
	  /** How many seconds from generation should the JWT expire? */
	  @Value("${jwt.expiryInSeconds}")
	  private int expiryInSeconds;
	  /** The algorithm generated post construction. */
	  private Algorithm algorithm;
	 @PostConstruct
	  public void postConstruct() {
	    algorithm = Algorithm.HMAC256(algorithmKey);
	  }
	
	public String getjwt(LoginUser user) {
		return JWT.create()
		        .withClaim(USERNAME_KEY, user.getUsername())
		        .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
		        .withIssuer(issuer)
		        .sign(algorithm);
	}
	
	public String getUsername(String token) {
	    return JWT.decode(token).getClaim(USERNAME_KEY).asString();
	  }
	
	

}
