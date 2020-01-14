package com.ensa.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true", origins = {"http://localhost:4200", "http://127.0.0.1:4200"})
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	@RequestMapping("/api/user")
	public Principal user( Principal user) {
		return user;
	}
} 
