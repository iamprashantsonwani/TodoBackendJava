package com.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
	
	//Filter chain
	//authenticate all requests
	//Use basic authentication
	//disabling csrf
	//stateless rest api
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http.authorizeRequests(
				auth ->
					auth
					.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.anyRequest().authenticated()
				)
		.httpBasic(Customizer.withDefaults())
		//whenever you are disbaling the csrf it's importtant make it stateless
		.sessionManagement(
				session -> session.sessionCreationPolicy
				(SessionCreationPolicy.STATELESS))
		.csrf().disable()
		 .build();
	}
}
