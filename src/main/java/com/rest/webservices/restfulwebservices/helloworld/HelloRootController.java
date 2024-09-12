package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRootController {
	
	
	@GetMapping(path = "/basicauth")
	public String basicAuthCheck() {
		return "Success"; 
	}
	
	@GetMapping(path = "/")
	public String returnSomethingAtRootUrl() {
		return "Congratulations"; 
	}
}